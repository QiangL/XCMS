package com.didicms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.didicms.dao.FinanceDao;
import com.didicms.entry.Finance;
import com.didicms.entry.FinanceStatus;

@Component
public class FinanceDaoImpl implements FinanceDao {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public boolean insert(Finance finance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Finance> getAllByCompanyId(int companyId, int count) {
		String sql="select finance_id, company_name,finance_date,finance_amount,company_public_account "
				+ "from finance,company where company.company_id=finance.finance_company_id "
				+ "and finance_status=? and finance_company_id=? limit ?,8";
		List<Finance> list=jdbc.query(sql, 
				new Object[]{FinanceStatus.WaitConfirm,(count-1)*8,companyId},new int[]{Types.NVARCHAR,Types.INTEGER,Types.INTEGER}
				, new RowMapper<Finance>() {

				@Override
				public Finance mapRow(ResultSet rs, int index) throws SQLException {
					Finance f=new Finance();
					f.setId(rs.getInt("finance_id"));
					f.setCompanyName(rs.getString("company_name"));
					f.setDate(rs.getDate("finance_date"));
					f.setAmount(rs.getBigDecimal("finance_amount"));
					f.setCompanyPublicAccount(rs.getString("company_public_account"));
					f.setStatus(FinanceStatus.WaitConfirm);
					return f;
				}
			});
		
		return list;
	}

	@Override
	public boolean remit(int financeId) {
		String sql="update finance set finance_status=? where finance_id=?";
		return jdbc.update(sql, new Object[]{FinanceStatus.Remitted.toString(),financeId},
				new int[]{Types.NVARCHAR,Types.INTEGER})==1?true:false;
	}

	@Override
	public boolean confirm(int financeId) {
		String sql="update finance set finance_status=? where finance_id=?";
		return jdbc.update(sql, new Object[]{FinanceStatus.WaitRemittance.toString(),financeId},
				new int[]{Types.NVARCHAR,Types.INTEGER})==1?true:false;
	}

	@Override
	public List<Finance> getAll(int count) {
		String sql="select finance_id, company_name,finance_date,finance_amount,company_public_account "
				+ "from finance,company where company.company_id=finance.finance_company_id and finance_status=? limit ?,8";
		List<Finance> list=jdbc.query(sql, 
				new Object[]{FinanceStatus.WaitConfirm,(count-1)*8},new int[]{Types.NVARCHAR,Types.INTEGER}
				, new RowMapper<Finance>() {

				@Override
				public Finance mapRow(ResultSet rs, int index) throws SQLException {
					Finance f=new Finance();
					f.setId(rs.getInt("finance_id"));
					f.setCompanyName(rs.getString("company_name"));
					f.setDate(rs.getDate("finance_date"));
					f.setAmount(rs.getBigDecimal("finance_amount"));
					f.setCompanyPublicAccount(rs.getString("company_public_account"));
					f.setStatus(FinanceStatus.WaitConfirm);
					return f;
				}
			});
		
		return list;
	}

	@Override
	public Finance getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFinancePage() {
		String sql="select count(*) from finance";
		return jdbc.queryForObject(sql, Integer.class);
	}

	
}
