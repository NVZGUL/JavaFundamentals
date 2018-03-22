package task6;

public class AtomicSubmarine {
    public void startSwimming() {
        Engine e = new Engine();
        e.runEngine();
        System.out.println("Submarine swam");
    }
    class Engine {
        void runEngine() {
            System.out.println("Engine started");
        }
    }

    public static void main(String... args) {
        AtomicSubmarine a = new AtomicSubmarine();
        a.startSwimming();
    }
}
