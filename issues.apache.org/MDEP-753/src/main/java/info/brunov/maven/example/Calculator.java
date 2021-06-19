package info.brunov.maven.example;

import com.google.common.base.Functions;

public final class Calculator {
    public Integer increment(final Integer inputNumber) {
        final Integer one = Functions.<Integer>identity().apply(1);
        return inputNumber + one;
    }
}
