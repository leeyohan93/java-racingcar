package calculator;

public enum Operator {

    ADD("+") {
        Number calculate(Number x, Number y) {
            return Number.of(x.getValue() + y.getValue());
        }
    },
    MINUS("-") {
        Number calculate(Number x, Number y) {
            return Number.of(x.getValue() - y.getValue());
        }
    },
    MULTIPLE("*") {
        Number calculate(Number x, Number y) {
            return Number.of(x.getValue() * y.getValue());
        }
    },
    DIVIDE("/") {
        Number calculate(Number x, Number y) {
            return Number.of(x.getValue() / y.getValue());
        }
    };

    String value;

    Operator(String value) {
        this.value = value;
    }

    static Operator findOperatorByValue(String operatorValue) {
        for (Operator operator : values()) {
            if (operator.value.equals(operatorValue)) {
                return operator;
            }
        }
        throw new IllegalArgumentException();
    }

    abstract Number calculate(Number x, Number y);
}

