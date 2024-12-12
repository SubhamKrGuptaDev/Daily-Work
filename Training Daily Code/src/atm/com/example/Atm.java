package atm.com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ATM Machine Operation Class 
 * ATM operations deposit/withdraw/check balance
 */
public class Atm {
	
	private Map<Integer, Integer> denomination;
	private Integer totalAmount;

	/**
	 * 
	 */
	public Atm() {
		denomination = new HashMap<>();
		for(Notes note : Notes.values()) {
			denomination.put(note.getNote(), 0);
		}
	}
	
	/**
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
	 * 
	 * @param withdrawAmount
	 */
	public void withdrawAmount(int withdrawAmount) {
		if(isValidAmount(withdrawAmount)) {
			// Withdraw Operation
			withdrawOperation(withdrawAmount);
		} else {
			throw new RuntimeException("Sorry amount value is not correct!");
		}
		
	}
	
	/**
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
		
//		int oneHundred = 0;
//		int twoHundred = 0;
//		int fiveHundred = 0;
		
		// 500, 200, 100
		Integer[] noteNeed = {0,0,0};
		
		Integer prevwithdrawAmount = withdrawAmount;
		Integer len = Notes.values().length;
		
		for(Integer i=len-1; i>=0; i--) {
			
		}
		
		
//		// 500
//		for(int i=n-1; i>=0; i--) {
//			while(denomination.get(notes[2]) > 0 && withdrawAmount >= notes[i]) {
//				fiveHundred++;
//				withdrawAmount -= notes[i];
//				denomination.put(notes[2], denomination.get(notes[2]) - 1);
//			}
//		}
//		
//		// 200
//		while(denomination.get(notes[1]) > 0 && withdrawAmount >= 200) {
//			twoHundred++;
//			withdrawAmount -= 200;
//			denomination.put(notes[1], denomination.get(notes[1]) - 1);
//		}
//		
//		// 100
//		while(denomination.get(notes[0]) > 0 && withdrawAmount >= 100) {
//			oneHundred++;
//			withdrawAmount -= 100;
//			denomination.put(notes[0], denomination.get(notes[0]) - 1);
//		}
		
		// Print Result
		System.out.println("\n\nTotal notes you will collect: ");
		System.out.println("500 Notes: " + fiveHundred);
		System.out.println("200 Notes: " + twoHundred);
		System.out.println("100 Notes: " + oneHundred);
		totalAmount -= prevwithdrawAmount;
	}
	
	/**
	 * 
	 */
	public void printBalance() {
		System.out.println("\n\nYour balance : " + totalAmount + "\n\n");
	}
	
	/**
	 * 
	 * @param amount
	 * @return
	 */
	private Boolean isValidAmount(int amount) {
		return amount % 100 == 0;
	}
	
	/**
	 * 
	 * @param noteType
	 * @param amount
	 */
	private void addAmount(Integer noteType, Integer amount) {
		Integer existAmount = denomination.get(noteType);
		denomination.put(noteType, existAmount + amount);
		totalAmount += noteType * amount;
	}
 
}
