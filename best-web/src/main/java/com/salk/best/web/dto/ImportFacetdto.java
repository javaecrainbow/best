package com.salk.best.web.dto;

import java.util.HashMap;
import java.util.Map;

public class ImportFacetdto {
	private String importName;
	private String prodNo;
	private String importType;

	private long total;
	private Map<String, ImportSize> sizes = new HashMap<String, ImportSize>();

	public String getImportName() {
		return importName;
	}

	public void setImportName(String importName) {
		this.importName = importName;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Map<String, ImportSize> getSizes() {
		return sizes;
	}

	public void addSizes(ImportSize size) {
		this.sizes.put(size.getSize(), size);
	}

	public String getImportType() {
		return importType;
	}

	public void setImportType(String importType) {
		this.importType = importType;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

}