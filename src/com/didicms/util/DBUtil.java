package com.didicms.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBUtil {
	
	private static final String driver;
	private static final String connURL;
	private static final String username;
	private static final String password;
	
	static{
		Properties properties=new Properties();
		DBUtil.class.getClassLoader();
		//TODO file path should be consider again, classpath will be changed when deploy.
		InputStream is=DBUtil.class.getResourceAsStream("/com/didicms/property/db.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("database properties not found");
			e.printStackTrace();
		}
		driver=properties.getProperty("driver");
		connURL=properties.getProperty("connURL");
		username=properties.getProperty("username");
		password=properties.getProperty("password");
	}
	/**
	 * 娴嬭瘯绋嬪簭
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String [] args) throws SQLException{
		Connection conn=getConn();
		System.out.println(conn);
		closeConn(conn);
	}
	public static Connection getConn() throws SQLException{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO log it
			System.out.println("jdbc Mysql driver error");
			e.printStackTrace();
		}
		return DriverManager.getConnection(connURL,username,password);
	}
	public static void closeConn(Connection conn){
		try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO log it
			System.out.println("close Connection error");
			e.printStackTrace();
		}finally{
			conn=null;
		}
	}
	public static void closeStmt(Statement stmt){
		try {
			if(stmt!=null && !stmt.isClosed()){
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO log it
			System.out.println("close statement error");
			e.printStackTrace();
		}finally{
			stmt=null;
		}
	}
	public static void closeResultSet(ResultSet rs){
		try {
			if(rs!=null && !rs.isClosed()){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO log it
			System.out.println("close ResultSet error");
			e.printStackTrace();
		}finally{
			rs=null;
		}
	}

}
