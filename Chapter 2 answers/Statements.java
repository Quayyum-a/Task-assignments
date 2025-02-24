public class Statements{
	public int tenthValue(int[] nums){
		for(int count = 0; count < nums.length; count++){
			if(count == 9) return nums[count];
		}
		return 0;
	}

	public int[] negativeArray(int[] nums){
		for(int count = 0; count< nums.length; count++){
			nums[count]= -1;
		}
		return nums;
	}
	
	public int getMax(int[] nums){
		int max = nums[0];
		for(int count = 0; count < nums.length; count++){
			if(nums[count]> max){
				max = nums[count];
				
			}
		}return max;
	}
	public int compute(int[] nums){
		int product = 1;
		for(int count = 2; count < nums.length; count++){
			 product *= nums[count];
			if(count == 9){
				break;
			}
		}return product;
	}
	
}