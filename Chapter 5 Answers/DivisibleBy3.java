public class DivisibleBy3 {
	public static void main(String[] args){
		int sum = 0;
		
		for (int count = 1; count <= 30; count++){
			if (count % 3 == 0){
			sum += count;
			}
		}
		System.out.println("The sum of the integers that can be divided by 3 from 1 - 30 is " + sum);
	}
}