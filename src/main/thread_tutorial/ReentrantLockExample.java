package main.thread_tutorial;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock();
        l.lock();
        System.out.println(l.isLocked());
        System.out.println(l.isHeldByCurrentThread());
        System.out.println(l.getQueueLength());
        System.out.println(l.getHoldCount());
        System.out.println(l.isLocked());
        l.unlock();
        System.out.println(l.isLocked());
        System.out.println(l.isFair());
    }
}

class Display2 {
    ReentrantLock lock = new ReentrantLock();
    public void wish(String name) {
        lock.lock();
        for (int i = 0; i< 10; i++) {
            System.out.println("Good Morning");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException ie) {}
            System.out.println(name);
        }
        lock.unlock();
    }
}

class MyThread12 extends Thread {
    Display2 d;
    String name;
    MyThread12(Display2 d, String name) {
        this.name = name;
        this.d = d;
    }
    @Override
    public void run() {
        d.wish(name);
    }
}

class ReentrantLockDemo {
    public static void main(String[] args) {
        Display2 d = new Display2();
        MyThread12 t1 = new MyThread12(d, "Raj");
        MyThread12 t2 = new MyThread12(d, "Aryan");
        t1.start();
        t2.start();
    }
}

// try lock example

class MyThread13 extends Thread {
    static ReentrantLock l = new ReentrantLock();
    MyThread13(String name) {
        super(name);
    }

    @Override
    public void run() {
        if (l.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " got locked and performing safe opn");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
            }
        }else
            System.out.println(Thread.currentThread().getName() + " unable to get lock and hence performing alternative opn");

    }
}

class ReentrantLockDemo2 {
    public static void main(String[] args) {
        MyThread13 t1 = new MyThread13("First Thread");
        MyThread13 t2 = new MyThread13("Second Thread");
        t1.start();
        t2.start();
    }
}

/// static reentrant lock
class MyThread14 extends Thread {
    static ReentrantLock lock = new ReentrantLock();
    MyThread14(String name) {
        super(name);
    }

    @Override
    public void run() {
        do {
            try {
                if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " got lock");
                    Thread.sleep(30000);
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+" release lock");
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName()+" unable to get lock and will try again");
                }
            }catch (InterruptedException ie) {

            }
        }while (true);
    }
}

class ReentrantLockDemo1 {
    public static void main(String[] args) {
        MyThread14 t1 = new MyThread14("First Thread");
        MyThread14 t2 = new MyThread14("Second Thread");
        t1.start();
        t2.start();
    }
}