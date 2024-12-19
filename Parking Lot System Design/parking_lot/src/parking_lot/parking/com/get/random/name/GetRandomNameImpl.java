package parking_lot.parking.com.get.random.name;

import java.util.Random;


/**
 * Get Random Name
 */
public class GetRandomNameImpl {

    public static void main(String[] args) {

        Names[] values = Names.values();
        int len = values.length;

        Random random = new Random();
        int index = random.nextInt(len);

        System.out.println("Name : " + toCapitalize(values[index].toString()));
    }

    /**
     * value change to capitalize and return new string
     * capitalize example -> EXAMPLE -> Example
     *
     * @param str
     * @return
     */
    private static String toCapitalize(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            if(i == 0) {
                char ch = str.charAt(i);
                if(ch >= 'a' && ch <= 'z') {
                    ch = (char)(ch - 32);
                }
                sb.append(ch);
            } else {
                char oldChar = str.charAt(i);
                if(oldChar >= 'A' && oldChar <= 'Z') {
                    sb.append((char) (oldChar + 32));
                } else {
                    sb.append(oldChar);
                }
            }
        }

        return sb.toString();
    }

}
