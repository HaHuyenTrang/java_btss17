package ra.presentation;

import ra.bussiness.BookBussiness;
import ra.entity.Book;

import java.util.Scanner;

public class BookApplication {
    public static final int MAX_BOOKS = 100; // Số lượng sách tối đa
    public static Book[] books = new Book[MAX_BOOKS];
    public static int bookCount = 0; // Số lượng sách hiện có

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----------------------------Book Menu----------------------------");
            System.out.println("1. Hiển thị danh sách các cuốn sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Chỉnh sửa thông tin sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm kiếm sách");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn từ 0 - 6: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BookBussiness.displayListBook(books, bookCount);
                    break;
                case 2:
                    bookCount = BookBussiness.addNewBooks(scanner, books, bookCount, MAX_BOOKS);
                    break;
                case 3:
                    BookBussiness.editBookById(scanner, books, bookCount);
                    break;
                case 4:
                    bookCount = BookBussiness.deleteBookById(scanner, books, bookCount);
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 0 - 6");
            }
        } while (true);
    }
}
