package com.bit.emp.model;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
	List<EmpVo> selectAll() throws SQLException;
}
