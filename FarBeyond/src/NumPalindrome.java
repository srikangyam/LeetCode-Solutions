
public class NumPalindrome {

	public static void main(String[] args) {
		System.out.println("is(1221) a palindrome: " + is_numeric_palindrome(1221));
		System.out.println("is(125321) a palindrome: " + is_numeric_palindrome(125321));

	}
	
	public static boolean is_numeric_palindrome(long number) {
	    String str[] = Long.toString(number).split("");
	    for (int first = 0, last = str.length - 1; first < last; first++, last--) {
	    	if (!str[first].equalsIgnoreCase(str[last])) {
	    		return false;
	    	}
	    }
	    return true;
	    
	}

}
