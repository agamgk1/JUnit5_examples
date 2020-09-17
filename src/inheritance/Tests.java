package inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class Tests {
	
	
	private GregorianCalendar calendar;
	private Date hireDay;
	private Manager m1; 
	
	@BeforeEach
	public void setUp() throws Exception {
		m1 = new Manager("Carl Cracker", 80000, 1987, 12, 15);
	}

	@Test
	public void testBonusEqualsZero() {
		
		assertEquals(m1.getSalary(), 80000);
	}
	
	@Test 
	public void salaryTestWithoutBonus() {
		
		assertEquals(m1.getSalary(), 80000);	
	}
	@Test 
	public void salaryTestAfterBonus() {
		
		m1.setBonus(10000);
		assertEquals(m1.getSalary(), 90000);	
	}
	
	@Test 
	public void nameTest() {
		assertEquals(m1.getName(), "Carl Cracker");
	}
	
	@Test
	public void hireDayTest() {
		calendar = new GregorianCalendar(1987, 12 - 1, 15);
		hireDay = calendar.getTime();
		assertEquals(m1.getHireDay(), hireDay);
	}
	
	@Test void raiseSalaryTest() {
		m1.raiseSalary(10);
		assertEquals(m1.getSalary(), 88000);
	}
	
	
	
	
}
