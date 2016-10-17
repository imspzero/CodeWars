package pers.sam.practice;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void test1() throws Exception {
		//fail("Not yet implemented");
		User user = new User();
		
		assertEquals(-8, user.rank);
		assertEquals(0, user.progress);
		
		user.incProgress(-7);
		
		assertEquals(10, user.progress);
		
		user.incProgress(-5); 
		
		assertEquals(-7, user.rank);
		assertEquals(0, user.progress);
		
		user.incProgress(-5);
		assertEquals(-7, user.rank);
		assertEquals(40, user.progress);
		
		user.incProgress(-5);
		assertEquals(-7, user.rank);
		assertEquals(80, user.progress);
		
		user.incProgress(-5);
		assertEquals(-6, user.rank);
		assertEquals(20, user.progress);
		
		user.incProgress(-1);
		assertEquals(-4, user.rank);
		assertEquals(70, user.progress);
		
		user.incProgress(1);
		assertEquals(-2, user.rank);
		assertEquals(30, user.progress);
		
		user.incProgress(1);
		assertEquals(-2, user.rank);
		assertEquals(70, user.progress);
		
		user.incProgress(4);
		assertEquals(2, user.rank);
		assertEquals(20, user.progress);
		
		user.incProgress(-3);
		assertEquals(2, user.rank);
		assertEquals(20, user.progress);
		
		user.incProgress(1);
		assertEquals(2, user.rank);
		assertEquals(21, user.progress);
		
		user.incProgress(2);
		assertEquals(2, user.rank);
		assertEquals(24, user.progress);
		
		user.incProgress(3);
		assertEquals(2, user.rank);
		assertEquals(34, user.progress);
		
		user.incProgress(8);
		assertEquals(5, user.rank);
		assertEquals(94, user.progress);
		
		user.incProgress(8);
		assertEquals(6, user.rank);
		assertEquals(84, user.progress);
		
	}
	
	@Test
	public void test2() throws Exception {
		//fail("Not yet implemented");
		User user = new User();
		
		assertEquals(-8, user.rank);
		assertEquals(0, user.progress);
		
		user.incProgress(6);	
		assertEquals(8, user.rank);
		assertEquals(0, user.progress);
		
	}
	
	@Test
	public void test3() throws Exception {
		//fail("Not yet implemented");
		User user = new User();
		user.rank = 1;
		user.progress = 20;
		user.incProgress(-1);	
		assertEquals(1, user.rank);
		assertEquals(21, user.progress);
		
	}
	
	@Test
	public void test4() throws Exception {
		//fail("Not yet implemented");
		User user = new User();
		user.rank = -8;
		user.progress = 0;
		user.incProgress(1);	
		assertEquals(-2, user.rank);
		assertEquals(40, user.progress);
	}
	
}
