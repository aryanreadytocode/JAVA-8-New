package main.thread_tutorial;

public class ObjectWaitDemo {

    public static void main(String[] args) {
        GunFight gf = new GunFight();
        // Creating new thread and invoking
        // our fire() method on it
        Thread t  = new Thread(() -> gf.fire(60));
        t.start();

        // Creating a new thread and invoking
        // our reload method on it
        Thread t1 = new Thread(gf::reload);
        t1.start();

    }
}

class GunFight {
    private int bullets = 40;

    // This method fires the number of bullets that are
    // passed it. When the bullet in magazine becomes zero,
    // it calls the wait() method and releases the lock.
    synchronized public void fire(int bulletsToBeFired) {
        for (int i = 1; i <= bulletsToBeFired; i++) {
            System.out.println("Bullet fired "+i);
            if (bullets == 0) {
                System.out.println(i - 1
                        + " bullets fired and "
                        + bullets + " remains");
                System.out.println(
                        "Invoking the wait() method");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                        "Continuing the fire after reloading");
            }

            bullets--;
        }
        System.out.println(
                "The firing process is complete");
    }

    // reload() increases the bullets by 40 everytime it is
    // invoked and calls the notify() method which wakes up
    // the thread that was sent to sleep using wait() inside
    // of fire() method
    synchronized public void reload() {
        System.out.println(
                "Reloading the magazine and resuming "
                        + "the thread using notify()");
        bullets += 40;
        notify();
    }
}
