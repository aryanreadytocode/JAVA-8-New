package main.thread_tutorial;

public class InheritableThreadLocalExample {
    public static void main(String[] args) {
        ParentThread pt = new ParentThread();
        pt.start();
    }
}

class ParentThread extends Thread {
    public static InheritableThreadLocal<Object> tl = new InheritableThreadLocal<>() {
        public Object childValue(Object p) {
            return "c";
        }
    };

    @Override
    public void run() {
        tl.set("pp");
        System.out.println("Parent thread value ..."+tl.get());
        ChildThread ct = new ChildThread();
        ct.start();
    }
}

class ChildThread extends Thread {
    @Override
    public void run() {
        System.out.println("Child Thread value .."+ParentThread.tl.get());
    }
}
