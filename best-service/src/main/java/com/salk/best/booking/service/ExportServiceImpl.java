package com.salk.best.booking.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salk.best.domain.Export;
import com.salk.best.domain.ExportExample;
import com.salk.best.domain.Page;
import com.salk.best.domain.Product;
import com.salk.best.product.dao.ExportMapper;
import com.salk.best.product.dao.ImportMapper;

@Service
public class ExportServiceImpl implements ExportService {
	@Autowired
	private ExportMapper exportMapper;
	@Autowired
	private ImportMapper importMapper;
	@Autowired
	private ProductService productService;

	@Override
	public boolean addExport(Export e) throws Exception {
		exportMapper.insert(e);
		return true;
	}

	@Override
	public List<Export> getExports(Export e) {
		// example.setOrderByClause("or");

		List<Export> selectByExample = exportMapper.selectByExample(getExportExample(e));
		return selectByExample;
	}

	private ExportExample getExportExample(Export e) {
		ExportExample example = new ExportExample();
		com.salk.best.domain.ExportExample.Criteria createCriteria = example.createCriteria();
		if (StringUtils.isNotBlank(e.getExportNo())) {
			createCriteria.andExportNoEqualTo(e.getExportNo());
		}
		if (StringUtils.isNotBlank(e.getExportProdId())) {
			createCriteria.andExportProdIdEqualTo(e.getExportProdId());
		}
		if (StringUtils.isNotBlank(e.getExportColor())) {
			createCriteria.andExportColorEqualTo(e.getExportColor());
		}
		if (StringUtils.isNotBlank(e.getExportSize())) {
			createCriteria.andExportSizeEqualTo(e.getExportSize());
		}
		if (StringUtils.isNotBlank(e.getExportName())) {
			createCriteria.andExportNameLike("%" + e.getExportName() + "%");
		}
		if (StringUtils.isNotBlank(e.getExportType())) {
			createCriteria.andExportTypeEqualTo(e.getExportType());
		}
		return example;
	}

	@Override
	public Export findExport(String id) {
		Integer it_id = Integer.parseInt(id);
		Export selectByPrimaryKey = exportMapper.selectByPrimaryKey(it_id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean deleteExport(String ids) {
		if (StringUtils.isBlank(ids)) {
			return false;
		}

		int updateCount = exportMapper.deleteByPrimaryKeys(ids.split(","));

		return updateCount > 0 ? true : false;
	}

	@Override
	public boolean txdeleteExport(String ids) throws Exception {
		if (StringUtils.isBlank(ids)) {
			return false;
		}
		for (String id : ids.split(",")) {
			int id_int = Integer.parseInt(id);
			Export selectByPrimaryKey = exportMapper.selectByPrimaryKey(id_int);
			int deleteByPrimaryKey = exportMapper.deleteByPrimaryKey(id_int);
			productService.updateProductNums(selectByPrimaryKey.getProdNo(), 0 - selectByPrimaryKey.getNums());
		}
		return true;
	}

	@Override
	public boolean updateByKey(Export e) throws Exception {
		// TODO Auto-generated method stub
		return exportMapper.updateByPrimaryKey(e) > 0 ? true : false;
	}

	@Override
	public long getTotalExports(Export e) {
		return exportMapper.countByExample(getExportExample(e));
	}

	@Override
	public List<Export> getExportsByPage(Export e, Page page) {
		ExportExample example = getExportExample(e);
		example.setPage(page);
		String orderField = page.getOrderField();
		String orderDirection = page.getOrderDirection();
		if (StringUtils.isBlank(orderField)) {
			orderField = "update_time";
		}
		if (StringUtils.isBlank(orderDirection)) {
			orderDirection = "desc";
		}
		example.setOrderByClause(orderField + " " + orderDirection);

		List<Export> selectByExample = exportMapper.getExportsByPage(example);
		return selectByExample;
	}

	private Product buildProdDomain(Export export, String type) {
		Product prod = new Product();
		prod.setProdColor(export.getExportColor());
		prod.setProdName(export.getExportName());
		prod.setProdNo(export.getExportProdId());
		prod.setProdSize(export.getExportSize());
		prod.setProdType(export.getExportType());
		prod.setNums(export.getNums());
		prod.setUpdaterName(export.getUpdaterName());
		prod.setUpdateNo(export.getUpdaterName());
		if ("add".equals(type)) {
			prod.setAddTime(new Date());
			prod.setAdderName(export.getUpdaterName());
			prod.setAdderNo(export.getUpdaterName());
		}
		return prod;
	}

	@Override
	public int txExport(Export export) throws Exception {

		Product findProduct = productService.findProduct(export.getProdNo());
		if (findProduct != null) {
			Integer nums = export.getNums();
			Integer ori_nums = findProduct.getNums();
			if (nums > ori_nums) {
				return 0;
			}

		}
		boolean status = false;
		if (export.getId() != null && export.getId() != 0) {
			export.setProdNo(findProduct.getId() + "");
			productService.updateProductNums(export.getProdNo(), export.getNums());
			productService.updateProductNums(export.getOriProdNo(), 0 - export.getOriNums());

			status = updateByKey(export);
		} else {
			export.setProdNo(findProduct.getId() + "");
			status = addExport(export);
			Product buildProdDomain = buildProdDomain(export, "update");
			buildProdDomain.setNums(findProduct.getNums() - export.getNums());
			productService.editProduct(buildProdDomain);
		}
		return 1;
	}
}
