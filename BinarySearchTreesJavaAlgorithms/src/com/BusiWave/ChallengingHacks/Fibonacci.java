package com.BusiWave.ChallengingHacks;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(15));
    }

    static int fib(int x) {
        if (x == 0 || x == 1)
            return 1;
        if (x == 2)
            return 2;
        int previous = 1;
        int current = 2;
        for (int a = 3; a <= x; a++) {
            int tmp = current + previous;
            if (a == x)
                return tmp;
            int tmpCurrent = current;
            current = tmp;
            previous = tmpCurrent;
        }

        throw new IllegalStateException();
    }
}