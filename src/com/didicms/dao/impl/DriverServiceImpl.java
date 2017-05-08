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
import com.didicms.entry.DriverGrade;

@Component
public class DriverServiceImpl implements DriverService {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public Driver getById(String id) {
		// TODO not complete!!
		String sql="select driver_id,driver_name,driver_name,driver_gender,driver_age,"
				+ "driver_company_id,driver_image,driver_bind_car_id,company_name from driver,company where driver_id=? and driver_company_id=company_id";
		return null;
	}

	@Override
	public List<Driver> getAllByCompanyId(int companyId,int count) {
		String sql = "select driver_id,driver_name,driver_age,driver_gender,driver_number,driver_bind_car_id,company_id,company_name from driver , "
				+ "company  where driver_company_id=company_id and company_id=?  and driver_exam=1 limit ?, 8";
		List<Driver> list=jdbc.query(sql
				,new Object[]{companyId,8*(count-1)}
				,new int[]{Types.INTEGER,Types.INTEGER}
				
				, new RowMapper<Driver>() {

			@Override
			public Driver mapRow(ResultSet rs, int index) throws SQLException {
				Driver driver = new Driver();
				driver.setId(rs.getString("driver_id"));
				driver.setName(rs.getString("driver_name"));
				driver.setAge(rs.getInt("driver_age"));
				driver.setGender(rs.getString("driver_gender"));
				driver.setNumber(rs.getString("driver_number"));
				driver.setBindCarId(rs.getString("driver_bind_car_id"));
				driver.setCompanyId(rs.getInt("company_id"));
				driver.setCompanyName(rs.getString("company_name"));
				return driver;
			}
		});
		return list;
	}

	@Override
	public boolean update(Driver driver) {
		String sql="update  driver set driver_number=?,driver_name=?,driver_gender=?,driver_age=?,driver_company_id=?,driver_image=?"
				+ "where driver_id=?";
		return jdbc.update(sql, new Object[]{
				driver.getNumber(),
				driver.getName(),
				driver.getGender(),
				driver.getAge(),
				driver.getCompanyId(),
				driver.getImagePath(),
				driver.getId()
		}, new int[]{
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.INTEGER,
				Types.INTEGER,
				Types.NVARCHAR,
				Types.NVARCHAR
		})==1?true:false;
	}

	@Override
	public boolean insert(Driver driver) {
		String sql="insert into driver (driver_id,driver_number,driver_name,driver_gender,driver_age,driver_company_id,driver_image,driver_exam)"
				+ "values(?,?,?,?,?,?,?,0)";
		return jdbc.update(sql, new Object[]{
				driver.getId(),
				driver.getNumber(),
				driver.getName(),
				driver.getGender(),
				driver.getAge(),
				driver.getCompanyId(),
				driver.getImagePath()
		}, new int[]{
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.INTEGER,
				Types.INTEGER,
				Types.NVARCHAR
		})==1?true:false;
		
	}
	@Override
	public boolean insertReal(Driver driver) {
		String sql="insert into driver (driver_id,driver_number,driver_name,driver_gender,driver_age,driver_company_id,driver_image,driver_exam)"
				+ "values(?,?,?,?,?,?,?,1)";
		return jdbc.update(sql, new Object[]{
				driver.getId(),
				driver.getNumber(),
				driver.getName(),
				driver.getGender(),
				driver.getAge(),
				driver.getCompanyId(),
				driver.getImagePath()
		}, new int[]{
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.INTEGER,
				Types.INTEGER,
				Types.NVARCHAR
		})==1?true:false;
	}
	

	@Override
	public boolean delete(String id) {
		String sql="update driver  set driver_exam=-1 where driver_id=?";
		return jdbc.update(sql, new Object[]{id}, new int[]{Types.NVARCHAR})==1?true:false;
	}
	@Override
	public boolean deleteReal(String id) {
		String sql="delete from driver where driver_id=?";
		return jdbc.update(sql, new Object[]{id}, new int[]{Types.NVARCHAR})==1?true:false;
	}


	@Override
	public List<Driver> getAll(int count) {
		String sql = "select driver_id,driver_name,driver_age,driver_gender,driver_number,driver_bind_car_id,company_id,company_name from driver , "
				+ "company  where driver_company_id=company_id and driver_exam=1 limit ?, 8";
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
				driver.setBindCarId(rs.getString("driver_bind_car_id"));
				driver.setCompanyId(rs.getInt("company_id"));
				driver.setCompanyName(rs.getString("company_name"));
				return driver;
			}
		});
		return list;
	}

	@Override
	public List<Driver> getAllNotExamAdd(int count) {
		String sql = "select driver_id,driver_name,driver_age,driver_gender,driver_number,driver_bind_car_id,company_id,company_name from driver , "
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
				driver.setBindCarId(rs.getString("driver_bind_car_id"));
				driver.setCompanyName(rs.getString("company_name"));
				return driver;
			}
		});
		return list;
	}
	@Override
	public List<Driver> getAllNotExamDel(int count) {
		String sql = "select driver_id,driver_name,driver_age,driver_gender,driver_number,driver_bind_car_id,company_id,company_name from driver , "
				+ "company  where driver_company_id=company_id and driver_exam=-1 limit ?, 8";
		
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
				driver.setBindCarId(rs.getString("driver_bind_car_id"));
				driver.setCompanyName(rs.getString("company_name"));
				return driver;
			}
		});
		return list;
	}

	@Override
	public boolean examAdd(String id) {
		String sql="update driver  set driver_exam=1 where driver_id=?";
		return jdbc.update(sql, new Object[]{id}, new int[]{Types.NVARCHAR})==1?true:false;
	}
	@Override
	public boolean examDel(String id) {
		return deleteReal(id);
	}
	@Override
	public int getNotExamAddNubmer(){
		String sql="select count(*) from driver  where driver_exam=0";
		return jdbc.queryForObject(sql, Integer.class);
	}
	@Override
	public int getNotExamDelNubmer(){
		String sql="select count(*) from driver  where driver_exam=-1";
		return jdbc.queryForObject(sql, Integer.class);
	}
	@Override
	public int getAllDriverNumber(){
		String sql="select count(*) from driver  where driver_exam=1";
		return jdbc.queryForObject(sql, Integer.class);
	}
	@Override
	public int getNumber(int companyId){
		//TODO not safe sql
		String sql="select count(*) from driver where driver_exam=1 and driver_company_id="+companyId;
		return jdbc.queryForObject(sql, Integer.class);
	}

}
