
public class AddDigitsChk {

	public static void main(String[] args) {
		System.out.println("AddDigits(38): " + addDigits(38));
		System.out.println("AddDigits(123): " + addDigits(123));
		System.out.println("AddDigits(79): " + addDigits(79));
		System.out.println("AddDigits(1325132435356): " + addDigitsV(1325132435356L));
		System.out.println("AddDigits(-3456): " + addDigitsV(-3456));
		System.out.println("AddDigits(10): " + addDigitsV(10));
		
		

	}
	
	public static int addDigitsV(long num) {
		if (num / 10 == 0) {
			return (int) num;
		}
		if (num < 0) {
			num = Math.abs(num);
		}
		long quo = 0;
		long rem = 0;
		while (num > 0) {
			rem += num % 10;
			num = num / 10;
		}
		return (int) rem;
	}
	
    public static int addDigits(int num) {
    	int rem = 0;
    	int quo = 0;
    	while (num > 9){
    		rem += num % 10;
    		quo = num / 10;
    		while (quo != 0){
    			rem += quo % 10;
    			quo = quo / 10;
    		}
    		num = rem;
    		rem = 0;
    	} 
    	
    	return num;
        
    }

}
