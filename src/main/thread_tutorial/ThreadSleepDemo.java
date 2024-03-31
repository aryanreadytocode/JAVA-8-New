package main.thread_tutorial;

class MyThread4 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("I am lazy thread");
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("I got interrupted");
            }
        }
    }
}

public class ThreadSleepDemo {
    public static void main(String[] args) {
        MyThread4 mt4 = new MyThread4();
        mt4.start();
        mt4.interrupt();
        System.out.println("End of main thread");
    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("I am lazy thread");
        }
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("I got interrupted");
        }

    }
}
 class ThreadSleepDemo2 {
    public static void main(String[] args) {
        MyThread5 mt5 = new MyThread5();
        mt5.start();
        mt5.interrupt();
        System.out.println("End of main thread");
    }
}
