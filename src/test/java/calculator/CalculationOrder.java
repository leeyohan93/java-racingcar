package calculator;


import java.util.Stack;

public class CalculationOrder {

    private static final int BaseInputSize = 3;
    private static final int AdditionalInputSize = 2;
    private static final int NumberLastIndex = 1;
    private static final int OperationLastIndex = 2;
    private static final int IndexInterval = 2;

    private Stack<Number> numberStack = new Stack<>();
    private Stack<Operator> operatorStack = new Stack<>();

    public void init(String[] inputs) {
        addStackReverse(inputs);
    }

    private void addStackReverse(String[] inputs) {
        verifyInputs(inputs);
        addOperationStack(inputs);
        try {
            addNumberStack(inputs);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void addOperationStack(String[] inputs) {
        for (int i = inputs.length - OperationLastIndex; i >= 0; i = i - IndexInterval) {
            operatorStack.push(Operator.findOperatorByValue(inputs[i]));
        }
    }

    private void addNumberStack(String[] inputs) {
        for (int i = inputs.length - NumberLastIndex; i >= 0; i = i - IndexInterval) {
            numberStack.push(Number.toNumber(inputs[i]));
        }
    }

    private void verifyInputs(String[] inputs) {
        if ((inputs.length - BaseInputSize) % AdditionalInputSize != 0) {
            throw new IllegalArgumentException();
        }
    }

    public Number nextNumber() {
        if (!numberStack.isEmpty()) {
            return numberStack.pop();
        }
        return null;
    }

    public Operator nextOperator() {
        if (!operatorStack.isEmpty()) {
            return operatorStack.pop();
        }
        return null;
    }

    public boolean isCalculate() {
        return operatorStack.size() > 0 && numberStack.size() > 1;
    }

    public void addCalculateResult(Number result) {
        numberStack.push(result);
    }

    public Number getCurrentNumber() {
        return numberStack.pop();
    }
}
