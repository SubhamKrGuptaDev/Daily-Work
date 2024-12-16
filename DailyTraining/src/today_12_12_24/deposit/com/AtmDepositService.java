package today_12_12_24.deposit.com;

import today_12_12_24.AtmOperationFactory;

/**
 * Deposit Service
 */
public interface AtmDepositService {

	Integer depositCash(Integer[] totalNotes, Integer totalAmount);
	
}
