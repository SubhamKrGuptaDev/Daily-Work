package today_12_12_24.print.com;

import today_12_12_24.enums.com.Constraints;
import today_12_12_24.enums.com.Notes;

/**
 * Print Input and Output transactions
 */
public class AtmOutputServiceImpl implements AtmOutputService {
	
	private static AtmOutputServiceImpl instance = null;
	
	// Private Constructor
	private AtmOutputServiceImpl() {}
	
	/**
	 * Get Instance as a Singleton Object
	 * 
	 * @return
	 */
	public static AtmOutputServiceImpl getInstance() {
		if(instance == null) {
			synchronized (AtmOutputServiceImpl.class) {
				if(instance == null) {
					instance = new AtmOutputServiceImpl();
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
	 * Check balance in my ATM
	 */
	@Override
	public void printBalance(Integer totalAmount) {
		System.out.println("\n\nYour balance : " + totalAmount + "\n\n");
	}

	/**
	 * Print output after complete the withdraw transaction
	 */
	@Override
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
