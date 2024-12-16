package today_12_12_24.withdraw.com;

import java.util.Map;

import today_12_12_24.AtmOperationFactory;
import today_12_12_24.print.com.AtmOutputServiceImpl;

/**
 * Withdraw Service
 */
public interface WithdrawService {
	
	Integer withdrawAmount(Integer withdrawAmount, Integer totalAmount);
	
}
