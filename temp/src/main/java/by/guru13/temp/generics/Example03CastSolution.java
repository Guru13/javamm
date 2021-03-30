package by.guru13.temp.generics;

import java.util.List;


@SuppressWarnings("CheckStyle")
public final class Example03CastSolution {

    private Example03CastSolution() {
    }

    public static void main(final String[] args) {
        final List<Integer> items = List.of(3, 4, 0, 1, 5);

        System.out.println(findMin(items));
        System.out.println(findMin(List.of("hello", "world", "java")));
        //System.out.println(findMin(List.of(new AtomicInteger(3), new AtomicInteger(0), new AtomicInteger(1))));
    }

    private static <T extends Comparable<T>> T findMin(final List<T> items) {
        T min = items.get(0);
        for (final T item : items) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }
}