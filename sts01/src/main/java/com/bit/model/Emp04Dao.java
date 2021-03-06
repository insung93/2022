package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class Emp04Dao implements EmpDao {
	
	DataSource dataSource;
	
	public Emp04Dao() {
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/scott");
		dataSource.setUser("user01");
		dataSource.setPassword("1234");
		this.dataSource = dataSource;
	}

	@Override
	public List<EmpVo> selectAll() throws SQLException {
		String sql = "select * from emp";
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template.query(sql, new RowMapper<EmpVo>() {

			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"), rs.getInt("sal"),
						rs.getString("ename"), rs.getString("job")
						);
			}
			
		});
		
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		String sql = "insert emp (empno,sal,ename,job) values (?,?,?,?)";
		JdbcTemplate template = new JdbcTemplate(dataSource);
		template.update(sql, bean.getEmpno(),bean.getSal(),bean.getEname(),bean.getJob());
	}

	@Override
	public EmpVo selectOne(int empno) throws SQLException {
		String sql = "select * from emp where empno = ?";
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template.queryForObject(sql, new RowMapper<EmpVo>() {

			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new EmpVo(
						rs.getInt("empno"), rs.getInt("sal"),
						rs.getString("ename"), rs.getString("job")
						);
			}
			
		}, empno);
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		String sql = "update emp set ename=?,sal=?,job=? where empno=?";
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template.update(sql, bean.getEname(), bean.getSal(), bean.getJob(), bean.getEmpno());
	}

	@Override
	public int deleteOne(int empno) throws SQLException {
		String sql = "delete from emp where empno=?";
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template.update(sql, empno);
	}

}
