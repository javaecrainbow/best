package com.salk.best.booking.service;

import java.util.List;

import com.salk.best.domain.Import;
import com.salk.best.domain.Page;
import com.salk.best.domain.Product;

public interface ImportService {
	public boolean addImport(Import i);

	public List<Import> getImports(Import i);

	public List<Import> getImportsByPage(Import i, Page page);

	public List<Import> getProdNameByPage(Import i, Page page);

	public long getTotalProdNameByPage(Import i);

	public long getTotalImports(Import i);

	public Import findImport(String id);

	public Import findImportByExportNo(String exportNo);

	public boolean deleteImport(String ids);

	public boolean updateByKey(Import i) throws Exception;

	public List<Import> queryImportsByFacet(String importType);

	public boolean txAdImport(Import i, Product prod) throws Exception;

	public boolean txUpdateImport(Import i, Product prod) throws Exception;

	public boolean txdeleteImport(String ids) throws Exception;
}
