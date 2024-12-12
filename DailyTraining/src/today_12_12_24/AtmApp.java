package today_12_12_24;


import java.util.Scanner;

/**
 * ATM machine program main class
 */
public class AtmApp {
	
	public static void main(String[] args) {
		
		Atm atm = new Atm();
		Boolean inProgress = true;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to ATM");
		
		while(inProgress) {
			
			System.out.println("""
					\n\nPress 1 for Deposit
					Press 2 for withdraw
					Press 3 for check balance
					Press 4 for EXIT
					Please enter your choice: 
					""");
			Integer choice = sc.nextInt();
			
			try {
				switch (choice) {
					case 1: {
						System.out.println("Enter how many 100 note you have : ");
						Integer oneHundredAmount = sc.nextInt();
						System.out.println("Enter how many 200 note you have : ");
						Integer twoHundredAmount = sc.nextInt();
						System.out.println("Enter how many 500 note you have : ");
						Integer threeHundredAmount = sc.nextInt();
						
						atm.depositCash(oneHundredAmount, twoHundredAmount, threeHundredAmount);
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

