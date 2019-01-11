package atm;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class AtmTest {
	BigDecimal testBalance = new BigDecimal(100);
	int pin = 1234;
	Atm undertest = new Atm(testBalance, pin);
	
	@Test
	public void shouldHaveDefaultBalance() {
		assertEquals("$100.00",undertest.getBalance());
	}
	@Test
	public void shouldWithdrawFromBalance() {
		BigDecimal testWithdraw = new BigDecimal(20);
		undertest.withdraw(testWithdraw);
		assertEquals("$80.00",undertest.getBalance());
	}
	@Test
	public void shouldNotWithdrawMoreThanBalance() {
		BigDecimal testWithdraw = new BigDecimal(110);
		undertest.withdraw(testWithdraw);
		assertEquals("$100.00",undertest.getBalance());
	}
	@Test
	public void shouldAllowDeposit() {
		BigDecimal testDeposit = new BigDecimal(5.55);
		undertest.deposit(testDeposit);
		assertEquals("$105.55",undertest.getBalance());
	}
	@Test
	public void shouldAllowCorrectPin() {
		assertEquals(true,undertest.checkPin(1234));
	}
	@Test
	public void shouldNotAllowWrongPin() {
		assertEquals(false,undertest.checkPin(1111));
	}
	
}