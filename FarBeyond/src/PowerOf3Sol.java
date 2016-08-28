
public class PowerOf3Sol {

	public static void main(String[] args) {
		System.out.println("isPowerof3(125): "+ isPowerof3(125));
		System.out.println("isPowerof3(125): "+ isPowerof3(75));
		
		
	 

	}

	private static boolean isPowerof3(int n) {
		//Base cases
		if (n == 0) return false;
		
		//Starting from i = 2 to n, search for the power 3
		int start = 0, end = n;
		while (start <= end){
			int mid = (start + end) / 2;
			
			if (Math.pow(3,mid) == n){
				return true;
			}
			else if (Math.pow(3,mid) < n){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

}
