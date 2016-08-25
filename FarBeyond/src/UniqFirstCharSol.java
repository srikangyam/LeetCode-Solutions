public class UniqFirstCharSol {

	public static void main(String[] args) {
		System.out.println("Uniq First char index in 'leetcode': " + firstUniqChar("leetcode"));
		System.out.println("Uniq First char index in 'loveleetcode': " + firstUniqChar("loveleetcode"));
		System.out.println("Uniq First char index in 'lleettccoodde': " + firstUniqChar("lleettccoodde"));
		

	}
	
    public static int firstUniqChar(String s) {
    	int index = -1;
    	char prev = '\0';
    
    	String sortedStr = new String(s);
    	
    	while (sortedStr.length() != 0){
    		prev = sortedStr.charAt(0);
    		int occurrences = sortedStr.length() - sortedStr.replace(""+prev, "").length();
    		if (occurrences == 1){
    			//Break on the first occurrence of the char
    			index = 0;
    			break;
    		} else {
    			sortedStr = sortedStr.replace(""+prev, "");
    		}
    	}
    	
    	if (index != -1){
    		index = s.indexOf(prev);
    	}
    	
    	return index;
        
    }

}
