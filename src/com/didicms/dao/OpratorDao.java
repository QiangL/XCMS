package com.didicms.dao;

import com.didicms.entry.Oprator;

public interface OpratorDao {
	public boolean update(Oprator oprator);

	public boolean insert(Oprator oprator);

	public boolean delete(String id);

	public Oprator getById(String id);

}
