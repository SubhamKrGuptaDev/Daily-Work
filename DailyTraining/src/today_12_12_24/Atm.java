package today_12_12_24;


import java.util.*;

import today_12_12_24.deposit.com.AtmDepositService;
import today_12_12_24.deposit.com.AtmDepositServiceImpl;
import today_12_12_24.enums.com.Notes;
import today_12_12_24.print.com.AtmOutputService;
import today_12_12_24.print.com.AtmOutputServiceImpl;
import today_12_12_24.withdraw.com.WithdrawService;
import today_12_12_24.withdraw.com.WithdrawServiceImpl;


/**
 * ATM Machine Operation Class 
 * ATM operations deposit/withdraw/check balance
 */
public class Atm {
	
	// Denomination for track Notes count with noteType
	private Map<Integer, Integer> denomination;
	private Integer totalAmount;
	private AtmDepositService atmDeposit;
	private AtmOutputService print;
	private WithdrawService withdraw;
	
	private AtmOperationFactory<Class<?>> atmOperationFactory;

	/**
	 * create object with all the notes default value 0
	 * initialize other objects
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Atm() {
		// First Map initialize
		denomination = new HashMap<>();
		for(Notes note : Notes.values()) {
			denomination.put(note.getNote(), 0);
		}
		
		// factory class initialize
		atmOperationFactory = AtmOperationFactoryImpl.getInstance(denomination);
		totalAmount = 0;
		
		// Operation class object injection
		print = (AtmOutputServiceImpl) atmOperationFactory.getFactoryObject(AtmOutputServiceImpl.class);
		atmDeposit = (AtmDepositServiceImpl) atmOperationFactory.getFactoryObject(AtmDepositServiceImpl.class);
		withdraw = (WithdrawServiceImpl) atmOperationFactory.getFactoryObject(WithdrawServiceImpl.class);
		
	}
	
	/**
	 * Deposit Cash into ATM
	 * 
	 * @param totalNotes
	 */
	public void depositCash(Integer... totalNotes) {
		totalAmount += atmDeposit.depositCash(totalNotes, totalAmount);
	}
	
	/**
	 * Withdraw Functionality
	 * 
	 * @param withdrawAmount
	 */
	public void withdrawAmount(Integer withdrawAmount) {
		totalAmount -= withdraw.withdrawAmount(withdrawAmount, totalAmount);
	}
	
	/**
	 * Print Balance
	 */
	public void printBalance() {
		print.printBalance(totalAmount);
	}
 
}
