package java8;

import java.time.LocalDate;

public class just {
	
	LocalDate date = LocalDate.now();
	
	public int countForOrderNumber = 1;
	
	public String orderNumber(){
        return String.format(date + "%03d", countForOrderNumber);
    }
	
	public static void main(String[] args) {
		just just = new just();
		String abcString = just.orderNumber();
		System.out.println(abcString);
	}

}
