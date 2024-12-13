package today_12_12_24;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import today_12_12_24.constraints.com.Notes;
import today_12_12_24.deposit.com.AtmDeposit;
import today_12_12_24.print.com.Print;
import today_12_12_24.withdraw.com.Withdraw;
/**
 * ATM Machine Operation Class 
 * ATM operations deposit/withdraw/check balance
 */
public class Atm {
	
	// Denomination for track Notes count with noteType
	private Map<Integer, Integer> denomination;
	private Integer totalAmount;
	private AtmDeposit atmDeposit;
	private Print print;
	private Withdraw withdraw;

	/**
	 * create object with all the notes default value 0
	 * initialize other objects
	 */
	public Atm() {
		totalAmount = 0;
		print = new Print();
		denomination = new HashMap<>();
		for(Notes note : Notes.values()) {
			denomination.put(note.getNote(), 0);
		}
		atmDeposit = new AtmDeposit(denomination);
		withdraw = new Withdraw(denomination, print);
	}
	
	/**
	 * Deposit Cash into ATM
	 * 
	 * @param totalNotes
	 */
	public void depositCash(Integer... totalNotes) {
		atmDeposit.depositCash(totalNotes, totalAmount);
	}
	
	/**
	 * Withdraw Functionality
	 * 
	 * @param withdrawAmount
	 */
	public void withdrawAmount(int withdrawAmount) {
		totalAmount -= withdraw.withdrawAmount(withdrawAmount, totalAmount);
	}
	
	/**
	 * Print Balance
	 */
	public void printBalance() {
		print.printBalance(totalAmount);
	}
 
}
