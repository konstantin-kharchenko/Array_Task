package by.kharchenko.arrays.util;

public final class IdGenerator {

    private static int counter;

    private IdGenerator() {
    }

    public static int generate() {
        return ++counter;
    }
}
