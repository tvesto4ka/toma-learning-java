package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private final String name;
    private static final AtomicInteger flag = new AtomicInteger(0);

    public MyThread(String setName) {
        super();
        this.name = setName;
    }

    @Override
    public void run() {
        print();
    }

    private void print() {
        while (true) {
            if (flag.compareAndSet(0, 1)) {
                System.out.println("Hello! I'm thread number " + name);
                for (int i = 0; i < 10; i++) {
                    System.out.print(i);
                }
                System.out.println();
                flag.compareAndSet(1, 0);
                return;
            }
        }
    }
}
