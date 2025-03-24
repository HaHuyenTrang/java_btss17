package ra.entity;

import ra.validate.BookValidator;
import ra.validate.StringRule;
import ra.validate.Validator;

import java.util.Scanner;

public class Book extends IApp {
    private String bookId;
    private String bookTitle;
    private String author;
    private String publisher;
    private int publicationYear;
    private String category;
    private double price;
    private int quantity;

    public Book() {
    }

    public Book(String bookId, String bookTitle, String author, String publisher, int publicationYear, String category, double price, int quantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.bookId = inputBookId(scanner);
        this.bookTitle = Validator.validateInputString(scanner, "Nhập vào tiêu đề sách: ", new StringRule(100));
        this.author = Validator.validateInputString(scanner, "Nhập vào tác giả: ", new StringRule(50));
        this.publisher = Validator.validateInputString(scanner, "Nhập vào nhà xuất bản: ", new StringRule(100));
        this.publicationYear = Validator.validateInputInt(scanner, "Nhập vào năm xuất bản: ");
        this.category = Validator.validateInputString(scanner, "Nhập vào thể loại: ", new StringRule(100));
        this.price = Validator.validateInputDouble(scanner, "Nhập vào giá sách", 0);
        this.quantity = Validator.validateInputInt(scanner, "Nhập vào số lượng sách: ");
    }

    public String inputBookId(Scanner scanner) {
        return BookValidator.validateBookId(scanner, "Nhập vào mã sách: ", "[B]\\w{4}");
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sách: %s - Tiêu đề sách: %s - Tác giả: %s - Nhà xuất bản: %s \n",
                this.bookId, this.bookTitle, this.author, this.publisher);
        System.out.printf("Năm xuất bản: %d - Thể loại: %s - Giá: %.2f - Số lượng: %d\n",
                this.publicationYear, this.category, this.price, this.quantity);
        System.out.println("--------------------------------------------");
    }
}