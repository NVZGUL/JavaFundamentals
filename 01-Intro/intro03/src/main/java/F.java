import java.util.HashMap;

import static java.lang.Math.tan;

public class F {
    private double a, b, step;
    private F(double a, double b, double step) {
        this.a = a;
        this.b = b;
        this.step = step;
    }
    private HashMap<Double, Double> calculate() {
        HashMap<Double, Double> res = new HashMap<>();
        while (a <= b) {
            res.put(a, tan(2*a) - 3);
            a += step;
        }
        return res;
    }

    public static void main(String... args) {
        F f = new F(0.1,1, 0.1);
        System.out.println(f.calculate());
    }
}
