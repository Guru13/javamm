package by.guru13.temp.iterator;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("CheckStyle")
public final class Example01 {

    private Example01() {
    }

    public static void main(final String[] args) {
        final List<Integer> values = List.of(0, 1, 2, 3, 4);
        // ---------------------------------------------------------------
        final Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        // ---------------------------------------------------------------
        for (final Iterator<Integer> it = values.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        // ---------------------------------------------------------------
        for (final Integer value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
