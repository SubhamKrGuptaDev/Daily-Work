package today_12_12_24.print.com;

/**
 * Print transactions service
 */
public interface AtmOutputService {
	
	void printBalance(Integer totalAmount);
	
	void afterWithdraw(Integer[] noteWithdraw);
	
}
