import java.util.Scanner;

public class bai8 {
    public static void main(String[] args) {
        // Khởi tạo mảng số nguyên
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Nhập giá trị tổng k
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tổng cần tìm: ");
        int k = scanner.nextInt();

        // Tìm các cặp số có tổng bằng k
        System.out.println("Các cặp số có tổng bằng " + k + ": ");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == k) {
                    System.out.println(numbers[i] + ", " + numbers[j]);
                }
            }
        }
    }
}
