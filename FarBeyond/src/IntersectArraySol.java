import java.util.ArrayList;
import java.util.Arrays;

public class IntersectArraySol {

	public static void main(String[] args) {
		int[] a1 = {};
		int[] a2 = {};
		
		int[] a3 = intersection(a1, a2);
		if (a3.length != 0){
			for (int i = 0; i < a3.length; i++){
				System.out.print(a3[i] + " ");
				
			}
		} else {
			System.out.println("[]");
		}
		
		

	}
	
    public static int[] intersection(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
       	
    	ArrayList<Integer> intersect = new ArrayList<Integer>();
    	
    	int lastVisited = -1; 
    	
    	if ((nums1.length == 0) || (nums2.length == 0)) return (new int[0]);
    	
    	for (int i = 0; i < nums2.length; i++){
    		if (nums2[i] != lastVisited){
    			lastVisited = nums2[i];
    			int start = 0;
    			int end = nums1.length - 1;
    			if (findTarget(nums1, nums2[i], start, end)){
    				intersect.add(Integer.valueOf(nums2[i]));
    			}
    		}
    	}
    	
    	if (intersect.isEmpty()){
    		return new int[0];
    	}
    	
    	int[] array = new int[intersect.size()];
    	for(int i = 0; i < intersect.size(); i++) array[i] = intersect.get(i);
    	
    	return array;
        
    }

	public static boolean findTarget(int[] nums1, int target, int start, int end) {
		
		int mid = (start + end) / 2;
		
		if (target == nums1[mid]){
			return true;
		} else if (start < end){
			if(target < nums1[mid]){
				if (findTarget(nums1, target, start, mid - 1)){
					return true;
				}
			}else if(target > nums1[mid]){
				if (findTarget(nums1, target, mid+1, end)){
					return true;
				}
			}
			
		} 
		
		return false;
	}
}
