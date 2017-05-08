package com.didicms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.didicms.dao.CompanyDao;
import com.didicms.entry.Company;

@Component
public class CompanyDaoImpl implements CompanyDao {
	@Autowired
	JdbcTemplate jdbc;
	

	@Override
	public Company getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getAll(int count) {
		String sql="select company_id,company_name,company_owner,company_tel,company_email,company_public_account from company limit ?,8";
		List<Company> list=jdbc.query(sql, new Object[]{(count-1)*8},new int[]{Types.INTEGER},new RowMapper<Company>() {

			@Override
			public Company mapRow(ResultSet rs, int index) throws SQLException {
				Company c=new Company();
				c.setId(rs.getInt("company_id"));
				c.setName(rs.getString("company_name"));
				c.setOwner(rs.getString("company_owner"));
				c.setTel(rs.getString("company_tel"));
				c.setEmail(rs.getString("company_email"));
				c.setPublicAccount(rs.getString("company_public_account"));
				return c;
			}
		});
		return list;
	}

	@Override
	public boolean update(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getAllNumber() {
		String sql="select count(*) from company";
		return jdbc.queryForObject(sql, Integer.class);
	}

}
