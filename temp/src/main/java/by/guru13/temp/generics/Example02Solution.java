package by.guru13.temp.generics;

import java.util.List;
import java.util.Objects;


@SuppressWarnings("CheckStyle")
public final class Example02Solution {

    private Example02Solution() {
    }

    public static void main(final String[] args) {
        final List<Integer> items = List.of(0, 1, 2, 3, 4, 5);

        System.out.println(linearSearch(items, 5));
        //System.out.println(linearSearch(items, "5"));
    }


    // Java is statically typed language
    private static <T> int linearSearch(final List<T> items, final T query) {
        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(query, items.get(i))) {
                return i;
            }
        }
        return -1;
    }
}