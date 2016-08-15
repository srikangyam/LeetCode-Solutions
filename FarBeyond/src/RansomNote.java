
public class RansomNote {
public static boolean canConstruct(String ransomNote, String magazine) {
	// Form a character read list
	// Search for the occurrences of a character in ransomNote
	// Search for the occurrences of the same character in magazine
	// If match, move to next character. Else return false
	// If does not match, break and return false
	if ((ransomNote == "") || (ransomNote == null) || (magazine == "") || 
			(magazine == null)) return false;
	while (ransomNote.length() != 0){
		char ch = ransomNote.charAt(0);
		
		int ransomeNoteCharOccurrences = 
				ransomNote.length() - ransomNote.replace(""+ ch, "").length();
		
		int magazineCharOccurrences =
				magazine.length() - magazine.replace(""+ ch, "").length();
		
		if (ransomeNoteCharOccurrences > magazineCharOccurrences) return false;
		
		ransomNote = ransomNote.replace(""+ch, "");
	}
	return true;
        
    }

public static void main(String args[]){
	System.out.println("Can you construct?: "+ canConstruct("aabba", "baaab"));
}

}
