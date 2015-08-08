package com.salk.best.booking.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salk.best.domain.Item;
import com.salk.best.domain.ItemExample;
import com.salk.best.domain.Page;
import com.salk.best.product.dao.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMappter;

	@Override
	public boolean addItem(Item item) {
		return itemMappter.insert(item) > 0 ? true : false;
	}

	@Override
	public boolean editItem(Item item) {
		// TODO Auto-generated method stub
		return itemMappter.updateByPrimaryKey(item) > 0 ? true : false;
	}

	@Override
	public Item findItem(String id) {

		return itemMappter.selectByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public boolean deleteItem(String ids) {
		if (StringUtils.isBlank(ids)) {
			return false;
		}

		int updateCount = itemMappter.deleteByPrimaryKeys(ids.split(","));
		return updateCount > 0 ? true : false;
	}

	@Override
	public List<Item> queryItems(Item item) {
		ItemExample example = buildExample(item);
		List<Item> selectByExample = itemMappter.selectByExample(example);
		return selectByExample;
	}

	private ItemExample buildExample(Item item) {
		ItemExample example = new ItemExample();
		// example.setOrderByClause("or");
		com.salk.best.domain.ItemExample.Criteria createCriteria = example.createCriteria();
		if (StringUtils.isNotBlank(item.getTypeName())) {
			createCriteria.andTypeNameLike("%" + item.getTypeName() + "%");
		}
		return example;
	}

	@Override
	public long countItem(Item item) {
		// TODO Auto-generated method stub
		ItemExample example = buildExample(item);
		return itemMappter.countByExample(example);
	}

	@Override
	public List<Item> getItemsByPage(Item i, Page page) {
		ItemExample example = buildExample(i);
		example.setPage(page);
		String orderField = page.getOrderField();
		String orderDirection = page.getOrderDirection();
		if (StringUtils.isBlank(orderField)) {
			orderField = "type_name";
		}
		if (StringUtils.isBlank(orderDirection)) {
			orderDirection = "desc";
		}
		example.setOrderByClause(orderField + " " + orderDirection);

		List<Item> selectByExample = itemMappter.getItemsByPage(example);
		return selectByExample;
	}

}
