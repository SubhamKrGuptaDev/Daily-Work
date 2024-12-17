package today_12_12_24;

import java.util.Map;

import today_12_12_24.deposit.com.AtmDepositServiceImpl;
import today_12_12_24.print.com.AtmOutputServiceImpl;
import today_12_12_24.withdraw.com.WithdrawServiceImpl;

/**
 * Factory Implementation
 */
public class AtmOperationFactoryImpl<T> implements AtmOperationFactory<T> {

	private static AtmOperationFactoryImpl instance = null;
	
	private Map<Integer, Integer> denomination;
	private AtmOutputServiceImpl print;
	
	private AtmOperationFactoryImpl(Map<Integer, Integer> denomination) {
		this.denomination = denomination;
		this.print = AtmOutputServiceImpl.getInstance();
	}
	
	/**
	 * Singleton Object
	 * 
	 * @param denomination
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static AtmOperationFactoryImpl getInstance(Map<Integer, Integer> denomination) {
		
		if(instance == null) {
			synchronized (AtmOperationFactoryImpl.class) {
				if(instance == null) {
					instance = new AtmOperationFactoryImpl(denomination);
				}
			}
		}
		
		return instance;
	}
	
	/**
	 * Factory method to get object
	 * 
	 * @param object
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
