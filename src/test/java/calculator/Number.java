package calculator;

public class Number {
    private long value;

    private Number(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public static Number toNumber(String stringValue) {
        return new Number(Long.parseLong(stringValue));
    }

    public static Number of(long value){
        return new Number(value);
    }
}
