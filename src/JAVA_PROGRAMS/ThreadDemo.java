package JAVA_PROGRAMS;

class MyThread extends Thread {

    MyThread() {
        super("ChildThread");
        start();
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        new MyThread();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
