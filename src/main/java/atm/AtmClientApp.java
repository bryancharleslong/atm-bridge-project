package atm;

import java.math.BigDecimal;
import java.util.Scanner;

public class AtmClientApp {

	public static void main(String[] args) {
		BigDecimal startingBalance = new BigDecimal(100);
		Atm atm = new Atm(startingBalance, 1234);
		boolean correctPin = false;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the bank!");
		System.out.println("Please enter your four digit PIN");
		String pinInput = "";
		do {
			for (;;) {
				try {
					pinInput = input.nextLine();
					Integer.parseInt(pinInput);
					break;
				} catch (NumberFormatException e) {
					System.out.println("enter a four digit number");
					continue;
				}
			}
			correctPin = atm.checkPin(Integer.parseInt(pinInput));
		} while (!correctPin);
		int menuChoice;
		String menuInput = "";
		do {
			System.out.println("Menu:\n1. deposit\n2. withdraw\n3. balance\n4. exit");
			for (;;) {
				try {
					menuInput = input.nextLine();
					Integer.parseInt(menuInput);
					break;
				} catch (NumberFormatException e) {
					System.out.println("please enter a single digit to select");
					continue;
				}
			}
			menuChoice = Integer.parseInt(menuInput);
			if (menuChoice == 1) {
				System.out.println("deposit amount?");
				BigDecimal depositAmount = new BigDecimal(input.nextLine());
				atm.deposit(depositAmount);
			}
			if (menuChoice == 2) {
				System.out.println("withdraw amount?");
				BigDecimal withdrawAmount = new BigDecimal(input.nextLine());
				atm.withdraw(withdrawAmount);
			}
			if (menuChoice == 3) {
				System.out.println("Your balance is " + atm.getBalance());
			}
		} while (menuChoice != 4);
		System.out.println("goodbye");
		input.close();
	}
}
