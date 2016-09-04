package com.oracle.jdbc.exam.daoIMP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.oracle.jdbc.exam.dao.DBDao;

public class DBDaoIMP implements DBDao {
	private static String url = "jdbc:mysql://localhost:3306/jdbc_exam?useUnicode=true&characterEncoding=UTF-8";
	private static String DB_NAME = "root";
	private static String DB_PWD = "root";

	@Override
	public Connection getconn() {

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, DB_NAME, DB_PWD);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
	}

	@Override
	public void Close(PreparedStatement state, Connection connection) {
		if (state != null) {
			try {
				state.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}

	}

}
