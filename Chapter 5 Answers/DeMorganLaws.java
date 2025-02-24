public class DeMorganLaws {
    public static void main(String[] args) {
        int x = 8, y = 6, a = 3, b = 7, g = 4, i = 3, j = 5;

			//(a)
        System.out.println(!(x < 5) && !(y >= 7));
        System.out.println(!((x < 5) || (y >= 7)));

			//(b)
        System.out.println(!(a == b) || !(g != 5));
        System.out.println(!((a == b) && (g != 5)));

			//(c)
        System.out.println(!((x <= 8) && (y > 4)));
        System.out.println(!(x <= 8) || !(y > 4));

			//(d)
        System.out.println(!((i > 4) || (j <= 6)));
        System.out.println(!(i > 4) && !(j <= 6));
    }
}
