package by.guru13.temp.iterator;


import java.util.Iterator;
import java.util.List;

@SuppressWarnings("CheckStyle")
public final class Example02 {

    private Example02() {
    }

    public static void main(final String[] args) {
        final List<Integer> values = List.of(0, 1, 2, 3, 4);
        final Iterator<Integer> iterator = values.iterator();
        simpleIteration(iterator);
        complexIteration(iterator);
    }

    private static void simpleIteration(final Iterator<Integer> iterator) {
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void complexIteration(final Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            final Integer value = iterator.next();
            System.out.println(value);
            if (value == 3) {
                break;
            }
        }
    }
}