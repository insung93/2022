package com.bit.emp.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpDaoTest {
	static EmpDao empDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac = null;
		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		empDao = (EmpDao) ac.getBean("empDao");
//		empDao = ac.getBean(new EmpDaoImpl1().getClass());
		empDao = ac.getBean(EmpDao.class);
	}

	@Before
	public void setUp() throws Exception {
		assertNotNull(empDao);
	}

	@Test
	public void test() throws SQLException {
		assertNotEquals(0, empDao.selectAll().size());
	}

}
