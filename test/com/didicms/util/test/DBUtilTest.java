package com.didicms.util.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.didicms.util.DBUtil;

public class DBUtilTest {
	@Test
	public void test() throws SQLException{
		System.out.println(this.getClass().getResource("/"));
		Connection conn=DBUtil.getConn();
		System.out.println(conn);
		DBUtil.closeConn(conn);
	}

}
