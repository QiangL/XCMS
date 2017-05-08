package com.didicms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.didicms.dao.OpratorDao;
import com.didicms.entry.Oprator;

@Component
public class OpratorDaoImpl implements OpratorDao {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public boolean update(Oprator oprator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Oprator oprator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Oprator getById(String id) {
		String sql="select oprator_id,oprator_password from oprator where oprator_id=?";
		try{
			Oprator o=jdbc.queryForObject(sql, new Object[]{id},new int[]{Types.NVARCHAR}
			,new RowMapper<Oprator>() {

				@Override
				public Oprator mapRow(ResultSet rs, int rowNum) throws SQLException {
					Oprator o=new Oprator();
					o.setId(rs.getString("oprator_id"));
					o.setPassword(rs.getString("oprator_password"));
					return o;
				}
			
			});
			return o;
		}catch(Exception e){
			//log it
			e.printStackTrace();
			return null;
		}
	}

}
