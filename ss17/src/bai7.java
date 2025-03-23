import java.util.HashSet;
import java.util.Scanner;

public class bai7 {
    public static void main(String[] args) {
        // Nhập đoạn văn từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đoạn văn bản: ");
        String text = scanner.nextLine().toLowerCase();

        // Tách từ trong đoạn văn
        String[] words = text.split("\\W+");

        // Sử dụng HashSet để lưu các từ không trùng lặp
        HashSet<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        // In danh sách các từ và số lần xuất hiện của chúng
        System.out.println("Danh sách từ và số lần xuất hiện: ");
        for (String word : uniqueWords) {
            int count = 0;
            for (String w : words) {
                if (word.equals(w)) {
                    count++;
                }
            }
            System.out.println(word + ": " + count);
        }
    }
}
