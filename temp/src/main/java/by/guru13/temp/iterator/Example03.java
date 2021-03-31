package by.guru13.temp.iterator;


import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("CheckStyle")
public final class Example03 {

    private Example03() {
    }

    public static void main(final String[] args) {
        final List<Integer> values = List.of(0, 1, 2, 3, 4);
        final ListIterator<Integer> iterator = values.listIterator();
        simpleIteration(iterator);
        complexIteration(iterator);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void simpleIteration(final ListIterator<Integer> iterator) {
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void complexIteration(final ListIterator<Integer> iterator) {
        while (iterator.hasNext()) {
            final Integer value = iterator.next();
            System.out.println(value);
            if (value == 3) {
                iterator.previous();
                break;
            }
        }
    }
}