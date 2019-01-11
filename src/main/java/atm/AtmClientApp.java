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
		do {
			correctPin = atm.checkPin(input.nextInt());
		} while (!correctPin);
		int menuChoice;
		do {
			System.out.println("Menu:\n1. deposit\n2. withdraw\n3. balance\n4. exit");
			menuChoice = input.nextInt();
			input.nextLine();
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
