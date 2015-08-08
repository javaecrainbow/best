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
import org.springframework.web.bind.annotation.ResponseBody;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.salk.best.booking.service.ExportService;
import com.salk.best.booking.service.ImportService;
import com.salk.best.domain.Export;
import com.salk.best.domain.User;
import com.salk.best.web.dto.AjaxResult;

@Controller
@RequestMapping("/export/")
public class ExportController extends BaseController {
	@Autowired
	private ExportService exportService;
	@Autowired
	private ImportService importService;

	@RequestMapping("/export.html")
	@ResponseBody
	public String exportForHandler(Model model, Export export, HttpServletRequest request) {
		User loginUser = getLoginUser(request);
		export.setAdderName(loginUser == null ? "" : loginUser.getUsername());
		export.setUpdaterName(loginUser == null ? "" : loginUser.getUsername());
		int status = 1;
		try {
			status = exportService.txExport(export);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			status = 2;
			e.printStackTrace();
		}
		if (status == 2) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			result.setMessage("fail");
			result.setForward("/export/list.html");
			result.setForwardConfirm("ok");
			return net.sf.json.JSONObject.fromObject(result).toString();
		} else if (status == 1) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			result.setMessage("success");
			result.setForward("/export/list.html");
			result.setForwardConfirm("ok");
			return net.sf.json.JSONObject.fromObject(result).toString();
		} else if (status == 0) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("300");
			result.setMessage("nums exceed limit");
			result.setForward("/export/list.html");
			result.setForwardConfirm("ok");
			return net.sf.json.JSONObject.fromObject(result).toString();
		}
		return null;
	}

	@RequestMapping("list.html")
	public String listForHandler(Model model, Export export, String pageSize, String pageCurrent, String orderField,
			String orderDirection, HttpServletRequest request) {
		long buildTotalPage = buildTotalPage(model, export);

		List<Export> exports = exportService.getExportsByPage(export,
				buildPageCommand(request, pageCurrent, pageSize, buildTotalPage, orderField, orderDirection));
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		model.addAttribute("exports", exports);
		User attribute = (User) request.getSession().getAttribute("loginInfo");
		if (attribute != null) {
			model.addAttribute("loginInfo", attribute);
		}
		return "export/export_list";
	}

	private long buildTotalPage(Model model, Export export) {
		long total = exportService.getTotalExports(export);
		model.addAttribute("totalPage", total);
		return total;
	}

	@RequestMapping("add_home.html")
	public String addHomeForHandler(Model model) {
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		return "export/input";
	}

	@RequestMapping("edit/{id}.html")
	public String editForHandle(Model model, Export export, @PathVariable String id) {
		Export findExport = exportService.findExport(id);
		// getFormatDate
		findExport.setStrExportDate(getFormatDate(findExport.getExportDate()));
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		if (findExport != null) {
			model.addAttribute("exports", findExport);
		}
		return "export/input";
	}

	@RequestMapping("delete.html")
	@ResponseBody
	public String deleteForHandle(Model model, Export export, String delids) throws Exception {
		if (StringUtils.isBlank(delids)) {
			return null;
		}
		boolean deleteExport = exportService.txdeleteExport(delids);
		if (deleteExport) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			result.setMessage("success");
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
