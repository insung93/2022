package com.bit.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class EmpDaoImpl1 implements EmpDao {
	
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<EmpVo> selectAll() throws SQLException {
		String sql = "select * from emp";
		List<EmpVo> list = new ArrayList<>();
		
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				) {
			while(rs.next()) {
				list.add(new EmpVo(
						rs.getInt("empno"), rs.getInt("sal"),
						rs.getString("ename"), rs.getString("job"),
						rs.getDate("hiredate")
						));
			}
		}
		return list;
	}

}
