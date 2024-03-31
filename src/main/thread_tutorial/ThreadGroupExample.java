package main.thread_tutorial;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreadGroupExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());

        ThreadGroup tg = new ThreadGroup("First Group");
        System.out.println(tg.getParent().getName());
        ThreadGroup tg1 = new ThreadGroup(tg, "Second Group");
        System.out.println(tg1.getParent().getName());
        System.out.println(tg1.getName());

        Thread t1 = new Thread(tg, "Thread1");
        t1.start();
        Thread t2 = new Thread(tg1, "Thread2");
        tg1.setMaxPriority(3);
        Thread t3 = new Thread(tg1, "Thread3");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
        tg1.list();
        System.out.println(tg.activeCount());
        Thread[] arr = new Thread[1];
        tg.enumerate(arr);
        Arrays.stream(arr).forEach(System.out::println);


    }
}

// write a program to display all active thread names belong to system group and it's child groups

class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread[] th = new Thread[7];
        system.enumerate(th);
        for(Thread t : th) {
            System.out.println(t.getName() +"....."+t.isDaemon());
        }
    }
}


