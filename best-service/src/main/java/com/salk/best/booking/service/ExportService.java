package com.salk.best.booking.service;

import java.util.List;

import com.salk.best.domain.Export;
import com.salk.best.domain.Page;

public interface ExportService {
	public boolean addExport(Export e) throws Exception;

	public List<Export> getExports(Export e);

	public List<Export> getExportsByPage(Export e, Page page);

	public long getTotalExports(Export e);

	public Export findExport(String id);

	public boolean deleteExport(String ids);

	public boolean updateByKey(Export e) throws Exception;

	public int txExport(Export e) throws Exception;

	boolean txdeleteExport(String ids) throws Exception;

}
