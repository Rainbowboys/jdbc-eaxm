package com.oracle.jdbc.exam.dao;

import java.util.List;
import java.util.Set;

import com.oracle.jdbc.exam.entity.Product;

public interface IProduct {
	// 按ID查询出商品信息，不做级联
	Product findById(int id);

	/*
	 * 按产品类别分页查询产品信息 * @param category 分类
	 * 
	 * @param start 起始位置 * @param rows 行数
	 */
	List<Product> pageByCategory(String category, int start, int rows);

	// 采用批处理 来批理插入产品信息，要保证一起成功、一起失败。
	void saveProducts(Set<Product> products);
  void saveProducts2(Set<Product> products);

}
