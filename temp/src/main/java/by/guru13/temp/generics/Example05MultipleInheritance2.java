package by.guru13.temp.generics;

import java.io.Serializable;

@SuppressWarnings("CheckStyle")
public final class Example05MultipleInheritance2 {

    private Example05MultipleInheritance2() {
    }

    public static void main(final String[] args) {
        final IntegerProvider integerProvider = new IntegerProvider();
        final NumberAndComparableProvider<Integer> numberAndComparableProvider = integerProvider;
    }

    private interface NumberAndComparableProvider<T extends Number & Comparable<T> & Serializable> {

        T getValue();
    }

    private static final class IntegerProvider implements NumberAndComparableProvider<Integer> {

        @Override
        public Integer getValue() {
            return 12;
        }
    }

    /*private static final class BooleanProvider implements NumberAndComparableProvider<Boolean> {
        @Override
        public Boolean getValue() {
            return true;
        }
    }*/
}
