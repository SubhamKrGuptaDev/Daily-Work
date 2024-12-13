package today_12_12_24;


import java.util.Scanner;

import today_12_12_24.enums.com.Constraints;
import today_12_12_24.enums.com.Notes;

/**
 * ATM machine main class
 */
public class AtmApp {
	
	public static void main(String[] args) {
		
		Atm atm = new Atm();
		Boolean inProgress = true;
		
		Scanner sc = new Scanner(System.in);
		System.out.println(Constraints.WELCOME_PRINT);
		
		/**
		 * infinity loop for continue running
		 * loop store if in switch case 4 option select 
		 */
		while(inProgress) {
			
			System.out.println("""
					\n\nPress 1 for Deposit
					Press 2 for withdraw
					Press 3 for check balance
					Press 4 for EXIT
					Please enter your choice: """);
			Integer choice = sc.nextInt();
			
			try {
				switch (choice) {
					case 1: {
						System.out.println(Constraints.ENTER_HOW_MANY_PRINT.getPrintValue() 
								+ Notes.ONE_HUNDRED.getNote() 
								+ Constraints.NOTE_YOU_HAVE_PRINT.getPrintValue());
						Integer oneHundredAmount = sc.nextInt();
						
						System.out.println(Constraints.ENTER_HOW_MANY_PRINT.getPrintValue() 
								+ Notes.TWO_HUNDRED.getNote() 
								+ Constraints.NOTE_YOU_HAVE_PRINT.getPrintValue());
						Integer twoHundredAmount = sc.nextInt();
						
						System.out.println(Constraints.ENTER_HOW_MANY_PRINT.getPrintValue() 
								+ Notes.FIVE_HUNDRED.getNote() 
								+ Constraints.NOTE_YOU_HAVE_PRINT.getPrintValue());
						Integer fiveHundredAmount = sc.nextInt();
						
						atm.depositCash(fiveHundredAmount, twoHundredAmount, oneHundredAmount);
						break;
					}
					case 2: {
						System.out.println("Enter withdraw amount : ");
						Integer amount = sc.nextInt();
						atm.withdrawAmount(amount);
						break;
					}
					case 3: {
						atm.printBalance();
						break;
					}
					case 4: {
						inProgress = false;
						break;
					}
					default: {
						throw new IllegalArgumentException("Unexpected value: " + choice);
					}
				
				}
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		
		}
		
		System.out.println("Thank You");
	}
}

