package com.oracle.jdbc.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface DBDao {
	public Connection getconn();
	public void Close(PreparedStatement preparedStatement,Connection connection);

}
