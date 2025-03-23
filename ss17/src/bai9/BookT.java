package bai9;


import java.util.*;

public class BookT {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("1", "HarryPorter", "MR", 2015));
        bookSet.add(new Book("2", "Java", "TL", 2010));
        bookSet.add(new Book("3", "EXXXX", "AB", 2023));
        bookSet.add(new Book("4", "HPOIU", "CD", 2011));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập năm xuất bản tối thiểu: ");
        int minYear = scanner.nextInt();

        List<Book> sort = new ArrayList<>();
        for (Book book : bookSet) {
            if (book.getYear() > minYear) {
                sort.add(book);
            }
        }

        Collections.sort(sort, Comparator.comparing(Book::getTitle));

        System.out.println("Danh sách sách sau khi lọc và sắp xếp:");
        for (Book book : sort) {
            System.out.println(book);
        }
    }
}
