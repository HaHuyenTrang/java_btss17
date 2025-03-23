import java.util.HashSet;
import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        // Tạo HashSet để lưu trữ chuỗi
        HashSet<String> languages = new HashSet<>();

        // Thêm các ngôn ngữ vào HashSet
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");

        // Nhập một chuỗi từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một ngôn ngữ lập trình: ");
        String input = scanner.nextLine();

        // Kiểm tra xem chuỗi có tồn tại trong HashSet không
        if (languages.contains(input)) {
            System.out.println(input + " có trong HashSet.");
        } else {
            System.out.println(input + " không có trong HashSet.");
        }
    }
}