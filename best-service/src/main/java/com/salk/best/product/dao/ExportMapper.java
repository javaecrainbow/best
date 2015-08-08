package com.salk.best.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.salk.best.domain.Export;
import com.salk.best.domain.ExportExample;

public interface ExportMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	int countByExample(ExportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	int deleteByExample(ExportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	int insert(Export record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	int insertSelective(Export record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	List<Export> selectByExample(ExportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	Export selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") Export record, @Param("example") ExportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") Export record, @Param("example") ExportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Export record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table export
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Export record);

	int deleteByPrimaryKeys(@Param("ids") String[] ids);

	List<Export> getExportsByPage(ExportExample example);

}