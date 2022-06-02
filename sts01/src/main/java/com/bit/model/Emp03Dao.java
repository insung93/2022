package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Emp03Dao extends JdbcDaoSupport implements EmpDao{
	
	public Emp03Dao() {
		System.out.println("new Dao...");
	}
	
	
@Override
	public List<EmpVo> selectAll() throws SQLException {
		
		String sql = "select * from emp";
		RowMapper<EmpVo> rowMapper = new RowMapper<EmpVo>() {

			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"), rs.getInt("sal"),
						rs.getString("ename"), rs.getString("job")
						);
			}
			
		};
		JdbcTemplate template = this.getJdbcTemplate();
		template.query(sql, rowMapper);
//		template.setDataSource(dataSource);
		return template.query(sql, rowMapper); 
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		String sql = "insert into emp (empno,sal,ename,job) values (?,?,?,?)";
		JdbcTemplate template = getJdbcTemplate();
		template.update(sql, new Object[] {bean.getEmpno(),bean.getSal(),bean.getEname(),bean.getJob()});
	}

	@Override
	public EmpVo selectOne(int empno) throws SQLException {
		String sql = "select * from emp where empno = ?";
		JdbcTemplate template = getJdbcTemplate();
		RowMapper<EmpVo> rowMapper = new RowMapper<EmpVo>() {

			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"), rs.getInt("sal"),
						rs.getString("ename"), rs.getString("job")
						);
			}
		};
		return template.queryForObject(sql, new Object[] {empno}, rowMapper);
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		String sql = "update emp set ename=?,sal=?,job=? where empno=?";
		return getJdbcTemplate().update(sql, bean.getEname(),bean.getSal(),bean.getJob(),bean.getEmpno());
	}

	@Override
	public int deleteOne(int empno) throws SQLException {
		String sql = "delete from emp where empno=?";
		return getJdbcTemplate().update(sql, empno);
	}
}
