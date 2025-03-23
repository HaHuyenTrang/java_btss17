import java.util.HashSet;
import java.util.TreeSet;

public class bai6 {
    public static void main(String[] args) {
        // Tạo hai HashSet
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Thêm phần tử vào Set1
        set1.add(10);
        set1.add(20);
        set1.add(30);
        set1.add(40);

        // Thêm phần tử vào Set2
        set2.add(30);
        set2.add(40);
        set2.add(50);
        set2.add(60);

        // Tìm giao của hai HashSet
        set1.retainAll(set2);

        // Sắp xếp các phần tử giao nhau theo thứ tự tăng dần
        TreeSet<Integer> sortedIntersection = new TreeSet<>(set1);

        System.out.println("Các phần tử giao nhau sau khi sắp xếp: " + sortedIntersection);
    }
}
