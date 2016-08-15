
public class AddDigitsChk {

	public static void main(String[] args) {
		System.out.println("AddDigits(38): " + addDigits(38));
		System.out.println("AddDigits(123): " + addDigits(123));
		System.out.println("AddDigits(79): " + addDigits(79));
		
		

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
