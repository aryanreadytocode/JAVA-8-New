package main.thread_tutorial;
/*Order of execution of thread can be decided by thread scheduler
* present inside JVM
* There is no exact algorithm followed by the scheduler
* so there is no guarantee of order of execution*/
public class MyThread extends Thread {

    /* run method can be overloaded but start() method will call
    * which has no arg run method.*/
    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            System.out.println("Child Thread "+i);
        }
    }

//    public void run(String name) {
//        System.out.println(name);
//    }
//
//    @Override
//    public synchronized void start() {
//        run();
//    }
}

class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new MyThread();
        /*This method is responsible for register the thread with thread scheduler
         * and all others activities and then call run method internally.
         *
         * Instead of t.start() we can use t.run() method but if we use it won't
         * start a new thread and run method will execute like normal method*/
//        t.start();
//        for (int i = 0; i<10; i++) {
//            System.out.println("Main Thread :"+i);
//        }
        // get and set name to from thread
        System.out.println(Thread.currentThread().getName());
        t.start();
        System.out.println(t.getName());
        Thread.currentThread().setName("Raj's thread");
        System.out.println(Thread.currentThread().getName());

    }
}

    class ThreadPriorityDemo {
        public static void main(String[] args) {
            System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());
            // thread priority range from 1 to 10, if it has other than this, Runtime error will throw
//            Thread.currentThread().setPriority(0);
            // changing main thread priority from 5 to 7, so the child thread priority will also become 7
            Thread.currentThread().setPriority(7);
            Thread myThread = new MyThread();
            myThread.start();
            System.out.println(myThread.getName() +"  "+myThread.getPriority());
        }
    }

    class ThreadPriorityDemo2 {
        public static void main(String[] args) {
            MyThread mt = new MyThread();
            mt.setPriority(Thread.MAX_PRIORITY);
            mt.start();
            for (int i = 0; i < 10; i++) {
                System.out.println("Main thread "+i);
            }
        }
    }

