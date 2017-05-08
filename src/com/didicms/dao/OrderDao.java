package com.didicms.dao;

import java.util.List;

import com.didicms.entry.Order;

public interface OrderDao {
	public List<Order> getAll(int companyId);
}
