package ra.validate;


import java.util.regex.Pattern;

public class validate {
    public static boolean isValidEmployeeId(String employeeId) {
        return employeeId.matches("^NV\\d{4}$");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches("^(0[3|5|7|8|9])\\d{8}$", phoneNumber);
    }

    public static boolean isValidCoefficient(float coefficient) {
        return coefficient > 0;
    }

    public static boolean isValidAllowance(int allowance) {
        return allowance >= 0;
    }
}
