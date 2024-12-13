package today_12_12_24.withdraw.com;

import java.util.Map;

import today_12_12_24.constraints.com.Constraints;
import today_12_12_24.constraints.com.Notes;
import today_12_12_24.print.com.Print;

public class Withdraw {

	private final Map<Integer, Integer> denomination;
	private final Print print;
	
	public Withdraw(Map<Integer, Integer> denomination, Print print) {
		this.denomination = denomination;
		this.print = print;
	}
	
	/**
	 * Withdraw amount if amount is valid
	 * 
	 * @param withdrawAmount
	 */
	public Integer withdrawAmount(int withdrawAmount, Integer totalAmount) {
		Notes[] listNotes = Notes.values();
		
		if(isValidAmount(withdrawAmount, listNotes[listNotes.length - 1].getNote())) {
			return withdrawOperation(withdrawAmount, totalAmount);
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
	private Integer withdrawOperation(int withdrawAmount, Integer totalAmount) {
		validation(withdrawAmount, totalAmount);
		
		Integer prevwithdrawAmount = withdrawAmount;
		
		Integer notesLen = Notes.values().length;
		Integer[] noteWithdraw = new Integer[notesLen];
		
		Integer index = 0;
		for(Notes note : Notes.values()) {
			if(denomination.get(note.getNote()) > 0 && withdrawAmount >= note.getNote()) {
				noteWithdraw[index++] = withdrawAmount / note.getNote();
				withdrawAmount = withdrawAmount % note.getNote();
				denomination.put(note.getNote(), denomination.get(note.getNote()) - 1);
			}
		}
		
		print.afterWithdraw(noteWithdraw);
		
		return prevwithdrawAmount;
	}
	
	/**
	 * Withdraw Amount valid check
	 * 
	 * @param withdrawAmount
	 * @param totalAmount
	 */
	private void validation(Integer withdrawAmount, Integer totalAmount) {
		if(withdrawAmount < 0) { 
			throw new RuntimeException("Negative value not allow :(");
		}
		
		if(withdrawAmount > totalAmount) {
			throw new RuntimeException("Insufficient balance :(\nYour Balance : " + totalAmount);
		}
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
