package com.bit.sts06.domain;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
	
	List<EmpVo> findAll() throws SQLException;
	EmpVo findOne(int idx) throws SQLException;
	void insertOne(EmpVo bean) throws Exception;
	int updateOne(EmpVo bean) throws Exception;
	int deleteOne(int idx) throws Exception;
	int findSize() throws Exception;
}
