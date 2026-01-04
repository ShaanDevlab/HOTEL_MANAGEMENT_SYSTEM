package JAVA_PROGRAMS;

import java.util.Scanner;

class DivisionByZeroException extends Exception {
    DivisionByZeroException(String msg) {
        super(msg);
    }
}

public class DivisionDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int a = 10, b = sc.nextInt();
            if (b == 0)
                throw new DivisionByZeroException("Division by zero");

            System.out.println("Result = " + (a / b));
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }
}

