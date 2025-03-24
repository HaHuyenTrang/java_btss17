package ra.validate;

public class StringRule {
    private final int valueLength;

    public StringRule(int valueLength) {
        this.valueLength = valueLength;
    }

    public boolean isValidString(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.length() <= this.valueLength;
    }
}