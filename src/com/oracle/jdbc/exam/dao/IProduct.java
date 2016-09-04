package com.oracle.jdbc.exam.dao;

import java.util.List;
import java.util.Set;

import com.oracle.jdbc.exam.entity.Product;

public interface IProduct {
	// ��ID��ѯ����Ʒ��Ϣ����������
	Product findById(int id);

	/*
	 * ����Ʒ����ҳ��ѯ��Ʒ��Ϣ * @param category ����
	 * 
	 * @param start ��ʼλ�� * @param rows ����
	 */
	List<Product> pageByCategory(String category, int start, int rows);

	// ���������� ����������Ʒ��Ϣ��Ҫ��֤һ��ɹ���һ��ʧ�ܡ�
	void saveProducts(Set<Product> products);
  void saveProducts2(Set<Product> products);

}
