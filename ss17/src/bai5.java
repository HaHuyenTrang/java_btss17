import java.util.HashSet;
import java.util.TreeSet;

public class bai5 {
    public static void main(String[] args) {
        // Tạo hai HashSet
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Thêm phần tử vào Set1
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        // Thêm phần tử vào Set2
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);

        // Hợp hai HashSet
        set1.addAll(set2);

        // Sắp xếp tập hợp hợp nhất theo thứ tự tăng dần
        TreeSet<Integer> sortedSet = new TreeSet<>(set1);


        System.out.println("Tập hợp hợp nhất sau khi sắp xếp: " + sortedSet);
    }
}
