package com.oracle.jdbc.exam.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.oracle.jdbc.exam.dao.IProduct;
import com.oracle.jdbc.exam.daoIMP.IProductIMP;
import com.oracle.jdbc.exam.entity.Customer;
import com.oracle.jdbc.exam.entity.Product;

public class ProductTest {
	public static void main(String[] args) {
		IProduct iDao = new IProductIMP();
	  	//findproduct(3, iDao);
	  //pageByCategory(iDao);
		saveproducts(iDao);
	}

	private static void saveproducts(IProduct iDao) {
		// TODO Auto-generated method stub
		Set<Product> products=new HashSet<Product>();
		for(int i=0;i<2000;i++){
			Product product;
			product=new Product(i+"¶ÌÐä","ÉÏÒÂ",78);
			products.add(product);
		}
		iDao.saveProducts2(products);
		
		
	}

	private static void pageByCategory(IProduct idao) {
		List<Product> list = idao.pageByCategory("¿ã×Ó", 0, 3);
		Iterator<Product> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}

	}

	private static void findproduct(int id, IProduct idao) {
		Product product = idao.findById(id);
		System.out.println(product);

	}
	

}
