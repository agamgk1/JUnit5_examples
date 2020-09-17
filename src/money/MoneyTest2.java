package money;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoneyTest2 {
	private Money m12CHF;
	private Money m14CHF;

	@BeforeEach
	public void setUp() throws Exception {
		m12CHF = new Money(12, "CHF");
		m14CHF = new Money(14, "CHF");
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleAdd2() {
		Money expected = new Money(26, "CHF");
		Money result = m12CHF.add(m14CHF); //
		assertTrue(expected.equals(result)); //
	}

	@Test
	public void testEquals2() {
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
	}

}
