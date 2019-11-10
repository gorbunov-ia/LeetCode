package ru.gorbunov.tasks._1114printinorder;

import java.util.concurrent.CountDownLatch;

class Foo {

    private final CountDownLatch second = new CountDownLatch(1);
    private final CountDownLatch third = new CountDownLatch(1);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        second.await();
        try {
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        } finally {
            third.countDown();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
