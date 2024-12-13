package today_12_12_24.print.com;

import today_12_12_24.constraints.com.Constraints;
import today_12_12_24.constraints.com.Notes;

/**
 * Print Input and Output transactions
 */
public class Print {
	
	/**
	 * Check balance in my ATM
	 */
	public void printBalance(Integer totalAmount) {
		System.out.println("\n\nYour balance : " + totalAmount + "\n\n");
	}

	public void afterWithdraw(Integer[] noteWithdraw) {
		System.out.println("\n\nTotal Notes you will collect");
		
		Integer index = 0;
		for(Notes note : Notes.values()) {
			if(noteWithdraw[index] != null) {
				System.out.println(note.getNote() 
						+ Constraints.WITHDRAW_PRINT.getPrintValue() 
						+ noteWithdraw[index++]);
			}
		}
	}
	
}
