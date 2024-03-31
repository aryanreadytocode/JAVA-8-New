package main.thread_tutorial;

public class DaemonThreadExample {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isDaemon());
//        Thread.currentThread().setDaemon(true); // runtime error called IllegalThreadStateException
        MyThread9 mt9 = new MyThread9();
        System.out.println(mt9.isDaemon());
        mt9.setDaemon(true);
        System.out.println(mt9.isDaemon());
    }
}

class MyThread9 extends Thread {
    @Override
    public void run() {
        super.run();
    }
}

// Whenever last non-daemon thread terminates automatically all daemon threads will be terminates
// irrespective of their position.

class MyThread10 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            System.out.println("Child thread");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException ie) {}
        }
    }
}

class DaemonPriority {
    public static void main(String[] args) {
        MyThread10 mt10 = new MyThread10();
        mt10.setDaemon(true);
        mt10.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end of main thread");
    }
}
