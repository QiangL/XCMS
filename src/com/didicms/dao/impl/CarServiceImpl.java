package com.didicms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.didicms.dao.CarService;
import com.didicms.entry.Car;

@Component
public class CarServiceImpl implements CarService {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public Car getById(String id) {
		return null;
	}

	@Override
	public List<Car> getByCompanyId(int companyId,int count) {
		String sql="select car_id,car_number,car_model,car_displacement,car_color,"
				+ "car_company_id,car_image,company_name from car,company where "
				+ "car_company_id=company_id and company_id= ? and car_exam=-1 limit  ?,8";
		List<Car> list=jdbc.query(sql, new Object[]{companyId,(count-1)*8}
								,new int[]{Types.INTEGER,Types.INTEGER},new RowMapper<Car>(){

			@Override
			public Car mapRow(ResultSet rs, int index) throws SQLException {
				Car car=new Car();
				car.setId(rs.getString("car_id"));;
				car.setNumber(rs.getString("car_number"));
				car.setModel(rs.getString("car_model"));
				car.setDisplacement(rs.getString("car_displacement"));
				car.setImage(rs.getString("car_image"));
				car.setColor(rs.getString("car_color"));
				car.setCompanyId(rs.getInt("car_company_id"));
				car.setCompanyName(rs.getString("company_name"));
				return car;
			}
			
		});
		return list;
	}

	@Override
	public boolean insert(Car car) {
		String sql="insert into car (car_id,car_number,car_model,car_displacement,car_color,car_company_id,car_image,car_exam)"
				+"values (?,?,?,?,?,?,?,0)";
		return jdbc.update(sql, new Object[]{
				car.getId(),
				car.getNumber(),
				car.getModel(),
				car.getDisplacement(),
				car.getColor(),
				car.getCompanyId(),
				car.getImage()
		}, new int[]{
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.INTEGER,
				Types.NVARCHAR
		})==1?true:false;
		
	}
	@Override
	public boolean insertReal(Car car) {
		String sql="insert into car (car_id,car_number,car_model,car_displacement,car_color,car_company_id,car_image,car_exam)"
				+"values (?,?,?,?,?,?,?,1)";
		return jdbc.update(sql, new Object[]{
				car.getId(),
				car.getNumber(),
				car.getModel(),
				car.getDisplacement(),
				car.getColor(),
				car.getCompanyId(),
				car.getImage()
		}, new int[]{
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.INTEGER,
				Types.NVARCHAR
		})==1?true:false;
		
	}

	@Override
	public boolean delete(String id) {
		String sql="update car  set car_exam=-1 where car_id=?";
		return jdbc.update(sql, new Object[]{id}, new int[]{Types.NVARCHAR})==1?true:false;
	}
	@Override
	public boolean deleteReal(String id) {
		String sql="delete from car where car_id=?";
		return jdbc.update(sql, new Object[]{id}, new int[]{Types.NVARCHAR})==1?true:false;
	}
	@Override
	public boolean update(Car car) {
		String sql="update car set car_number=?,car_model=?,car_displacement=?,car_color=?,car_company_id=?,car_image=?"
				+"where car_id=?";
		return jdbc.update(sql, new Object[]{
				car.getNumber(),
				car.getModel(),
				car.getDisplacement(),
				car.getColor(),
				car.getCompanyId(),
				car.getImage(),
				car.getId()
		}, new int[]{
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.NVARCHAR,
				Types.INTEGER,
				Types.NVARCHAR,
				Types.NVARCHAR,
		})==1?true:false;
	}


	@Override
	public int getNotExamAddNubmer() {
		String sql="select count(*) from car  where car_exam=0";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public int getNotExamDelNubmer() {
		String sql="select count(*) from car  where car_exam=-1";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public int getAllCarNumber() {
		String sql="select count(*) from car where car_exam=1";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Car> getAll(int count) {
		String sql="select car_id,car_number,car_model,car_displacement,car_color,"
				+ "car_company_id,car_image,company_name from car,company where car_company_id=company_id and car_exam=1 limit ?,8";
		List<Car> list=jdbc.query(sql, new Object[]{(count-1)*8},new int[]{Types.INTEGER},new RowMapper<Car>(){

			@Override
			public Car mapRow(ResultSet rs, int index) throws SQLException {
				Car car=new Car();
				car.setId(rs.getString("car_id"));;
				car.setNumber(rs.getString("car_number"));
				car.setModel(rs.getString("car_model"));
				car.setDisplacement(rs.getString("car_displacement"));
				car.setImage(rs.getString("car_image"));
				car.setColor(rs.getString("car_color"));
				car.setCompanyId(rs.getInt("car_company_id"));
				car.setCompanyName(rs.getString("company_name"));
				return car;
			}
			
		});
		return list;
	}

	@Override
	public boolean examAdd(String id) {
		String sql="update car  set car_exam=1 where car_id=?";
		return jdbc.update(sql, new Object[]{id}, new int[]{Types.NVARCHAR})==1?true:false;
	}

	@Override
	public boolean examDel(String id) {
		return deleteReal(id);
	}

	

	
	@Override
	public List<Car> getAllNotExamAdd(int count) {
		String sql="select car_id,car_number,car_model,car_displacement,car_color,"
				+ "car_company_id,car_image,company_name from car,company where car_company_id=company_id and car_exam=0 limit ?,8";
		List<Car> list=jdbc.query(sql, new Object[]{(count-1)*8},new int[]{Types.INTEGER},new RowMapper<Car>(){

			@Override
			public Car mapRow(ResultSet rs, int index) throws SQLException {
				Car car=new Car();
				car.setId(rs.getString("car_id"));;
				car.setNumber(rs.getString("car_number"));
				car.setModel(rs.getString("car_model"));
				car.setDisplacement(rs.getString("car_displacement"));
				car.setImage(rs.getString("car_image"));
				car.setColor(rs.getString("car_color"));
				car.setCompanyId(rs.getInt("car_company_id"));
				car.setCompanyName(rs.getString("company_name"));
				return car;
			}
			
		});
		return list;
	}

	@Override
	public List<Car> getAllNotExamDel(int count) {
		String sql="select car_id,car_number,car_model,car_displacement,car_color,"
				+ "car_company_id,car_image,company_name from car,company where car_company_id=company_id and car_exam=-1 limit  ?,8";
		List<Car> list=jdbc.query(sql, new Object[]{(count-1)*8},new int[]{Types.INTEGER},new RowMapper<Car>(){

			@Override
			public Car mapRow(ResultSet rs, int index) throws SQLException {
				Car car=new Car();
				car.setId(rs.getString("car_id"));;
				car.setNumber(rs.getString("car_number"));
				car.setModel(rs.getString("car_model"));
				car.setDisplacement(rs.getString("car_displacement"));
				car.setImage(rs.getString("car_image"));
				car.setColor(rs.getString("car_color"));
				car.setCompanyId(rs.getInt("car_company_id"));
				car.setCompanyName(rs.getString("company_name"));
				return car;
			}
			
		});
		return list;
	}

	

}
