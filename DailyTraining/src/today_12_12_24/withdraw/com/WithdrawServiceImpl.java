package today_12_12_24.withdraw.com;

import java.util.Map;

import today_12_12_24.enums.com.Constraints;
import today_12_12_24.enums.com.Notes;
import today_12_12_24.print.com.AtmOutputServiceImpl;

/**
 * ATM Withdraw Service Implementation
 */
public class WithdrawServiceImpl implements WithdrawService {

	private static WithdrawServiceImpl instance = null;
	private final Map<Integer, Integer> denomination;
	private final AtmOutputServiceImpl print;
	
	// Private Constructor 
	private WithdrawServiceImpl(Map<Integer, Integer> denomination, AtmOutputServiceImpl print) {
		this.denomination = denomination;
		this.print = print;
	}
	
	/**
	 * Get Instance as a Singleton Object
	 * 
	 * @param denomination
	 * @param print
	 * @return
	 */
	public static WithdrawServiceImpl getInstance(Map<Integer, Integer> denomination, AtmOutputServiceImpl print) {
		if(instance == null) {
			synchronized (WithdrawServiceImpl.class) {
				if(instance == null) {
					instance = new WithdrawServiceImpl(denomination, print);
				}
			}
		}
		return instance;
	}
	
	/**
	 * Clone object restrict
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Restrict Copy Object");		
	}
	
	/**
	 * Withdraw amount if amount is valid
	 * 
	 * @param withdrawAmount
	 */
	@Override
	public Integer withdrawAmount(Integer withdrawAmount, Integer totalAmount) {
		Notes[] listNotes = Notes.values();
		
		if(isValidAmount(withdrawAmount, listNotes[listNotes.length - 1].getNote())) {
			return withdrawOperation(withdrawAmount, totalAmount);
		} else {
			throw new RuntimeException("Sorry amount value is not correct!");
		}

	}
	
	/**
	 * Withdraw operation logic
	 * Number of note need = withdrawAmount / Note value
	 * RemeningAmount = withdrawAmount % NoteValue 
	 * Store number of notes on notwWithdraw DESC order
	 * 
	 * @param withdrawAmount
	 */
	private Integer withdrawOperation(Integer withdrawAmount, Integer totalAmount) {
		validation(withdrawAmount, totalAmount);
		
		Integer prevwithdrawAmount = withdrawAmount;
		
		Integer notesLen = Notes.values().length;
		Integer[] noteWithdraw = new Integer[notesLen];
		
		Integer index = 0;
		for(Notes note : Notes.values()) {
			if(denomination.get(note.getNote()) > 0 && withdrawAmount >= note.getNote()) {
				Integer reminder = withdrawAmount / note.getNote();
				Integer minValue = Math.min(reminder, denomination.get(note.getNote()));
				withdrawAmount -= minValue * note.getNote(); 
				denomination.put(note.getNote(), denomination.get(note.getNote()) - 1);
				noteWithdraw[index] = minValue;
			}
			index++;
		}
		
		print.afterWithdraw(noteWithdraw);
		
		return prevwithdrawAmount;
	}
	
	/**
	 * Withdraw Amount valid check
	 * withdrawAmount < 0 or withdrawAmount > totalAmount operation throw exception
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
	 * reminder = amount % smallestNote | if reminder have it's not valid no or else valid
	 * 
	 * @param amount
	 * @return
	 */
	private Boolean isValidAmount(Integer amount, Integer smallestNote) {
		return amount % smallestNote == 0;
	}
	
}
