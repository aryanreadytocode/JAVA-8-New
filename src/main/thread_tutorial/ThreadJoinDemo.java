package main.thread_tutorial;

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Sita Thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread2 mt2 = new MyThread2();
        mt2.start();
        // main thread will wait for the MyThread2 until it finishes.
        mt2.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("Ram");
        }
    }
}

class MyThread3 extends Thread {
    static Thread mt;

    @Override
    public void run() {
        try {
            mt.join();
        } catch (InterruptedException e) {
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Child thread " + i);
        }
    }
}

class ThreadJoinDemo1 {

    public static void main(String[] args) throws InterruptedException {
        MyThread3.mt = Thread.currentThread();
        MyThread3 mt3 = new MyThread3();
        mt3.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Ram");
            Thread.sleep(2000);
        }
    }
}


