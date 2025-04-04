public class DuplicateElimination {
	public int[] eliminate(int[] nums) {
		for (int count = 0; count < nums.length; count++) {
			for (int counter = count + 1; counter < nums.length; counter++) {
				if (nums[count] == nums[counter]) {
					nums[counter] = -1;
				}
			}
		}
		return nums;
	}
}
