package com.salk.best.booking.service;

import java.util.List;

import com.salk.best.domain.Page;
import com.salk.best.domain.Product;

public interface ProductService {
	// 添加记录
	int addProduct(Product prod);

	// 修改记录
	boolean editProduct(Product prod);

	// 查找单条记录使用find
	Product findProduct(String id);

	Product findProduct(Product prod);

	// 删除记录
	boolean deleteProduct(String ids);

	boolean updateProductNums(String id, int nums);

	// 查找记录列表
	List<Product> queryProducts(Product prod);

	// 获取数量
	long countProduct(Product prod);

	List<Product> getProductsByPage(Product i, Page buildPageCommand);
}
