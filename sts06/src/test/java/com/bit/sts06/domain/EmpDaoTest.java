package com.bit.sts06.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDaoTest {
	
//	Logger log = Logger.getLogger(getClass());
//	Logger log = LoggerFactory.getLogger(getClass());
	
	static EmpDao empDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		empDao = ac.getBean(EmpDao.class);
	}
	
	private int cnt;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		assertNotNull(empDao);
		assertNotNull(empDao.findAll());
		cnt = empDao.findAll().size();
		assertNotEquals(0, cnt);
		log.debug("size : " + cnt);
		
		List<EmpVo> list = empDao.findAll();
		
		for(EmpVo vo : list) 
			System.out.println(vo);
	}
	
	@Test
	public void test2() throws SQLException {
		assertNotNull(empDao);
		try {
			log.debug(empDao.findOne(1000).toString());
			fail();
		} catch(Exception e) {
		}
		assertNotNull(empDao.findOne(1001));
	}
	
	@Test
//	@RunWith 로 테스트 실행시 디폴트로 롤백됨
//	@Transactional
//	@Rollback
	public void test3() throws Exception {
		assertNotNull(empDao);
		EmpVo target = new EmpVo(750,1,"test","tester",null);
//		int before = empDao.findAll().size();
		empDao.insertOne(target);
//		assertEquals(before+1, empDao.findAll().size());
		assertEquals(1, empDao.updateOne(target));
		assertEquals(1, empDao.deleteOne(target.getEmpno()));
		
	}
	
	@Test
	public void findSize() throws Exception {
		empDao.findSize();
	}
}
