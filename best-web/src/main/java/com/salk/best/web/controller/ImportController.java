package com.salk.best.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.salk.best.booking.service.ImportService;
import com.salk.best.booking.service.ProductService;
import com.salk.best.domain.Import;
import com.salk.best.domain.Product;
import com.salk.best.domain.User;
import com.salk.best.web.dto.AjaxResult;

@Controller
@RequestMapping("/import/")
public class ImportController extends BaseController {
	@Autowired
	private ImportService importService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "import.html", method = RequestMethod.POST)
	@ResponseBody
	public String importForHandler(Model model, Import imports, HttpServletRequest request) throws Exception {
		User loginUser = getLoginUser(request);
		imports.setAdderName(loginUser == null ? "" : loginUser.getUsername());
		imports.setUpdaterName(loginUser == null ? "" : loginUser.getUsername());

		boolean status = false;
		if (imports.getId() != null && imports.getId() != 0) {
			Product prod = buildProdDomain(imports, "update");
			status = importService.txUpdateImport(imports, prod);
		} else {
			Product prod = buildProdDomain(imports, "add");
			status = importService.txAdImport(imports, prod);
		}
		if (status) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			result.setMessage("success");
			result.setCloseCurrent(true);
			result.setForward("/import/list.html");
			return net.sf.json.JSONObject.fromObject(result).toString();
		}
		return null;
	}

	private Product buildProdDomain(Import imports, String type) {
		Product prod = new Product();
		prod.setProdColor(imports.getImportColor());
		prod.setProdName(imports.getImportName());
		prod.setProdNo(imports.getImportProdId());
		prod.setProdSize(imports.getImportSize());
		prod.setProdType(imports.getImportType());
		prod.setNums(imports.getNums());
		prod.setUpdaterName(imports.getUpdaterName());
		prod.setUpdateNo(imports.getUpdaterName());
		if ("add".equals(type)) {
			prod.setAddTime(new Date());
			prod.setAdderName(imports.getUpdaterName());
			prod.setAdderNo(imports.getUpdaterName());
		}
		return prod;
	}

	@RequestMapping("add_home.html")
	public String addHomeForHandler(Model model) {
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		return "import/input";
	}

	@RequestMapping("list.html")
	public String listForHandler(Model model, Import i, String pageSize, String pageCurrent, String orderField,
			String orderDirection, HttpServletRequest request) {
		long buildTotalPage = buildTotalPage(model, i);

		List<Import> imports = importService.getImportsByPage(i,
				buildPageCommand(request, pageCurrent, pageSize, buildTotalPage, orderField, orderDirection));
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		model.addAttribute("imports", imports);
		User attribute = (User) request.getSession().getAttribute("loginInfo");
		if (attribute != null) {
			model.addAttribute("loginInfo", attribute);
		}
		return "import/import_list";
	}

	private long buildTotalPage(Model model, Import i) {
		long total = importService.getTotalImports(i);
		model.addAttribute("totalPage", total);
		return total;
	}

	private long buildTotalProdNamePage(Model model, Import i) {
		// long total = importService.getTotalProdNameByPage(i);
		long countProduct = productService.countProduct(buildProdDomain(i, "update"));
		model.addAttribute("totalPage", countProduct);
		return countProduct;
	}

	@RequestMapping("lookup/list.html")
	public String lookupForHandler(Model model, Import i, String pageSize, String pageCurrent, String orderField,
			String orderDirection, HttpServletRequest request) {
		long buildTotalPage = buildTotalProdNamePage(model, i);

		List<Product> imports = productService.getProductsByPage(buildProdDomain(i, "other"),
				buildPageCommand(request, pageCurrent, pageSize, buildTotalPage, orderField, orderDirection));

		model.addAttribute("products", imports);
		return "export/export_getData";
	}

	@RequestMapping("lookup/list_prod_name.html")
	public String lookup4ProdNameForHandler(Model model, Import i, String pageSize, String pageCurrent,
			String orderField, String orderDirection, HttpServletRequest request) {
		long buildTotalPage = buildTotalProdNamePage(model, i);

		List<Product> imports = productService.getProductsByPage(buildProdDomain(i, "other"),
				buildPageCommand(request, pageCurrent, pageSize, buildTotalPage, orderField, orderDirection));

		model.addAttribute("products", imports);
		return "export/import_getProdName";
	}

	@RequestMapping("edit/{id}.html")
	public String editForHandle(Model model, Import i, @PathVariable String id) {
		Import findImport = importService.findImport(id);
		findImport.setStrImportDate(getFormatDate(findImport.getImportDate()));

		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		if (findImport != null) {
			model.addAttribute("import", findImport);
		}
		return "import/input";
	}

	@RequestMapping("delete.html")
	@ResponseBody
	public String deleteForHandle(Model model, Import i, String delids, HttpServletRequest request) throws Exception {
		if (StringUtils.isBlank(delids)) {
			return null;
		}

		boolean deleteExport = importService.txdeleteImport(delids);
		if (deleteExport) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			try {
				result.setMessage("success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return net.sf.json.JSONObject.fromObject(result).toString();
		}
		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
