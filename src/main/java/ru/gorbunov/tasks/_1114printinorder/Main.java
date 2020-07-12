package ru.gorbunov.tasks._1114printinorder;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Print in Order
 *
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 *
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B
 * will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure
 * that second() is executed after first(), and third() is executed after second().
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(),
 * thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 *
 * Example 2:
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second().
 * "firstsecondthird" is the correct output.
 *
 * Note:
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input
 * seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 */
public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(new ByteArrayInputStream("[1,3,2]".getBytes()));
        final List<Order> orders = createOrders(scanner.nextLine());

        final Foo foo = new Foo();
        for (Order order : orders) {
            new Thread(run(foo, order)).start();
        }
    }

    private static List<Order> createOrders(String line) {
        final LinkedList<Order> numbers = new LinkedList<>();
        for (String number : line.replaceAll("[\\[|\\]]", "").split(",")) {
            final Order order = Order.create(number.charAt(0));
            numbers.add(order);
        }
        return numbers;
    }

    private static Runnable run(Foo foo, Order order) {
        final Printer printer = new Printer(order.message);
        return () -> {
            try {
                switch (order) {
                    case ONE:
                        foo.first(printer);
                        break;
                    case TWO:
                        foo.second(printer);
                        break;
                    case THREE:
                        foo.third(printer);
                        break;
                    default:
                        throw new IllegalStateException();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }

    private enum Order {
        ONE('1', "first"),
        TWO('2', "second"),
        THREE('3', "third");

        private final char key;
        private final String message;

        Order(char key, String message) {
            this.key = key;
            this.message = message;
        }

        static Order create(char key) {
            for (Order value : values()) {
                if (value.key == key) {
                    return value;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    private static class Printer implements Runnable {

        private final String message;

        private Printer(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.print(message);
        }
    }
}
