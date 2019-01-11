package atm;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Atm {

	NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
	private BigDecimal balance;
	private int pin;

	public Object getBalance() {
		return currency.format(balance);
	}

	public void withdraw(BigDecimal withdrawAmount) {
		if (balance.compareTo(withdrawAmount) >= 0) {
			balance = balance.subtract(withdrawAmount);
			System.out.println("Updated balance is: " + currency.format(balance));
		} else {
			System.out.println("cannot withdraw more than available balance");
		}
	}

	public void deposit(BigDecimal depositAmount) {
		balance = balance.add(depositAmount);
		System.out.println("Updated balance is: " + currency.format(balance));
	}

	public boolean checkPin(int pinToCheck) {
		if (pinToCheck == pin) {
			return true;
		}
		System.out.println("incorrect PIN, try again");
		return false;

	}

	public Atm(BigDecimal balance, int pin) {
		this.balance = balance;
		this.pin = pin;
	}

}
