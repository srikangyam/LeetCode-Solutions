
public class ReverseStringChk {

	public static void main(String[] args) {
	    //System.out.println("Reverse of HELLO is: " + reverseString("HELLO"));
	    System.out.println("Reverse of a. is: " + reverseString("a."));

	}
	
    public static String reverseString(String s) {
    	if (s.length() == 0) return s;
    	int head = 0;
    	int tail = s.length() - 1;
    	char[] charArray = s.toCharArray();
    	
    	while ((head != tail) && (head < tail)){
    		charArray[head] = s.charAt(tail);
       	    charArray[tail] = s.charAt(head);
    		head++;
    		tail--;
    	}
    	return String.valueOf(charArray);
        
    }

}
