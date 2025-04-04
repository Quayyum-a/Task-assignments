public class ClockTest {
    public static void main(String[] args) {
        Clock myClock = new Clock(23, 30, 25);
        Clock yourClock = new Clock(26,60, 60);

        System.out.println(myClock.displayTime());  // Output: 10:30:25
        System.out.println(yourClock.displayTime());  // Output: 00:00:00
    }
}
