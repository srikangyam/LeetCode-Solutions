import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MajorityElementSol {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 10, 12, 13, 5, 0, 0 };
		System.out.println("Majority Element is: " + majorityElement(arr));
		System.out.println("isDuplicate: " + containsDuplicate(arr));

	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		Arrays.sort(nums);

		int prevNum = nums[0];
		tm.put(nums[0], 1);

		for (int i = 1; i < nums.length; i++) {
			if (prevNum == nums[i]) {
				int count = tm.get(nums[i]);
				count++;
				tm.put(nums[i], count);
			} else {
				prevNum = nums[i];
				tm.put(nums[i], 1);
			}
		}

		int majElem = -1;
		int majCount = -1;
		for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
			if (majCount < entry.getValue()) {
				majElem = entry.getKey();
				majCount = entry.getValue();
			}
		}
		return majElem;
	}

	public static boolean containsDuplicate(int[] nums) {

		Arrays.sort(nums);

		if (nums.length == 0)
			return false;

		List<Integer> it = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++){
			it.add(Integer.valueOf(nums[i]));
		}
		
		Set<Integer> mySet = new HashSet<Integer>(it);
		
		if (mySet.size() == nums.length) return false;

		return true;

	}

}
