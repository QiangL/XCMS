package com.didicms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.didicms.dao.AccountDao;
import com.didicms.entry.Account;
import com.didicms.util.PwdEncoding;

@Component
public class AccountDaoImpl implements AccountDao {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public Account getById(String id) {
		String sql = "select account_id,account_password,account_company_id,"
				+ "company_name from account,company where account_company_id=company_id and account_id=?";
		return  jdbc.query(sql, new Object[] { id }, new int[] { Types.NVARCHAR },new ResultSetExtractor<Account>() {

			@Override
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(!rs.next()){
					return null;
				}
				Account a = new Account();
				a.setId(rs.getString("account_id"));
				a.setPassword(rs.getString("account_password"));
				a.setCompanyId(rs.getInt("account_company_id"));
				a.setCompanyName(rs.getString("company_name"));
				return a;
			}
		});
	}

	@Override
	public List<Account> getAllByCompanyId(int companyId, int count) {
		String sql = "select account_id,account_password,account_company_id,"
				+ "company_name from account,company where account_company_id=company_id and company_id=? limit ?,8";
		return jdbc.query(sql, new Object[] { (count - 1) * 8, companyId }, new int[] { Types.INTEGER, Types.INTEGER },
				new RowMapper<Account>() {

					@Override
					public Account mapRow(ResultSet rs, int index) throws SQLException {
						Account a = new Account();
						a.setId(rs.getString("account_id"));
						a.setPassword(rs.getString("account_password"));
						a.setCompanyId(rs.getInt("account_company_id"));
						a.setCompanyName(rs.getString("company_name"));
						return a;
					}
				});
	}

	@Override
	public boolean insert(Account account) {
		String sql="insert into account (account_id,account_password,account_company_id) values(?,?,?)";
		return jdbc.update(sql,
				new Object[]{account.getId(),account.getPassword(),account.getCompanyId()},
				new int[]{Types.NVARCHAR,Types.NVARCHAR,Types.INTEGER})==1?true:false;
	}

	@Override
	public boolean delete(String id) {
		String sql="delete from account where account_id=?";
		return jdbc.update(sql,	new Object[]{id},new int[]{Types.NVARCHAR})==1?true:false;
	}

	@Override
	public boolean update(Account account) {
		String sql="update account set account_password=? where account_id=? and account_company_id=?";
		return jdbc.update(sql,
				new Object[]{account.getPassword(),account.getId(),account.getCompanyId()},
				new int[]{Types.NVARCHAR,Types.NVARCHAR,Types.INTEGER})==1?true:false;
	}

	@Override
	public int getNumber() {
		String sql = "select count(*) from account";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Account> getAll(int count) {
		String sql = "select account_id,account_password,account_company_id,company_name from account,company where account_company_id=company_id limit ?,8";
		return jdbc.query(sql, new Object[] { (count - 1) * 8 }, new int[] { Types.INTEGER }, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int index) throws SQLException {
				Account a = new Account();
				a.setId(rs.getString("account_id"));
				a.setPassword(rs.getString("account_password"));
				a.setCompanyId(rs.getInt("account_company_id"));
				a.setCompanyName(rs.getString("company_name"));
				return a;
			}
		});

	}

}
