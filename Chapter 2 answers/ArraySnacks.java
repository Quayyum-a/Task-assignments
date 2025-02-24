public class ArraySnacks{
	public int largest(int[] nums){
		int max = nums[0];
		for(int count = 1; count < nums.length; count++){
			if(nums[count] > max){
				max = nums[count];
			}
		}return max;
	}
	public int[] reverse(int[] nums){
		int no =0;
		int[] rev = new int[nums.length];
		for(int count = nums.length - 1; count >= 0; count--){
			rev[no] = nums[count];
			no++;
		}return rev;
	}
	public boolean element(int[] nums){
		int ell = 23;
		for(int count = 0; count < nums.length; count++){
			if(nums[count]== ell){
				return true;
			}
		}return false;
	}
	public int[] even(int[] nums){
		int index = 0;
		int[] evenArr = new int[(nums.length + 1) / 2];
		for(int count = 0; count < nums.length; count++){
			if(count % 2 == 0){
				evenArr[index] = nums[count];
				index++;
			}
		}return evenArr;
	}
	public int[] odd(int[] nums){
		int index = 0;
		int[] oddArr = new int[(nums.length + 1) / 2];
		for(int count = 0; count < nums.length; count++){
			if(count % 2 == 1){
				oddArr[index] = nums[count];
				index++;
			}
		}return oddArr;
	}
	public int total(int[] nums){
		int total = 0;
		for(int count = 0; count < nums.length;count++){
			total += nums[count];
		}return total;
	}
	public boolean palindrome(String name){
		for(int count = 0; count < name.length() / 2; count++){
			if(name.charAt(count) != name.charAt(name.length() - 1 - count)){
				return false;
				}
		}return true;
	}
	public int sumForLoop(int[] nums){
		int sum = 0;
		for(int count =0; count < nums.length; count++){
			sum += nums[count];
		}return sum;
	}
	public int sumWhileLoop(int[] nums){
		int count = 0;
		int sum = 0;
		while(count < nums.length){
			sum += nums[count];
			count++;
		}return sum;
	}
	public int sumDoWhileLoop(int[] nums){
		int count = 0;
		int sum = 0;
		do{
			sum += nums[count];
			count++;
		}
		while(count < nums.length);
		return sum;
	}
	public Object[] concatenates(String[] nums1, int[] nums2){
		int index = 0;
		Object[] arr = new Object[nums1.length + nums2.length];
		
		for(int count = 0; count < nums1.length; count++){
			arr[index] = nums1[count];
			index++;
		}
			for(int counter = 0; counter < nums2.length; counter++){
				arr[index] = nums2[counter];
				index++;
			}
		return arr;
	}
	public Object[] combine(String[] nums1, int[] nums2){
		int index = 0;
		Object[] arr = new Object[nums1.length + nums2.length];
		for(int count = 0; count < nums1.length; count++){
				arr[index++] = (nums1[count]);
				arr[index++] = (nums2[count]);
		}return arr;
	}
	public int[] list(int nums) {
		String numStr = Integer.toString(nums);
		int[] arr = new int[numStr.length()];
		for (int count = 0; count < numStr.length(); count++) {
			arr[count] = Character.getNumericValue(numStr.charAt(count));
		}return arr;
	}

}
