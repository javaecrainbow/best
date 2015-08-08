package com.salk.best.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salk.best.booking.service.ImportService;
import com.salk.best.booking.service.ItemService;
import com.salk.best.booking.service.ProductService;
import com.salk.best.domain.Item;
import com.salk.best.domain.Product;
import com.salk.best.web.dto.ImportFacetdto;
import com.salk.best.web.dto.ImportSize;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {
	@Autowired
	private ImportService importService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ProductService productService;

	@RequestMapping("/query.html")
	public String queryForHandler(Model model, String importType) {
		List<Item> queryItems = itemService.queryItems(new Item());
		model.addAttribute("items", queryItems);
		appendSizeOptions(model);
		if (StringUtils.isBlank(importType) && CollectionUtils.isNotEmpty(queryItems)) {
			importType = queryItems.get(0).getTypeName();
		}
		// List<Import> queryImportsByFacet =
		// importService.queryImportsByFacet(importType);
		Product prod = new Product();
		prod.setProdType(importType);
		List<Product> queryProducts = productService.queryProducts(prod);
		List<ImportFacetdto> convert = convert(queryProducts);

		// List<ImportFacetdto> convert = convert(queryImportsByFacet);
		model.addAttribute("importType", importType);

		model.addAttribute("facetList", convert);
		return "customer/query";
	}

	private List<ImportFacetdto> convert(List<Product> products) {
		Map<String, ImportFacetdto> dtosMaps = new HashMap<String, ImportFacetdto>();
		List<ImportFacetdto> dtos = new ArrayList<ImportFacetdto>();
		for (Product p : products) {
			if (!dtosMaps.containsKey(p.getProdNo())) {
				ImportFacetdto importFacet = new ImportFacetdto();
				importFacet.setImportName(p.getProdName());
				importFacet.setProdNo(p.getProdNo());

				ImportSize importSize = new ImportSize(p.getProdSize(), p.getNums());
				importFacet.addSizes(importSize);
				importFacet.setTotal(p.getNums());
				importFacet.setImportType(p.getProdType());
				dtosMaps.put(p.getProdNo(), importFacet);
			} else {
				ImportFacetdto importFacetdto = dtosMaps.get(p.getProdNo());
				ImportSize importSize = null;
				if (importFacetdto.getSizes().containsKey(p.getProdNo())) {
					importSize = importFacetdto.getSizes().get(p.getProdSize());
					importSize.setCount(importSize.getCount() + p.getNums());
				} else {
					importSize = new ImportSize(p.getProdSize(), p.getNums());
					importFacetdto.addSizes(importSize);

				}
				importFacetdto.setTotal(importFacetdto.getTotal() + p.getNums());
				importFacetdto.setImportType(p.getProdType());

			}

		}
		for (Map.Entry<String, ImportFacetdto> entry : dtosMaps.entrySet()) {
			dtos.add(entry.getValue());
		}
		return dtos;
	}
}
