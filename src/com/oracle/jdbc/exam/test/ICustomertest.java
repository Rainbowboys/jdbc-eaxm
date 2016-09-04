package com.oracle.jdbc.exam.test;

import java.util.Iterator;
import java.util.List;

import com.oracle.jdbc.exam.dao.ICustomerDao;
import com.oracle.jdbc.exam.daoIMP.ICustomerDaoIMP;
import com.oracle.jdbc.exam.entity.Customer;

public class ICustomertest {
	public static void main(String[] args) {
		ICustomerDao iDao = new ICustomerDaoIMP();
		 //TestUpdate(iDao);
		//TestFindall(iDao);
		 //TestCustomer(iDao);
	
		TestFindall(iDao,"±±¾©");
	}

	public static void TestCustomer(ICustomerDao iDao) {
		Customer c = new Customer(5);
		iDao.purcase(c);
	}

	public static void TestUpdate(ICustomerDao iDao) {
		Customer c = new Customer(5, "xiaohan111", "shanghai");
		iDao.updCustomer(c);
		;
	}

	public static void TestFindall(ICustomerDao iDao, String... loc) {
		List<Customer> list = null;
		
		if (loc.length>0) {
			list = iDao.findByLoc(loc[0]);
		} else {
			list = iDao.findAll();
		}

		Iterator<Customer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
	}

}
