package by.it.seroglazov.jd02_01;

public class MyRandom {

    // Random value from from to to, inclusive both borders
    static int getRandom(int from, int to) {
        return from + (int) (Math.random() * (to - from + 1));
    }
}
