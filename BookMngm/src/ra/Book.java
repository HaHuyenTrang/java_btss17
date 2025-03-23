package ra;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    // Constructor không tham số
    public Book() {}

    // Getter & Setter
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public void calculateProfit() {
        this.interest = this.exportPrice - this.importPrice;
    }


    public void inputData(Scanner sc) {
        System.out.print("Nhập mã sách: ");
        this.bookId = sc.nextLine();

        System.out.print("Nhập tên sách (4 ký tự, bắt đầu bằng 'B'): ");
        this.bookName = sc.nextLine();

        do {
            System.out.print("Nhập giá nhập: ");
            this.importPrice = sc.nextFloat();
            if (importPrice <= 0) {
                System.out.println("Giá nhập phải lớn hơn 0!");
            }
        } while (importPrice <= 0);

        do {
            System.out.print("Nhập giá xuất (lớn hơn ít nhất 30% giá nhập): ");
            this.exportPrice = sc.nextFloat();
            if (exportPrice < importPrice * 1.3) {
                System.out.println("Giá xuất phải lớn hơn ít nhất 30% giá nhập!");
            }
        } while (exportPrice < importPrice * 1.3);

        sc.nextLine(); // Clear buffer
        do {
            System.out.print("Nhập tác giả (6-50 ký tự): ");
            this.author = sc.nextLine();
            if (author.length() < 6 || author.length() > 50) {
                System.out.println("Tên tác giả phải từ 6 đến 50 ký tự!");
            }
        } while (author.length() < 6 || author.length() > 50);

        do {
            System.out.print("Nhập năm xuất bản (sau năm 2000): ");
            this.year = sc.nextInt();
            if (year <= 2000) {
                System.out.println("Năm xuất bản phải sau năm 2000!");
            }
        } while (year <= 2000);

        // Tính lợi nhuận
        this.interest = exportPrice - importPrice;
    }

    // Phương thức hiển thị thông tin sách
    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm xuất bản: " + year);
    }
}

