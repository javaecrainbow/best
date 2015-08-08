package com.salk.best.domain;

import java.io.Serializable;

public class Page implements Serializable {
	public static long SIZE = 10;
	public static long Range = 5;
	private long start;
	private long end;
	private long currentPage;
	private String pageUrl;
	private long total;
	private long totalPage;
	private long pageSize = 10;
	private String orderField;
	private String orderDirection;

	public Page() {

	}

	public Page(long currentPage, String pageUrl, long pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageUrl = pageUrl;
		this.pageSize = pageSize;
	}

	public long getStart() {

		if (currentPage <= 1) {
			return 0;
		} else {
			return pageSize * (currentPage - 1);
		}

	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return pageSize;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalPage() {
		return getTotal() % pageSize == 0 ? getTotal() / pageSize : getTotal() / pageSize + 1;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	@Override
	public String toString() {
		return "Page [start=" + start + ", end=" + end + ", pageUrl=" + pageUrl + "]";
	}

}
