
package ra.validate;

import ra.entity.Book;
import ra.presentation.BookApplication;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static ra.presentation.BookApplication.books;

public class BookValidator {
    public static String validateBookId(Scanner scanner, String message, String regex) {
        System.out.println(message);
        while (true) {
            String inputString = scanner.nextLine().trim();

            if (!Pattern.matches(regex, inputString)) {
                System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại!");
                continue;
            }

            for (Book book: books) {
                if (book.getBookId().equalsIgnoreCase(inputString)) {
                    System.err.println("Mã sách đã tồn tại, vui lòng nhập lại!");
                    inputString = scanner.nextLine().trim();
                }
            }

            return inputString;
        }
    }
}
