package threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadHandler {
    public static void main(String[] args) {
        int numberOfThreads = 10;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            threads.add(new MyThread(String.valueOf(i)));
        }
        for (int i = 0; i < numberOfThreads; i++) {
            threads.get(i).start();
        }
    }
}
