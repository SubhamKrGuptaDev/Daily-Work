package today_12_12_24.deposit.com;

import java.util.Map;

import today_12_12_24.constraints.com.Notes;

public class AtmDeposit {
	
	private final Map<Integer, Integer> denomination;
	
	public AtmDeposit(Map<Integer, Integer> denomination) {
		this.denomination = denomination;
	}
	
	/**
	 * Deposit the amount to respective notes and increase count
	 * 
	 * @param totalNotes
	 * @param totalAmount
	 */
	public void depositCash(Integer[] totalNotes, Integer totalAmount) {
		Integer i=0;
		for(Notes note : Notes.values()) {
			addAmount(note.getNote(), totalNotes[i++], totalAmount);
		}
	}
	
	/**
	 * Add amount notes to denomination Map and update the total amount
	 *  
	 * @param noteType
	 * @param amount
	 */
	private void addAmount(Integer noteType, Integer amount, Integer totalAmount) {
		Integer existAmount = denomination.get(noteType);
		denomination.put(noteType, existAmount + amount);
		totalAmount += noteType * amount;
	}
	
}
