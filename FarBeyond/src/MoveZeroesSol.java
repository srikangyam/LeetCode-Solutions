
public class MoveZeroesSol {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 0, 3, 12,0,3,0 };
		moveZeroes(arr);
		System.out.println("Moved Array is: [");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.print("]");

	}

	public static void moveZeroes(int[] nums) {
    	
    	int firstZeroIndex = -1;
    	
    	if (nums.length != 0){
    		for (int i = 1; i < nums.length; i++){
    			if (firstZeroIndex == -1){
    				if (nums[i-1] == 0)
    					firstZeroIndex = i - 1;
    			}
    			if (nums[i] != 0){
    				if (firstZeroIndex != -1){
    				   swapZero(firstZeroIndex, i, nums);
    				   if ((firstZeroIndex < (nums.length - 1)) && (nums[firstZeroIndex + 1] == 0)){
  						 firstZeroIndex++;
  					   } else {
  						 firstZeroIndex = i;
  					   }
    				}   				
    			}
    			else {
    				if (firstZeroIndex == -1) firstZeroIndex = i;
    			}
    		}
    	}
    }

	public static void swapZero(int firstZeroIndex, int j, int[] nums) {
		nums[firstZeroIndex] = nums[j];
		nums[j] = 0;
	}

}
