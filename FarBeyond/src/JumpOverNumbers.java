import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JumpOverNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listS = new LinkedList<Integer>(Arrays.asList(3,4,1,2,5,6,9,0,1,2,3,0));
        System.out.println("Jump Count: " + jump_over_numbers(listS));
	}
	
	public static int jump_over_numbers(List<Integer> list) {
        // Write your code here
		int jumpCount = 0;
		for (int index = 0; index < list.size();) {
			int position = index + 1;
			int valueAtPosition = list.get(index);
			int jump_value = position + valueAtPosition;
			if (jump_value > list.size()) {
				jumpCount++;
				break;
			} else if (valueAtPosition == 0) {
				jumpCount = -1;
				break;
			} else {
				jumpCount++;
			}
			index = jump_value - 1;
		}
		return jumpCount;
    }

}
