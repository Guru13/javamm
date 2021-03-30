package by.guru13.temp.generics;

import java.math.BigDecimal;
import java.util.List;


@SuppressWarnings("CheckStyle")
public final class Example04OverrideMethodReturnType {

    private Example04OverrideMethodReturnType() {
    }

    public static void main(final String[] args) {
        final List<NumberProvider> providers = List.of(
            new IntegerProvider(),
            new DoubleProvider(),
            new BigDecimalProvider()
        );
        for (final NumberProvider provider : providers) {
            System.out.println(provider.getValue());
        }
    }

    private interface NumberProvider {

        Number getValue();
    }

    private static final class IntegerProvider implements NumberProvider {

        @Override
        public Integer getValue() {
            return 12;//Integer.valueOf(12);
        }
    }

    private static final class DoubleProvider implements NumberProvider {

        @Override
        public Double getValue() {
            return 12.1;//Double.valueOf(12.1);
        }
    }

    private static final class BigDecimalProvider implements NumberProvider {

        @Override
        public BigDecimal getValue() {
            return new BigDecimal("12.1");
        }
    }
}
