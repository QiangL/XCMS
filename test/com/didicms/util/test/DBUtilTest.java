package com.didicms.util.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.didicms.util.DBUtil;
import com.mysql.jdbc.Statement;

public class DBUtilTest {
	@Test
	public void test() throws SQLException{
		System.out.println(this.getClass().getResource("/"));
		Connection conn=DBUtil.getConn();
		System.out.println(conn);
		PreparedStatement smt=conn.prepareStatement("select * from driver");
		ResultSet rs=smt.executeQuery();
		rs.next();
		System.out.println(rs.getString("driver_id"));
		DBUtil.closeResultSet(rs);
		DBUtil.closeStmt(smt);
		
		DBUtil.closeConn(conn);
	}

}
