package atm.com.example;

public class TestClass {

	public static void main(String[] args) {
		
		for(Notes note : Notes.values()) {
			System.out.println(note.getNote());
		}
		
	}
	
}
