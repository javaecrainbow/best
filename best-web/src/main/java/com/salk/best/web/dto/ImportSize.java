package com.salk.best.web.dto;

public class ImportSize {
	private String size;
	private long count;

	public ImportSize(String size, long count) {
		super();
		this.size = size;
		this.count = count;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
}
