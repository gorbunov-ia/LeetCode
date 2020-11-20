package ru.gorbunov.tasks._1114printinorder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class FooTest {

    private Foo foo;

    @BeforeEach
    void setUp() {
        foo = new Foo();
    }

    @ParameterizedTest
    @ValueSource(strings = {"[1,2,3]", "[1,3,2]"})
    void example(String input) throws InterruptedException {
        final Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        final List<Order> orders = createOrders(scanner.nextLine());
        final StringBuffer buffer = new StringBuffer();

        List<Thread> threads = new ArrayList<>(orders.size());
        for (Order order : orders) {
            final Thread thread = new Thread(run(foo, order, buffer));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        Assertions.assertEquals("firstsecondthird", buffer.toString());
    }

    private static List<Order> createOrders(String line) {
        final LinkedList<Order> numbers = new LinkedList<>();
        for (String number : line.replaceAll("[\\[|\\]]", "").split(",")) {
            final Order order = Order.create(number.charAt(0));
            numbers.add(order);
        }
        return numbers;
    }

    private static Runnable run(Foo foo, Order order, StringBuffer buffer) {
        final TestPrinter testPrinter = new TestPrinter(order.message, buffer);
        return () -> {
            try {
                switch (order) {
                    case ONE:
                        foo.first(testPrinter);
                        break;
                    case TWO:
                        foo.second(testPrinter);
                        break;
                    case THREE:
                        foo.third(testPrinter);
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

    private static class TestPrinter implements Runnable {

        private final String message;
        private final StringBuffer buffer;

        private TestPrinter(String message, StringBuffer buffer) {
            this.message = message;
            this.buffer = buffer;
        }

        @Override
        public void run() {
            buffer.append(message);
        }
    }
}