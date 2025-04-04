public class AddingToArray {
    public static int[] addOne(int[] numbers) {
        for (int count = numbers.length - 1; count >= 0; count--) {
            if (numbers[count] < 9) {
                numbers[count]++;
                return numbers;
            }
            numbers[count] = 0;
        }
        int[] newNumbers = new int[numbers.length + 1];
        newNumbers[0] = 1;
        return newNumbers;
    }
}
