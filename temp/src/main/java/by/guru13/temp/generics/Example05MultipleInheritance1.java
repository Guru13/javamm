package by.guru13.temp.generics;

@SuppressWarnings("CheckStyle")
public final class Example05MultipleInheritance1 {

    private Example05MultipleInheritance1() {
    }

    public static void main(final String[] args) {
        final IntegerProvider integerProvider = new IntegerProvider();
        final NumberProvider<Integer> numberProvider = integerProvider;
        final ComparableProvider<Integer> comparableProvider = integerProvider;
    }


    private interface NumberProvider<T extends Number> {

        T getValue();
    }


    private interface ComparableProvider<T extends Comparable<T>> {

        T getValue();
    }


    private static final class IntegerProvider implements NumberProvider<Integer>, ComparableProvider<Integer> {

        @Override
        public Integer getValue() {
            return 12;
        }
    }


    /*private static final class BooleanProvider implements NumberProvider<Boolean>, ComparableProvider<Boolean> {
        @Override
        public Boolean getValue() {
            return true;
        }
    }*/
}