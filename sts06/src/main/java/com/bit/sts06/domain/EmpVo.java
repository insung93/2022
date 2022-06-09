package com.bit.sts06.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpVo {
	private int empno, sal;
	private String ename, job;
	private Timestamp hiredate;

}
