package com.didicms.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.didicms.dao.FinanceDao;
import com.didicms.entry.Finance;
import com.didicms.entry.FinanceStatus;
import com.didicms.util.DBUtil;

@Component
public class FinanceDaoImpl implements FinanceDao {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public boolean insert(Finance finance) {
		return false;
	}

	private List<Finance> getFinanceWithStatusAndCompany(int companyId, int count, FinanceStatus fs) {

		String sql = "select finance_id, finance_company_id,company_name,finance_date,finance_amount,company_public_account "
				+ "from finance,company where company_id=finance_company_id "
				+ "and finance_status=? and finance_company_id=? limit ?,8";

		List<Finance> list = jdbc.query(sql, new Object[] { fs.toString(), companyId, (count - 1) * 8 },
				new int[] { Types.NVARCHAR, Types.INTEGER, Types.INTEGER }, 
				new RowMapper<Finance>() {

					@Override
					public Finance mapRow(ResultSet rs, int index) throws SQLException {
						Finance f = new Finance();
						f.setId(rs.getInt("finance_id"));
						f.setCompanyId(rs.getInt("finance_company_id"));
						f.setCompanyName(rs.getString("company_name"));
						f.setDate(rs.getDate("finance_date"));
						f.setAmount(rs.getBigDecimal("finance_amount"));
						f.setCompanyPublicAccount(rs.getString("company_public_account"));
						f.setStatus(fs);
						return f;
					}
				});

		/*
		 * String
		 * sql="select finance_id, company_name,finance_date,finance_amount,company_public_account "
		 * +
		 * "from finance,company where company.company_id=finance.finance_company_id "
		 * + "and finance_status=? and finance_company_id=? limit ?,8";
		 * List<Finance> list=new LinkedList<>(); try { Connection
		 * conn=DBUtil.getConn(); PreparedStatement
		 * pstmt=conn.prepareStatement(sql); pstmt.setString(1, fs.toString());
		 * pstmt.setInt(2, companyId); pstmt.setInt(3, (count-1)*8); ResultSet
		 * rs=pstmt.executeQuery();
		 * 
		 * while(rs.next()){ Finance f=new Finance();
		 * f.setId(rs.getInt("finance_id"));
		 * f.setCompanyName(rs.getString("company_name"));
		 * f.setDate(rs.getDate("finance_date"));
		 * f.setAmount(rs.getBigDecimal("finance_amount"));
		 * f.setCompanyPublicAccount(rs.getString("company_public_account"));
		 * f.setStatus(fs); list.add(f); } } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		return list;
	}

	private List<Finance> getFinanceWithStatus(int count, FinanceStatus fs) {
		String sql = "select finance_id, finance_company_id,company_name,finance_date,finance_amount,company_public_account "
				+ "from finance,company where company.company_id=finance.finance_company_id and finance_status=? limit ?,8";
		List<Finance> list = jdbc.query(sql, new Object[] { fs.toString(), (count - 1) * 8 },
				new int[] { Types.NVARCHAR, Types.INTEGER }, new RowMapper<Finance>() {

					@Override
					public Finance mapRow(ResultSet rs, int index) throws SQLException {
						Finance f = new Finance();
						f.setId(rs.getInt("finance_id"));
						f.setCompanyName(rs.getString("company_name"));
						f.setCompanyId(rs.getInt("finance_company_id"));
						f.setDate(rs.getDate("finance_date"));
						f.setAmount(rs.getBigDecimal("finance_amount"));
						f.setCompanyPublicAccount(rs.getString("company_public_account"));
						f.setStatus(fs);
						return f;
					}
				});

		return list;
	}

	@Override
	public List<Finance> getAllByCompanyId(int companyId, int count) {
		return getFinanceWithStatusAndCompany(companyId, count, FinanceStatus.WaitConfirm);
	}

	@Override
	public List<Finance> getHistoryAllByCompanyId(int companyId, int count) {
		return getFinanceWithStatusAndCompany(companyId, count, FinanceStatus.Remitted);
	}

	@Override
	public List<Finance> getAll(int count) {
		return getFinanceWithStatus(count, FinanceStatus.WaitRemittance);
	}

	@Override
	public List<Finance> getHistoryAll(int count) {
		return getFinanceWithStatus(count, FinanceStatus.Remitted);
	}

	@Override
	public boolean remit(int financeId) {
		String sql = "update finance set finance_status=? where finance_id=?";
		return jdbc.update(sql, new Object[] { FinanceStatus.Remitted.toString(), financeId },
				new int[] { Types.NVARCHAR, Types.INTEGER }) == 1 ? true : false;
	}

	@Override
	public boolean confirm(int financeId) {
		String sql = "update finance set finance_status=? where finance_id=?";
		return jdbc.update(sql, new Object[] { FinanceStatus.WaitRemittance.toString(), financeId },
				new int[] { Types.NVARCHAR, Types.INTEGER }) == 1 ? true : false;
	}

	@Override
	public Finance getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFinancePage() {
		String sql = "select count(*) from finance";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public int getFinancePageByCompanyId(int companyId) {
		String sql = "select count(*) from finance where finance_company_id=" + companyId;
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public int getHistoryFinancePage() {
		String sql = "select count(*) from finance where finance_status='" + FinanceStatus.Remitted.toString() + "'";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public int getHistoryFinancePageByCompanyId(int companyId) {
		String sql = "select count(*) from finance where finance_company_id=" + companyId + " and finance_status='"
				+ FinanceStatus.Remitted.toString() + "'";
		return jdbc.queryForObject(sql, Integer.class);
	}
	@Override
	public boolean motifyAmount(int financeId,BigDecimal amount){
		String sql="update finance set finance_amount=? where finance_id=?";
		return jdbc.update(sql,new Object[]{amount,financeId},new int[]{Types.DECIMAL,Types.INTEGER})==1?true:false;
	}

}
