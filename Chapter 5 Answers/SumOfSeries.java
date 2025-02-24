public class SumOfSeries {
    public static void main(String[] args) {
        System.out.printf("%-10s%-20s%n", "number", "Sum");

        for (long number = 1; number <= 100; number++) {
            
            long sum = number * (number + 1) / 2;

            
            System.out.printf("%-10d%-20d%n", number, sum);
        }
    }
}
