package ra.bussiness;

import ra.entity.Book;
import java.util.Scanner;

public class BookBussiness {
    public static void displayListBook(Book[] books, int bookCount) {
        if (bookCount == 0) {
            System.err.println("Chưa có sách");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            books[i].displayData();
        }
    }

    public static int addNewBooks(Scanner scanner, Book[] books, int bookCount, int maxBooks) {
        if (bookCount >= maxBooks) {
            System.err.println("Danh sách sách đã đầy, không thể thêm mới!");
            return bookCount;
        }

        System.out.println("Nhập số lượng sách cần thêm: ");
        int numberOfBook = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numberOfBook && bookCount < maxBooks; i++) {
            System.out.println("Nhập thông tin cho sách thứ " + (i + 1) + ":");
            Book book = new Book();
            book.inputData(scanner);
            books[bookCount++] = book;
        }
        System.out.println("Thêm sách thành công");
        return bookCount;
    }

    public static void editBookById(Scanner scanner, Book[] books, int bookCount) {
        System.out.println("Nhập mã sách cần chỉnh sửa: ");
        String bookId = scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId().equals(bookId)) {
                System.out.println("Thông tin sách hiện tại:");
                books[i].displayData();
                books[i].inputData(scanner);
                System.out.println("Đã cập nhật thông tin sách!");
                return;
            }
        }
        System.err.println("Không tìm thấy sách có mã: " + bookId);
    }

    public static int deleteBookById(Scanner scanner, Book[] books, int bookCount) {
        System.out.print("Nhập mã sách cần xóa: ");
        String bookId = scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId().equals(bookId)) {
                System.out.println("Thông tin sách cần xóa:");
                books[i].displayData();
                System.out.print("Bạn có chắc chắn muốn xóa sách này ? (Y/N): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
                    for (int j = i; j < bookCount - 1; j++) {
                        books[j] = books[j + 1];
                    }
                    books[--bookCount] = null;
                    System.out.println("Sách đã được xóa thành công!");
                } else {
                    System.out.println("Hủy bỏ thao tác xóa sách.");
                }
                return bookCount;
            }
        }
        System.err.println("Không tìm thấy sách có mã: " + bookId);
        return bookCount;
    }
}