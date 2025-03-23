import java.util.HashSet;

public class bai1 {
    public static void main(String[] args) {
        // Tạo HashSet để lưu trữ số nguyên
        HashSet<Integer> numbers = new HashSet<>();

        // Thêm các số vào HashSet
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // In tất cả phần tử của HashSet
        System.out.println("Các phần tử trong HashSet: " + numbers);
    }
}
