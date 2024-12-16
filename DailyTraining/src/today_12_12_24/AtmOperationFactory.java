package today_12_12_24;

/**
 * Factory interface
 */
public interface AtmOperationFactory<T> {
	
	Object getFactoryObject(T object);
	
}
