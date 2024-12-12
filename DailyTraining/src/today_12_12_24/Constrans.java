package today_12_12_24;

public enum Constrans {

	WITHDRAW_PRINT(" Notes: ");
	
	private final String printValue;
	
	private Constrans(String printValue) {
		this.printValue = printValue;
	}
	
	public String getPrintValue() {
		return printValue;
	}
	
	
}
