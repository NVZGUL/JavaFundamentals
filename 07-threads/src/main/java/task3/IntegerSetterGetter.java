package task3;

import java.util.Random;

public class IntegerSetterGetter extends Thread{
    private SharedResource resource;
    private boolean run;

    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    @Override
    public void run() {
        int action;
        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegerFromResource();
                } else {
                    setIntegerIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegerFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Поток" + getName() + " хочет извлечь число.");
            number = resource.getElement();
            while (number == null) {
                System.out.println("Поток" + getName() + " ждет пока очередь заполниться.");
                resource.wait(1000); // add timeout for stopping waiting
                System.out.println("Поток" + getName() + " возобновил работу");
                number = resource.getElement();
                if (number == null) {
                    setIntegerIntoResource();
                }
            }
            System.out.println("Поток" + getName() + " извлек число " + number);
        }
    }

    private void setIntegerIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток" + getName() + " записал число " + number);
            resource.notifyAll(); // replaced notify to notify all for better choise of threads
        }
    }
}
