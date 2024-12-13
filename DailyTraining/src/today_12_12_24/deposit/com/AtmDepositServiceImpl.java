package today_12_12_24.deposit.com;

import java.util.Map;

import today_12_12_24.enums.com.Notes;

/**
 * ATM Deposit Service Implementation class
 */
public class AtmDepositServiceImpl implements AtmDepositService {
	
	private final Map<Integer, Integer> denomination;
	
	public AtmDepositServiceImpl(Map<Integer, Integer> denomination) {
		this.denomination = denomination;
	}
	
	/**
	 * Deposit the amount to respective notes and increase count
	 * 
	 * @param totalNotes
	 * @param totalAmount
	 */
	@Override
	public Integer depositCash(Integer[] totalNotes, Integer totalAmount) {
		Integer[] totalAmountObj = {totalAmount};
		Integer i=0;
		for(Notes note : Notes.values()) {
			addAmount(note.getNote(), totalNotes[i++], totalAmountObj);
		}
		return totalAmountObj[0];
	}
	
	/**
	 * Add amount notes to denomination Map and update the total amount
	 *  
	 * @param noteType
	 * @param amount
	 */
	private void addAmount(Integer noteType, Integer amount, Integer[] totalAmountObj) {
		Integer existAmount = denomination.get(noteType);
		denomination.put(noteType, existAmount + amount);
		totalAmountObj[0] += noteType * amount;
	}
	
}
