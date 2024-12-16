package today_12_12_24.print.com;

import today_12_12_24.AtmOperationFactory;

/**
 * Print transactions service
 */
public interface AtmOutputService {
	
	void printBalance(Integer totalAmount);
	
	void afterWithdraw(Integer[] noteWithdraw);
	
}
