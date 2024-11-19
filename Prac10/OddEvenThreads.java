import java.util.Scanner;

class OddThread extends Thread {
    private final int n;
    private final Object lock;

    OddThread(int n, Object lock) {
        this.n = n;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i += 2) {
            synchronized (lock) {
                System.out.println("OddThread: " + i);
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

class EvenThread extends Thread {
    private final int n;
    private final Object lock;

    EvenThread(int n, Object lock) {
        this.n = n;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 2; i <= n; i += 2) {
            synchronized (lock) {
                System.out.println("EvenThread: " + i);
                lock.notify();
                try {
                    if (i + 1 < n) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        scanner.close();

        Object lock = new Object();
        Thread oddThread = new OddThread(n, lock);
        Thread evenThread = new EvenThread(n, lock);

        oddThread.start();
        evenThread.start();
    }
}