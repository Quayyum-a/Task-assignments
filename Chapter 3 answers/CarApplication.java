public class CarApplication {
    public static void main(String[] args) {
        Car myCar1 = new Car("Toyota (Avalon)", "2019", 300000);
        Car myCar2 = new Car("Mercedes-Benz (G-Wagon)", "2023", 750200);

        System.out.printf("Initial price of %s (%s): %.2f%n", myCar1.getModel(), myCar1.getYear(), myCar1.getPrice());
        System.out.printf("Initial price of %s (%s): %.2f%n", myCar2.getModel(), myCar2.getYear(), myCar2.getPrice());

        myCar1.setPrice(myCar1.getPrice() * 0.95);
        myCar2.setPrice(myCar2.getPrice() * 0.93);

        System.out.printf("Price after 5%% discount on %s (%s): %.2f%n", myCar1.getModel(), myCar1.getYear(), myCar1.getPrice());
        System.out.printf("Price after 7%% discount on %s (%s): %.2f%n", myCar2.getModel(), myCar2.getYear(), myCar2.getPrice());
    }
}