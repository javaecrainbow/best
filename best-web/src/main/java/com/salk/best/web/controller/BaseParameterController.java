package com.salk.best.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.salk.best.booking.service.ItemService;
import com.salk.best.domain.Import;
import com.salk.best.domain.Item;
import com.salk.best.web.dto.AjaxResult;

@Controller
public class BaseParameterController extends BaseController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/add.html")
	@ResponseBody
	public String itemAddForHandler(ModelAndView view, HttpServletRequest request, Item item) {
		boolean status = false;
		if (item.getId() != null && item.getId() != 0) {
			status = itemService.editItem(item);
		} else {
			status = itemService.addItem(item);
		}
		if (status) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			result.setMessage("success");
			result.setCloseCurrent(true);
			result.setForward("/item/list.html");
			return net.sf.json.JSONObject.fromObject(result).toString();
		}
		return null;
	}

	@RequestMapping("/item/edit/{id}.html")
	public String itemEditForHandler(Model model, Import i, @PathVariable String id) {
		Item item = itemService.findItem(id);
		if (item != null) {
			model.addAttribute("item", item);
		}
		return "system/item_input";
	}

	@RequestMapping("/item/delete.html")
	@ResponseBody
	public String deleteForHandle(Model model, Import i, String delids, HttpServletRequest request) {
		if (StringUtils.isBlank(delids)) {
			return null;
		}

		boolean deleteExport = itemService.deleteItem(delids);
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

	private long buildTotalPage(Model model, Item i) {
		long total = itemService.countItem(i);
		model.addAttribute("totalPage", total);
		return total;
	}

	@RequestMapping("/item/list.html")
	public String listForHandler(Model model, Item i, String pageSize, String pageCurrent, String orderField,
			String orderDirection, HttpServletRequest request) {
		long buildTotalPage = buildTotalPage(model, i);

		List<Item> items = itemService.getItemsByPage(i,
				buildPageCommand(request, pageCurrent, pageSize, buildTotalPage, orderField, orderDirection));
		model.addAttribute("items", items);
		return "system/item_list";
	}
}
