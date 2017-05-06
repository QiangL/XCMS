package com.didicms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.didicms.dao.DriverService;
import com.didicms.entry.Driver;

@Component
public class DriverServiceImpl implements DriverService {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public Driver getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> getAllByCompanyId(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Driver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Driver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Driver> getAll(int count) {
		String sql = "select driver_id,driver_name,driver_age,driver_gender,driver_number,company_id,company_name from driver , "
				+ "company  where driver_company_id=company_id limit ?, 8";
		List<Driver> list=jdbc.query(sql
				,new Object[]{8*(count-1)}
				,new int[]{Types.INTEGER}
				
				, new RowMapper<Driver>() {

			@Override
			public Driver mapRow(ResultSet rs, int index) throws SQLException {
				Driver driver = new Driver();
				driver.setId(rs.getString("driver_id"));
				driver.setName(rs.getString("driver_name"));
				driver.setAge(rs.getInt("driver_age"));
				driver.setGender(rs.getString("driver_gender"));
				driver.setNumber(rs.getString("driver_number"));
				driver.setCompanyId(rs.getInt("company_id"));
				driver.setCompanyName(rs.getString("company_name"));
				return driver;
			}
		});
		return list;
	}

	@Override
	public List<Driver> getAllNotExam(int count) {
		String sql = "select driver_id,driver_name,driver_age,driver_gender,driver_number,company_id,company_name from driver , "
				+ "company  where driver_company_id=company_id and driver_exam=0 limit ?, 8";
		/*
		 List<Driver> list = new LinkedList<>();
		try {
			Connection conn=DBUtil.getConn();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Driver driver = new Driver();
				driver.setId(rs.getString("driver_id"));
				driver.setName(rs.getString("driver_name"));
				driver.setAge(rs.getInt("driver_age"));
				driver.setGender(rs.getString("driver_gender"));
				driver.setNumber(rs.getString("driver_number"));
				driver.setCompanyId(rs.getInt("company_id"));
				driver.setCompanyName(rs.getString("company_name"));
				list.add(driver);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		List<Driver> list=jdbc.query(sql
				,new Object[]{8*(count-1)}
				,new int[]{Types.INTEGER}
				
				, new RowMapper<Driver>() {

			@Override
			public Driver mapRow(ResultSet rs, int index) throws SQLException {
				Driver driver = new Driver();
				driver.setId(rs.getString("driver_id"));
				driver.setName(rs.getString("driver_name"));
				driver.setAge(rs.getInt("driver_age"));
				driver.setGender(rs.getString("driver_gender"));
				driver.setNumber(rs.getString("driver_number"));
				driver.setCompanyId(rs.getInt("company_id"));
				driver.setCompanyName(rs.getString("company_name"));
				return driver;
			}
		});
		return list;
	}

	@Override
	public boolean exam(String id) {
		String sql="update driver  set driver_exam=1 where driver_id=?";
		return jdbc.update(sql, new Object[]{id}, new int[]{Types.NVARCHAR})==1?true:false;
	}
	@Override
	public int getNotExamNubmer(){
		String sql="select count(*) from driver  where driver_exam=0";
		return jdbc.queryForObject(sql, Integer.class);
	}
	@Override
	public int getNumber(){
		String sql="select count(*) from driver ";
		return jdbc.queryForObject(sql, Integer.class);
	}

}
