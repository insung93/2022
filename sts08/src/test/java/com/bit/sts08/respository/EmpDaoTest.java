package com.bit.sts08.respository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts08.domain.Emp;
import com.bit.sts08.repository.EmpDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class EmpDaoTest {
	static int total;

	@Autowired
	EmpDao empDao;

	@Test
	public void test6Totalsize() {
		assertEquals(total, empDao.totalSize());
	}
	
	@Test
	public void test7FindMany() {
		assertTrue(empDao.findMany("test").size()>0);
	}

	@Test
	public void test1FindAll() {
		assertNotNull(empDao.findAll());
	}

	@Test
	public void test3FindOne() {
		assertNotNull(empDao.findOne(702));
		log.debug(empDao.findOne(702).toString());
	}

	static Emp emp = new Emp(703, 777, "test", "tester", null);

	@Transactional
	@Test
	public void test2InsertOne() {
		assertNotEquals(0, empDao.insertOne(emp));
		log.debug(empDao.findOne(702).toString());
	}

	@Transactional
	@Test
	public void test4UpdateOne() {
		Emp emp = empDao.findOne(999);
		emp.setEname("edit");
		assertNotEquals(0, empDao.updateOne(emp));
		assertEquals(emp.getEname(), empDao.findOne(emp.getEmpno()).getEname());
		assertEquals(emp.getSal(), empDao.findOne(emp.getEmpno()).getSal());
		assertEquals(emp.getJob(), empDao.findOne(emp.getEmpno()).getJob());
//		assertEquals(emp, empDao.updateOne(emp));	// hasAndEquals에서 날짜 제외해야함
	}
	
	@Transactional
	@Test
	public void test5DeleteOne() {
		assertNotEquals(0, empDao.deleteOne(999));
		assertNull(empDao.findOne(999));
	}
}
