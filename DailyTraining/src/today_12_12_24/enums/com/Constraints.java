package today_12_12_24.enums.com;

/**
 * Constants for message and \output
 */
public enum Constraints {

	WITHDRAW_PRINT(" Notes: "),
	ENTER_HOW_MANY_PRINT("Enter how many "),
	NOTE_YOU_HAVE_PRINT(" note you have : "),
	WELCOME_PRINT("Welcome to ATM");
	
	private final String printValue;
	
	private Constraints(String printValue) {
		this.printValue = printValue;
	}
	
	public String getPrintValue() {
		return printValue;
	}
	
}
