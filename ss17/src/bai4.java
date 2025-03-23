import java.util.TreeSet;

public class bai4 {
    public static void main(String[] args) {
        // Tạo TreeSet để lưu trữ các số nguyên
        TreeSet<Integer> numbers = new TreeSet<>();

        // Thêm các số vào TreeSet
        numbers.add(45);
        numbers.add(12);
        numbers.add(78);
        numbers.add(34);
        numbers.add(23);
        numbers.add(89);

        // In để kiểm tra thứ tự sắp xếp
        System.out.println("Các phần tử trong TreeSet: " + numbers);
    }
}
