package today_12_12_24;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ATM Machine Operation Class 
 * ATM operations deposit/withdraw/check balance
 */
public class Atm {
	
	// Denomination how many notes with note type having in ATM 
	private Map<Integer, Integer> denomination;
	private Integer totalAmount;

	/**
	 * create object with all the notes default value 0
	 */
	public Atm() {
		totalAmount = 0;
		denomination = new HashMap<>();
		for(Notes note : Notes.values()) {
			denomination.put(note.getNote(), 0);
		}
	}
	
	/**
	 * Deposit the amount to respective notes and increase count
	 * 
	 * @param oneHundred
	 * @param twoHundred
	 * @param fiveHundred
	 */
	public void depositCash(Integer... totalNotes) {
		Integer i=0;
		for(Notes note : Notes.values()) {
			addAmount(note.getNote(), totalNotes[i++]);
		}
	}
	
	/**
	 * Add amount notes to denomination Map and update the total amount
	 *  
	 * @param noteType
	 * @param amount
	 */
	private void addAmount(Integer noteType, Integer amount) {
		Integer existAmount = denomination.get(noteType);
		denomination.put(noteType, existAmount + amount);
		totalAmount += noteType * amount;
	}
	
	/**
	 * Withdraw amount if amount is valid
	 * 
	 * @param withdrawAmount
	 */
	public void withdrawAmount(int withdrawAmount) {
		Notes[] listNotes = Notes.values();
		
		if(isValidAmount(withdrawAmount, listNotes[listNotes.length - 1].getNote())) {
			withdrawOperation(withdrawAmount);
		} else {
			throw new RuntimeException("Sorry amount value is not correct!");
		}

	}
	
	/**
	 * Withdraw operation logic
	 * withdrawAmount < 0 or withdrawAmount > totalAmount operation throw exception
	 * Number of note need = withdrawAmount / Notevalue
	 * RemeningAmount = withdrawAmount % NoteValue 
	 * Store number of notes on notwWithdraw DESC order
	 * 
	 * @param withdrawAmount
	 */
	private void withdrawOperation(int withdrawAmount) {
		
		if(withdrawAmount < 0) { 
			throw new RuntimeException("Negative value not allow :(");
		}
		
		if(withdrawAmount > totalAmount) {
			throw new RuntimeException("Insufficient balance :(\nYour Balance : " + totalAmount);
		}
		
		Integer prevwithdrawAmount = withdrawAmount;
		
		Integer notesLen = Notes.values().length;
		Integer[] noteWithdraw = new Integer[notesLen];
		
		Integer index = 0;
		for(Notes note : Notes.values()) {
			if(denomination.get(note.getNote()) > 0 && withdrawAmount >= note.getNote()) {
				noteWithdraw[index++] = withdrawAmount / note.getNote();
				withdrawAmount = withdrawAmount % note.getNote();
			}
		}
		
		System.out.println("\n\nTotal Notes you will collect");
		
		index = 0;
		for(Notes note : Notes.values()) {
			if(noteWithdraw[index] != null) {
				System.out.println(note.getNote() 
						+ Constrans.WITHDRAW_PRINT.getPrintValue() 
						+ noteWithdraw[index++]);
			}
		}
		
		totalAmount -= prevwithdrawAmount;
	}
	
	/**
	 * Check balance in my ATM
	 */
	public void printBalance() {
		System.out.println("\n\nYour balance : " + totalAmount + "\n\n");
	}
	
	/**
	 * Module with the last note if reminder have it's not valid
	 * 
	 * @param amount
	 * @return
	 */
	private Boolean isValidAmount(Integer amount, Integer smallestNote) {
		return amount % smallestNote == 0;
	}
 
}