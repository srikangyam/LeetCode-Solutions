import java.util.ArrayList;
import java.util.Arrays;

public class IntersectArraySol2 {

	public static void main(String[] args) {
		int[] a1 = {1,2,2,1};
		int[] a2 = {1,1};

		int[] a3 = intersection(a1, a2);
		if (a3.length != 0) {
			for (int i = 0; i < a3.length; i++) {
				System.out.print(a3[i] + " ");

			}
		} else {
			System.out.println("[]");
		}

	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		
		int[] highLen = nums1.length >= nums2.length ? nums1 : nums2;
		int[] lowLen = nums1.length < nums2.length ? nums1 : nums2;

		ArrayList<Integer> intersect = new ArrayList<Integer>();


		if ((nums1.length == 0) || (nums2.length == 0))
			return (new int[0]);

		for (int i = 0; i < lowLen.length; i++) {
			int start = 0;
			int end = highLen.length - 1;
			int index = -1;
			if ((index = findTarget(highLen, lowLen[i], start, end)) != -1) {
				intersect.add(Integer.valueOf(lowLen[i]));
				highLen[index] = -1;
				Arrays.sort(highLen);
			}
		}

		if (intersect.isEmpty()) {
			return new int[0];
		}

		int[] array = new int[intersect.size()];
		for (int i = 0; i < intersect.size(); i++)
			array[i] = intersect.get(i);

		return array;

	}

	public static int findTarget(int[] nums1, int target, int start, int end) {

		int mid = (start + end) / 2;

		if (target == nums1[mid]) {
			return mid;
		} else if (start < end) {
			int index = -1;
			if (target < nums1[mid]) {
				if ((index = findTarget(nums1, target, start, mid - 1)) != -1) {
					return index;
				}
			} else if (target > nums1[mid]) {
				if ((index = findTarget(nums1, target, mid + 1, end)) != -1) {
					return index;
				}
			}

		}

		return -1;
	}
}
