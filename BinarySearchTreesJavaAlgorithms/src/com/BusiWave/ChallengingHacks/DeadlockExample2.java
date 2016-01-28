package com.BusiWave.ChallengingHacks;

public class DeadlockExample2 {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        locker(lock1, lock2).start();
        locker(lock2, lock1).start();
    }

    static Thread locker(final Object lock1, final Object lock2) {
        return new Thread() {
            public void run() {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread() + " acquired a lock on " + lock1 + " and wants a lock on " + lock2);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread() + " acquired both locks.");
                    }
                }
            }
        };
    }
}