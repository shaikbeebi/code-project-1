class MyThread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 1: " + i);
            try {
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 2: " + i);
            try {
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.start(); // Start thread 1
        t2.start(); // Start thread 2
    }
}

