package com.oracle.jdbc.exam.daoIMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.stream.events.StartElement;

import com.oracle.jdbc.exam.dao.DBDao;
import com.oracle.jdbc.exam.dao.IProduct;
import com.oracle.jdbc.exam.entity.Customer;
import com.oracle.jdbc.exam.entity.Product;
import com.oracle.jdbc.exam.entity.Purcase;

public class IProductIMP implements IProduct {

	// 按ID查询出商品信息，不做级联
	DBDao db = new DBDaoIMP();
	Connection conn = db.getconn();;
	PreparedStatement state = null;

	@Override
	public Product findById(int id) {
		Product product = null;
		try {
			String sql = "select * from product where ID=?";
			state = conn.prepareStatement(sql);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			product = new Product();
			while (result.next()) {
				product.setID(result.getInt("ID"));
				product.setProduct_category(result.getString("CATEGORY"));
				product.setProduct_name(result.getString("NAME"));
				product.setProduct_unitprice(result.getDouble("UNITPRICE"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.Close(state, conn);
		}
		return product;

	}

	/**
	 * 按产品类别分页查询产品信息 * @param category 分类
	 * 
	 * @param start
	 *            起始位置 * @param rows 行数
	 */
	@Override
	public List<Product> pageByCategory(String category, int start, int rows) {
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "SELECT * FROM (select * from product GROUP BY  CATEGORY,NAME) As s WHERE CATEGORY=? LIMIT ?,?";
			state = conn.prepareStatement(sql);
			state.setString(1, category);
			state.setInt(2, start);
			state.setInt(3, rows);
			ResultSet result = state.executeQuery();

			while (result.next()) {
				Product product = new Product();
				product.setID(result.getInt("ID"));
				product.setProduct_category(result.getString("CATEGORY"));
				product.setProduct_name(result.getString("NAME"));
				product.setProduct_unitprice(result.getDouble("UNITPRICE"));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.Close(state, conn);

		}
		return list;
	}

	@Override
	public void saveProducts(Set<Product> products) {
		try {
			// 关闭自动提交事务
			conn.setAutoCommit(false);

			for (Product product : products) {
				String sql = "insert into product(NAME,CATEGORY,UNITPRICE) values(?,?,?)";
				state = conn.prepareStatement(sql);
				state.setString(1, product.getProduct_name());
				state.setString(2, product.getProduct_category());
				state.setDouble(3, product.getProduct_unitprice());
				state.executeUpdate();
			}
			// 手动提交事务
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			db.Close(state, conn);
		}

	}
	/**
	 * 批量处理数据
	 */

	@Override
	public void saveProducts2(Set<Product> products) {

		try {
			int index = 0;
			for (Product product : products) {
				String sql = "insert into product(NAME,CATEGORY,UNITPRICE) values(?,?,?)";
				state = conn.prepareStatement(sql);
				state.setString(1, product.getProduct_name());
				state.setString(2, product.getProduct_category());
				state.setDouble(3, product.getProduct_unitprice());
				state.addBatch();
				index++;
				if (index >= 1000) {
					System.out.println(state.executeBatch().toString());
					index = 0;
				}
			}
			if (index > 0) {
				state.executeBatch();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.Close(state, conn);
		}

	}

}
