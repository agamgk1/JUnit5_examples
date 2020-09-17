package money;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	public void testSimpleAdd() {

		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(14, "CHF");
		Money expected = new Money(26, "CHF");
		Money result = m12CHF.add(m14CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	public void testSimpleAddZero() {

		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(0, "CHF");
		Money result = m12CHF.add(m14CHF);
		assertTrue(m12CHF.equals(result));
	}

	@Test
	public void testEquals() {

		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(14, "CHF");
		Money m12USD = new Money(12, "USD");
		
		assertFalse(m12CHF.equals(null));
		assertFalse(m14CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertFalse(m14CHF.equals(m12CHF));
		assertFalse(m12CHF.equals(m14CHF));
		assertFalse(m12CHF.equals(m12USD));


	}

	@Test
	void testSimpleMultiple() {

		Money m12CHF = new Money(12, "CHF");
		Money expected = new Money(24, "CHF");
		Money result2 = m12CHF.multiply(2);
		Money result3 = m12CHF.multiply(1);
		assertTrue(expected.equals(result2));
		assertTrue(m12CHF.equals(result3));
	}

	@Test
	void testAddPLNCHF() {

		Money m12PLN = new Money(12, "PLN");
		Money m16CHF = new Money(16, "CHF");
		Money expected = new Money(75.2, "PLN");
		Money result = m12PLN.addDiffCurrency(m16CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	void testAddCHFPLN() {

		Money m16CHF = new Money(16, "CHF");
		Money m12PLN = new Money(12, "PLN");
		Money expected = new Money(75.2, "PLN");
		Money result = m16CHF.addDiffCurrency(m12PLN);
		assertTrue(expected.equals(result));
	}

	@Test
	void testAddPLNPLN() {

		Money m10PLN = new Money(10, "PLN");
		Money m20PLN = new Money(20, "PLN");
		Money expected = new Money(30, "PLN");
		Money result = m10PLN.addDiffCurrency(m20PLN);
		assertTrue(expected.equals(result));
	}

	@Test
	void testAddCHFCHF() {

		Money m10CHF = new Money(10, "CHF");
		Money m20CHF = new Money(20, "CHF");
		Money expected = new Money(118.5, "PLN");
		Money result = m10CHF.addDiffCurrency(m20CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	void testAddUSDUSD() {

		Money m10CHF = new Money(10, "USD");
		Money m20CHF = new Money(10, "USD");
		Money expected = new Money(76, "PLN");
		Money result = m10CHF.addDiffCurrency(m20CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	void testAddUSDPLN() {

		Money m10CHF = new Money(10, "USD");
		Money m20CHF = new Money(10, "PLN");
		Money expected = new Money(48, "PLN");
		Money result = m10CHF.addDiffCurrency(m20CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	void testAddPLNUSD() {

		Money m10CHF = new Money(10, "PLN");
		Money m20CHF = new Money(10, "USD");
		Money expected = new Money(48, "PLN");
		Money result = m10CHF.addDiffCurrency(m20CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	void testAddUSDCHF() {

		Money m10CHF = new Money(10, "USD");
		Money m20CHF = new Money(10, "CHF");
		Money expected = new Money(77.5, "PLN");
		Money result = m10CHF.addDiffCurrency(m20CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	void testAddCHFUSD() {

		Money m10CHF = new Money(10, "CHF");
		Money m20CHF = new Money(10, "USD");
		Money expected = new Money(77.5, "PLN");
		Money result = m10CHF.addDiffCurrency(m20CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	void testAddDiffCurrencyNullresultCHF() {

		Money m10CHF = new Money(10, "CHF");
		Money m20aaa = new Money(20, "aaa");
		Money result = m10CHF.addDiffCurrency(m20aaa);
		assertEquals(null, result); //
	}

	@Test
	void testAddDiffCurrencyNullresultPLN() {

		Money m10PLN = new Money(10, "PLN");
		Money m20aaa = new Money(20, "aaa");
		Money result = m10PLN.addDiffCurrency(m20aaa);
		assertEquals(null, result);
	}

	@Test
	void testAddDiffCurrencyNullresultUSD() {

		Money m10PLN = new Money(10, "USD");
		Money m20aaa = new Money(20, "aaa");
		Money result = m10PLN.addDiffCurrency(m20aaa);
		assertEquals(null, result);
	}

	@Test
	void testEqualsDiffrentCurrencyAmountTrue() {

		Money m10CHF = new Money(10, "CHF");
		Money m10PLN = new Money(39.5, "PLN");
		Money m10USD = new Money(39.5 / 3.80, "USD");

		assertTrue(m10CHF.equalsDiffrentCurrencyAmount(m10PLN));
		assertTrue(m10PLN.equalsDiffrentCurrencyAmount(m10CHF));
		assertTrue(m10USD.equalsDiffrentCurrencyAmount(m10PLN));
		assertTrue(m10PLN.equalsDiffrentCurrencyAmount(m10USD));
		assertTrue(m10USD.equalsDiffrentCurrencyAmount(m10CHF));
		assertTrue(m10CHF.equalsDiffrentCurrencyAmount(m10USD));
		assertTrue(m10PLN.equalsDiffrentCurrencyAmount(m10PLN));
		assertTrue(m10CHF.equalsDiffrentCurrencyAmount(m10CHF));
		assertTrue(m10USD.equalsDiffrentCurrencyAmount(m10USD));

	}

	@Test
	void testEqualsDiffrentCurrencyAmountFalse() {

		Money m10CHF = new Money(10, "CHF");
		Money m11CHF = new Money(11, "CHF");
		Money m10PLN = new Money(39.5, "PLN");
		Money m10USD = new Money(39.5 / 3.80, "USD");
		Money m11USD = new Money(49.5 / 3.80, "USD");
		Money m11PLN = new Money(49.5, "PLN");

		assertFalse(m11CHF.equalsDiffrentCurrencyAmount(m10PLN));
		assertFalse(m10PLN.equalsDiffrentCurrencyAmount(m11CHF));
		assertFalse(m11USD.equalsDiffrentCurrencyAmount(m10PLN));
		assertFalse(m10USD.equalsDiffrentCurrencyAmount(m11PLN));
		assertFalse(m11PLN.equalsDiffrentCurrencyAmount(m10USD));
		assertFalse(m10USD.equalsDiffrentCurrencyAmount(m11CHF));
		assertFalse(m11CHF.equalsDiffrentCurrencyAmount(m10USD));
		assertFalse(m11USD.equalsDiffrentCurrencyAmount(m10CHF));
		assertFalse(m11PLN.equalsDiffrentCurrencyAmount(m10PLN));
		assertFalse(m11CHF.equalsDiffrentCurrencyAmount(m10CHF));
		assertFalse(m11USD.equalsDiffrentCurrencyAmount(m10USD));

	}
	@Test
	void testEqualsDiffrentCurrencyAmountNull() {

		Money m10CHF = new Money(10, "CHF");
		Money m10PLN = new Money(39.5, "PLN");
		Money m10USD = new Money(39.5 / 3.80, "USD");

		assertFalse(m10CHF.equalsDiffrentCurrencyAmount(null));
		assertFalse(m10PLN.equalsDiffrentCurrencyAmount(null));
		assertFalse(m10USD.equalsDiffrentCurrencyAmount(null));
	}
}