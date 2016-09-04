package com.oracle.jdbc.exam.dao;

import java.util.List;

import com.oracle.jdbc.exam.entity.Customer;

public interface ICustomerDao {
	// ע���ͻ��й����¼�ļ����е���Ʒһ�����Ѿ����ڵġ�
	public void purcase(Customer c);

	// ���¿ͻ���Ϣ,��������
	public void updCustomer(Customer c);

	// ��ѯ�����пͻ�����������
	List<Customer> findAll();

	// ���ݿͻ���ַ��ѯ�ͻ���Ϣ����������ѯ���ͻ��Ĺ�����Ʒ
	// û�й�����Ʒ�Ŀͻ�ҲҪ�����
	List<Customer> findByLoc(String loc);

}
