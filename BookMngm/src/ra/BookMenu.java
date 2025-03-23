package ra;

import java.util.Scanner;

public class BookMenu {
    private static Book[] books = new Book[100]; // Giả sử tối đa 100 sách
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("*********************MENU******************");
            System.out.println("1. Nhập thông tin sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBooks(sc);
                    break;
                case 2:
                    calculateProfit();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    sortByExportPrice();
                    break;
                case 5:
                    sortByProfit();
                    break;
                case 6:
                    searchByName(sc);
                    break;
                case 7:
                    countByYear();
                    break;
                case 8:
                    countByAuthor();
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
        sc.close();
    }

    private static void addBooks(Scanner sc) {
        System.out.print("Nhập số lượng sách: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (count >= books.length) {
                System.out.println("Không thể thêm sách, bộ nhớ đầy!");
                return;
            }
            books[count] = new Book();
            books[count].inputData(sc);
            count++;
        }
    }

    private static void calculateProfit() {
        for (int i = 0; i < count; i++) {
            books[i].calculateProfit();
        }
        System.out.println("Đã tính lợi nhuận cho tất cả sách.");
    }

    private static void displayBooks() {
        if (count == 0) {
            System.out.println("Danh sách sách trống.");
            return;
        }
        for (int i = 0; i < count; i++) {
            books[i].displayData();
        }
    }

    private static void sortByExportPrice() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (books[i].getExportPrice() > books[j].getExportPrice()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sách theo giá bán tăng dần.");
    }

    private static void sortByProfit() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (books[i].getInterest() < books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sách theo lợi nhuận giảm dần.");
    }

    private static void searchByName(Scanner sc) {
        System.out.print("Nhập tên sách cần tìm: ");
        String name = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].getBookName().equalsIgnoreCase(name)) {
                books[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách có tên: " + name);
        }
    }

    private static void countByYear() {
        System.out.println("Thống kê số lượng sách theo năm xuất bản:");
        for (int i = 0; i < count; i++) {
            System.out.println("Năm " + books[i].getYear() + ": 1 sách");
        }
    }

    private static void countByAuthor() {
        System.out.println("Thống kê số lượng sách theo tác giả:");
        for (int i = 0; i < count; i++) {
            System.out.println("Tác giả " + books[i].getAuthor() + ": 1 sách");
        }
    }
}
