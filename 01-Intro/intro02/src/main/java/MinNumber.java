import static java.lang.Math.pow;

public class MinNumber {
    public static void main(String... args) throws ArrayIndexOutOfBoundsException, NumberFormatException{
        double e = Double.parseDouble(args[0]);
        double n;
        for (int i = 1; ; i++) {
            if (1 / pow(i+1, 2) < e) {
                n = i;
                break;
            }
        }
        System.out.println(n);
    }
}
