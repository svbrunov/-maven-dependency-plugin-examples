package info.brunov.maven.example;

import com.google.common.base.MoreObjects;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public final class CalculatorTest {
    @ParameterizedTest
    @MethodSource("calculatorIncrementTestDataStream")
    public void test(final CalculatorIncrementTestData testData) {
        // Arrange.
        final Calculator instance = new Calculator();

        // Act.
        final Integer result = instance.increment(testData.inputNumber());

        // Assert.
        Assertions.assertEquals(testData.expectedOutputNumber(), result);
    }

    @SuppressWarnings("unused")
    private static Stream<CalculatorIncrementTestData> calculatorIncrementTestDataStream() {
        return Stream.of(
            new CalculatorIncrementTestData(0, 1),
            new CalculatorIncrementTestData(1, 2),
            new CalculatorIncrementTestData(2, 3)
        );
    }

    private static final class CalculatorIncrementTestData {
        private final Integer inputNumber;
        private final Integer expectedOutputNumber;

        public CalculatorIncrementTestData(
            final Integer inputNumber,
            final Integer expectedOutputNumber) {
            this.inputNumber = inputNumber;
            this.expectedOutputNumber = expectedOutputNumber;
        }

        public Integer inputNumber() {
            return inputNumber;
        }

        public Integer expectedOutputNumber() {
            return expectedOutputNumber;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                .add("inputNumber", inputNumber)
                .add("expectedOutputNumber", expectedOutputNumber)
                .toString();
        }
    }
}
