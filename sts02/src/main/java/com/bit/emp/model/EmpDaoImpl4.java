package com.bit.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class EmpDaoImpl4 implements EmpDao {
	
	JdbcTemplate jdbcTemplate;
	
	public EmpDaoImpl4(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	RowMapper<EmpVo> rowMapper = new RowMapper<EmpVo>() {

		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(
					rs.getInt("empno"), rs.getInt("sal"),
					rs.getString("ename"), rs.getString("job"),
					rs.getDate("hiredate")
					);
		}
	}; 
	
	@Override
	public List<EmpVo> selectAll() throws SQLException {
		final String sql = "select * from emp";
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				return conn.prepareStatement(sql);
			}
		};
		
		return jdbcTemplate.query(psc, rowMapper);
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		PreparedStatementCreator psc = new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				System.out.println("첫번째 conn : " + conn.hashCode());
				String sql = "insert into emp (empno, sal, ename, job, hiredate) values (?,?,?,?,now())";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bean.getEmpno());
				pstmt.setInt(2, bean.getSal());
				pstmt.setString(3, bean.getEname());
				pstmt.setString(4, bean.getJob());
				return pstmt;
			} 
		};
		jdbcTemplate.update(psc);

	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int empno) throws SQLException {
		return 0;
	}

	@Override
	public EmpVo selectOne(int empno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
