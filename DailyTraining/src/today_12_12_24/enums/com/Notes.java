package today_12_12_24.enums.com;


/**
 * Store notes type on DESC order
 * DESC order required for calculate remove notes and add notes
 */
public enum Notes {

	FIVE_HUNDRED(500),
	TWO_HUNDRED(200),
	ONE_HUNDRED(100);
	
	private final Integer noteValue;
	
	private Notes(Integer noteValue) {
		this.noteValue = noteValue;
	}
	
	public Integer getNote() {
		return this.noteValue;
	}
	
}
