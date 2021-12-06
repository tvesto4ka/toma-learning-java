package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private final String name;
    private static final AtomicInteger flag = new AtomicInteger();
    private static final Boolean volatileFlag = false;

    public MyThread(String setName) {
        super();
        this.name = setName;
    }

    @Override
    public void run() {
        print();
        print1();
    }

    private void print1() {
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

    private void print() {
        synchronized (volatileFlag) {
            System.out.println("Hello! I'm thread number " + name);
            for (int i = 0; i < 10; i++) {
                System.out.print(i);
            }
            System.out.println();
            volatileFlag.notifyAll();
        }
    }
}
