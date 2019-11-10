package ru.gorbunov.tasks._1114printinorder;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
