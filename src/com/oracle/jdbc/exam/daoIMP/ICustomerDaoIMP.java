package com.oracle.jdbc.exam.daoIMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.AEADBadTagException;

import com.oracle.jdbc.exam.dao.DBDao;
import com.oracle.jdbc.exam.dao.ICustomerDao;
import com.oracle.jdbc.exam.entity.Customer;
import com.oracle.jdbc.exam.entity.Purcase;

public class ICustomerDaoIMP implements ICustomerDao {

	DBDao db = new DBDaoIMP();
	Connection conn =db.getconn();;
	PreparedStatement state = null;

	@Override
	public void purcase(Customer c) {
		try {
			
			String sql = "select * from buy where CUSTOMER_ID=?";
			state = conn.prepareStatement(sql);
			state.setInt(1, c.getID());
			ResultSet result= state.executeQuery();
			List<Purcase> list=new ArrayList<Purcase>();
			while(result.next()){
				Purcase purcase=new Purcase();
				purcase.setCustomer_id(result.getInt("CUSTOMER_ID"));
				purcase.setProduct_id(result.getInt("PRODUCT_ID"));
				purcase.setNum(result.getInt("NUM"));
				list.add(purcase);
			}
			Iterator<Purcase> iterator=list.iterator();
			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				System.out.println(object);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.Close(state, conn);
		}

	}

	@Override
	public void updCustomer(Customer c) {
		// 更新客服信息
		try {
			String sql="update user set NAME=?, LOC=? where ID=?";
			state=conn.prepareStatement(sql);
			state.setString(1,c.getUsername());
			state.setString(2,c.getLocation());
			state.setInt(3, c.getID());
			int i=state.executeUpdate();
			if(i>0){
				System.out.println("更新成功");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.Close(state, conn);
		}

	}

	@Override
	public List<Customer> findAll() {
		List<Customer> list=new ArrayList<Customer>();
		try {
			String sql="select * from user";
			state=conn.prepareStatement(sql);
			ResultSet result=state.executeQuery();
			while(result.next()){
				Customer customer=new Customer();
				customer.setID(result.getInt("ID"));
				customer.setUsername(result.getString("NAME"));
				customer.setLocation(result.getString("LOC"));
				list.add(customer);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.Close(state, conn);
		}
		return list;

	}

	@Override
	public List<Customer> findByLoc(String loc) {
		List<Customer> list=new ArrayList<Customer>();
		try {
			String sql="select * from user where LOC=?";
			state=conn.prepareStatement(sql);
			state.setString(1, loc);
			ResultSet result=state.executeQuery();
			String ids="";
			while(result.next()){
				Customer customer=new Customer();
				customer.setID(result.getInt("ID"));
				customer.setUsername(result.getString("NAME"));
				customer.setLocation(result.getString("LOC"));
				if(ids.length()>0){
					ids+=",";
				}
				ids+=result.getInt("ID");
				list.add(customer);
			}
			sql="select * from buy where CUSTOMER_ID IN("+ids+")";
			result =state.executeQuery(sql);
			Map<Integer, List<Purcase>> map=new HashMap<>();
			while(result.next()){
				Purcase purcase;
				int coustom_id=result.getInt("CUSTOMER_ID");
				int product_id=result.getInt("PRODUCT_ID");
				int num=result.getInt("NUM");
				purcase=new Purcase(coustom_id, product_id, num);
				if(map.containsKey(coustom_id)){
					map.get(coustom_id).add(purcase);
				}else{
					List<Purcase> l=new ArrayList<>();
					l.add(purcase);
					map.put(coustom_id, l);
				}
			}
			for(int i=0;i<list.size();i++){
				list.get(i).setBuy(map.get(list.get(i).getID()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.Close(state, conn);
		}
		return list;

	}

}
