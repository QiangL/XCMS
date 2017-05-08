package com.didicms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.didicms.dao.OrderDao;
import com.didicms.entry.DriverGrade;
import com.didicms.entry.Order;
@Component
public class OrderDaoImpl implements OrderDao {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Order> getAll(int count) {
		String sql="SELECT `t_order`.`order_id`,`t_order`.`order_driver_id`,`t_order`.`order_date`,"
				+ "`t_order`.`order_quantity`,`t_order`.`order_transaction_amount`,`t_order`.`order_charging_time`,"
				+ "`t_order`.`order_bad_review`,`t_order`.`order_driver_score`,`t_order`.`order_driver_grade`,"
				+ "`t_order`.`order_reward`FROM `didicms`.`t_order`";
		
		List<Order> list=jdbc.query(sql,new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int index) throws SQLException {
				Order o=new Order();
				o.setDriverId(rs.getString("order_driver_id"));
				o.setDate(rs.getDate("order_date"));
				o.setQuantity(rs.getInt("order_quantity"));
				o.setTransactionAmount(rs.getDouble("order_transaction_amount"));
				o.setChargingTime(rs.getDouble("order_charging_time"));
				o.setBadReview(rs.getDouble("order_bad_review"));
				o.setDriverScore(rs.getDouble("order_driver_score"));
				String d=rs.getString("order_driver_grade");
				DriverGrade dg=d.equals("A")?DriverGrade.A:(d.equals("B")?DriverGrade.B:DriverGrade.C);
				o.setDriverGrade(dg);
				o.setReward(rs.getDouble("order_reward"));
				return o;
			}
		});
		return list;
	}

}
