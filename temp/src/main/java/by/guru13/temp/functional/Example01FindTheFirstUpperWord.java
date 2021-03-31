package by.guru13.temp.functional;

import java.util.List;

import static java.lang.Character.isUpperCase;

@SuppressWarnings("CheckStyle")
public final class Example01FindTheFirstUpperWord {

    private Example01FindTheFirstUpperWord() {
    }

    public static void main(final String[] args) {
        final List<String> strings = List.of("hello", "world", "java", "the", "best", "language");

        //Imperative
        boolean found = false;
        for (final String string : strings) {
            if (string.length() > 0 && isUpperCase(string.charAt(0))) {
                System.out.println(string);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not found");
        }

        //Functional
        System.out.println(strings.stream()
            .filter(s -> s.length() > 0 && isUpperCase(s.charAt(0)))
            .findFirst()
            .orElse("Not found")
        );
    }
}