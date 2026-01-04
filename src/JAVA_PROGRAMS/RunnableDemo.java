package JAVA_PROGRAMS;

class MyRunnable implements Runnable {

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}
