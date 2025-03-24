
package ra.validate;

import java.util.Scanner;

public class Validator {
    public static String validateInputString(Scanner scanner, String message, StringRule stringRule) {
        System.out.println(message);
        String inputString;
        do {
            inputString = scanner.nextLine().trim();
            if (inputString.isEmpty()) {
                System.err.println("Dữ liệu không được để trống, vui lòng nhập lại!");
                continue;
            }
            if (stringRule.isValidString(inputString)) {
                return inputString;
            }

            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại!");
        } while (true);
    }


    public static int validateInputInt(Scanner scanner, String message) {
        System.out.println(message);
        do {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Dữ liệu không được để trống, vui lòng nhập lại!");
                continue;
            }
            if (!input.matches("-?\\d+")) {
                System.err.println("Dữ liệu không phải số nguyên, vui lòng nhập lại!");
                continue;
            }
            return Integer.parseInt(input);
        } while (true);
    }


    public static double validateInputDouble(Scanner scanner, String message, double minValue) {
        System.out.println(message);
        do {
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.err.println("Dữ liệu không được để trống, vui lòng nhập lại!");
                continue;
            }

            if (!input.matches("-?\\d+(\\.\\d+)?")) {
                System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại!");
                continue;
            }

            double number = Double.parseDouble(input);
            if (number > minValue) {
                return number;
            }

            System.err.printf("Giá trị phải lớn hơn %f, vui lòng nhập lại!\n", minValue);
        } while (true);
    }

}
