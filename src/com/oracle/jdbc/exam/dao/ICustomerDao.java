package com.oracle.jdbc.exam.dao;

import java.util.List;

import com.oracle.jdbc.exam.entity.Customer;

public interface ICustomerDao {
	// 注：客户中购买记录的集合中的商品一定是已经存在的。
	public void purcase(Customer c);

	// 更新客户信息,不做级联
	public void updCustomer(Customer c);

	// 查询出所有客户，不做级联
	List<Customer> findAll();

	// 根据客户地址查询客户信息，并级联查询出客户的购买商品
	// 没有购买商品的客户也要查出来
	List<Customer> findByLoc(String loc);

}
