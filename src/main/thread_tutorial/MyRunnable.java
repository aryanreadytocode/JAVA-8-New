package main.thread_tutorial;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i< 10; i++) {
            System.out.println("Child thread "+i);
        }
    }
}
class ThreadDemo1 {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
//        mr.run();
        Thread t = new Thread();
        t.start();
        for (int i = 0; i< 10; i++) {
            System.out.println("Main thread "+i);
        }
    }
}
