package today_12_12_24;

import java.util.Map;

import today_12_12_24.deposit.com.AtmDepositServiceImpl;
import today_12_12_24.print.com.AtmOutputServiceImpl;
import today_12_12_24.withdraw.com.WithdrawServiceImpl;

/**
 * Factory Implementation
 */
public class AtmOperationFactoryImpl<T> implements AtmOperationFactory<T> {

	private Map<Integer, Integer> denomination;
	private AtmOutputServiceImpl print;
	
	public AtmOperationFactoryImpl(Map<Integer, Integer> denomination) {
		this.denomination = denomination;
		this.print = AtmOutputServiceImpl.getInstance();
	}
	
	/**
	 * 
	 */
	@Override
	public Object getFactoryObject(T object) {
		
		if(object == AtmDepositServiceImpl.class) {
			return AtmDepositServiceImpl.getInstance(denomination);
		} else if(object == AtmOutputServiceImpl.class) {
			return AtmOutputServiceImpl.getInstance();
		} else if(object == WithdrawServiceImpl.class) {
			return WithdrawServiceImpl.getInstance(denomination, print);
		}
		
		return null;
	}

}
