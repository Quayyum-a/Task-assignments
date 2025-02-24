package geometry;

public class AreaofCircle {
    public static void main(String[] args) {
        double radius = 6.5;
        double pi = 3.14159;

        double perimeter = 2 * radius * pi;
        double area = radius * radius * pi;

        System.out.println("The Perimeter of a circle is " + perimeter);
        System.out.println("The area of a circle is " + area);
    }
}
