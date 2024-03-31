package main.thread_tutorial;

public class ThreadYieldDemo {
    public static void main(String[] args) {
        Thread mt1 = new MyThread1();
        mt1.start();
        for (int i = 0; i< 10; i++) {
            System.out.println("Main thread");
        }
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i< 10; i++) {
            System.out.println("Child thread");
            Thread.yield();
        }
    }
}
