package com.salk.best.booking.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.salk.best.domain.Page;
import com.salk.best.domain.Product;
import com.salk.best.domain.ProductExample;
import com.salk.best.product.dao.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public int addProduct(Product prod) {
		return productMapper.insert(prod);

	}

	@Override
	public boolean editProduct(Product prod) {
		return productMapper.updateByProd(prod) > 0 ? true : false;

	}

	@Override
	public Product findProduct(String id) {
		return productMapper.selectByPrimaryKey(Integer.parseInt(id));

	}

	@Override
	public boolean deleteProduct(String ids) {
		if (StringUtils.isBlank(ids)) {
			return false;
		}

		int updateCount = productMapper.deleteByPrimaryKeys(ids.split(","));
		return updateCount > 0 ? true : false;
	}

	private ProductExample buildExample4Query(Product product) {
		ProductExample example = new ProductExample();
		// example.setOrderByClause("or");
		com.salk.best.domain.ProductExample.Criteria createCriteria = example.createCriteria();

		if (StringUtils.isNotBlank(product.getProdNo())) {
			createCriteria.andProdNoEqualTo(product.getProdNo());
		}
		if (StringUtils.isNotBlank(product.getProdSize())) {
			createCriteria.andProdSizeEqualTo(product.getProdSize());
		}
		if (StringUtils.isNotBlank(product.getProdType())) {
			createCriteria.andProdTypeEqualTo(product.getProdType());
		}
		if (StringUtils.isNotBlank(product.getProdName())) {
			createCriteria.andProdNameLike("%" + product.getProdName() + "%");
		}
		return example;
	}

	private ProductExample buildExample4Compare(Product product) {
		ProductExample example = new ProductExample();
		// example.setOrderByClause("or");
		com.salk.best.domain.ProductExample.Criteria createCriteria = example.createCriteria();

		if (StringUtils.isNotBlank(product.getProdNo())) {
			createCriteria.andProdNoEqualTo(product.getProdNo());
		}
		if (StringUtils.isNotBlank(product.getProdSize())) {
			createCriteria.andProdSizeEqualTo(product.getProdSize());
		}
		if (StringUtils.isNotBlank(product.getProdType())) {
			createCriteria.andProdTypeEqualTo(product.getProdType());
		}
		if (StringUtils.isNotBlank(product.getProdName())) {
			createCriteria.andProdNameEqualTo(product.getProdName());
		}
		return example;
	}

	@Override
	public List<Product> queryProducts(Product prod) {
		ProductExample example = buildExample4Query(prod);
		List<Product> selectByExample = productMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public long countProduct(Product prod) {
		// TODO Auto-generated method stub
		ProductExample example = buildExample4Query(prod);
		return productMapper.countByExample(example);
	}

	@Override
	public List<Product> getProductsByPage(Product i, Page page) {

		ProductExample example = buildExample4Query(i);
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

		List<Product> selectByExample = productMapper.getProductsByPage(example);
		return selectByExample;

	}

	@Override
	public Product findProduct(Product prod) {
		ProductExample example = buildExample4Compare(prod);
		Page page = new Page();
		page.setStart(1);
		page.setEnd(10);
		example.setPage(page);

		return CollectionUtils.isEmpty(productMapper.getProductsByPage(example)) ? null : productMapper
				.getProductsByPage(example).get(0);
	}

	@Override
	public boolean updateProductNums(String id, int nums) {
		if (StringUtils.isBlank(id)) {
			return false;
		}
		return productMapper.updateProductNums(id, nums);
	}

}
