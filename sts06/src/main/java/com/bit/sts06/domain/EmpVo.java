package com.bit.sts06.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmpVo {
	private int empno, sal;
	private String ename, job;
	private Timestamp hiredate;

}
