package by.guru13.temp.functional;


import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.naturalOrder;

@SuppressWarnings("CheckStyle")
public final class Example02FindTheMinLetterCount {

    private Example02FindTheMinLetterCount() {
    }

    public static void main(final String[] args) {
        final List<String> strings = List.of("Hello", "world", "Java", "the", "best", "language");

        //Imperative
        int length = Integer.MAX_VALUE;
        for (final String string : strings) {
            if (string.length() < length) {
                length = string.length();
            }
        }
        System.out.println(length == Integer.MAX_VALUE ? -1 : length);

        //Functional
        System.out.println(strings.stream()
            .map(String::length)
            .min(naturalOrder())
            .orElse(-1)
        );


    }
}