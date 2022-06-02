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
	
	public void insertOne(EmpVo bean) throws SQLException {
		String sql = "insert into emp (empno, sal, ename, job, hiredate) values (?,?,?,?,now())";
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setInt(1, bean.getEmpno());
			pstmt.setInt(2, bean.getSal());
			pstmt.setString(3, bean.getEname());
			pstmt.setString(4, bean.getJob());
			pstmt.executeUpdate();
		}
	}
	
	public int updateOne(EmpVo bean) throws SQLException {
		String sql = "update emp set sal=?,ename=?,job=? where empno=?";
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setInt(1, bean.getSal());
			pstmt.setString(2, bean.getEname());
			pstmt.setString(3, bean.getJob());
			pstmt.setInt(4, bean.getEmpno());
			return pstmt.executeUpdate();
		}
	}
	
	public int deleteOne(int empno) throws SQLException {
		String sql = "delete from emp where empno=?";
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setInt(1, empno);
			return pstmt.executeUpdate();
		}
	}
	
	public EmpVo selectOne(int empno) throws SQLException {
		String sql = "select * from emp where empno = ?";
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				) {
			pstmt.setInt(1, empno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				return new EmpVo(
						rs.getInt("empno"), rs.getInt("sal"),
						rs.getString("ename"), rs.getString("job"),
						rs.getDate("hiredate")
						);
		}
		return null;
	}
	
}
