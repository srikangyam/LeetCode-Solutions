
public class AnagramSol {

	public static void main(String[] args) {
		System.out.println("Is 'anagram' an anagram of 'nagaram': " + isAnagram("anagram", "nagaram"));
		System.out.println("Is 'anagram' an anagram of 'nagaramt': " + isAnagram("anagram", "nagaramt"));
		System.out.println("Is 'car' an anagram of 'rat': " + isAnagram("car", "rat"));
		

	}

	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length())
			return false;

		while (s.length() != 0) {
			char ch = s.charAt(0);

			int sCharOccurrences = s.length() - s.replace("" + ch, "").length();

			int tCharOccurrences = t.length() - t.replace("" + ch, "").length();

			if (sCharOccurrences != tCharOccurrences)
				return false;

			s = s.replace("" + ch, "");
			t = t.replace("" + ch, "");
		}

		return true;

	}

}
