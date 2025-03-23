import java.util.HashSet;
import java.util.Iterator;

public class bai3 {
    public static void main(String[] args) {
        // Tạo HashSet chứa các số nguyên từ 1 đến 10
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

//        // Xóa các số chẵn khỏi HashSet
//        numbers.removeIf(n -> n % 2 == 0);

        // Dùng Iterator để xóa các số chẵn
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("HashSet sau khi xóa các số chẵn: " + numbers);
    }
}
