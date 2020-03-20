package calculator;


import org.junit.platform.commons.util.StringUtils;

public class Calculator {

    private static final String Separator = " ";

    private CalculationOrder calculationOrder = new CalculationOrder();

    public long calculate(String input) {
        verifyInput(input);
        calculationOrder.init(input.split(Separator));
        return calculate().getValue();
    }

    private Number calculate() {
        while (calculationOrder.isCalculate()) {
            Number number = calculationOrder.nextNumber();
            Number number2 = calculationOrder.nextNumber();
            Operator operator = calculationOrder.nextOperator();
            calculationOrder.addCalculateResult(operator.calculate(number, number2));
        }
        return calculationOrder.getCurrentNumber();
    }

    private void verifyInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }
}
