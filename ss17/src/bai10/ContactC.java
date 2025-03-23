package bai10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactC{
    public static void main(String[] args) {
        Set<Contact> contactSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("\n1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc");
            System.out.println("3. Tìm kiếm liên lạc");
            System.out.println("4. Hiển thị danh sách liên lạc");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber);
                    if (!contactSet.add(newContact)) {
                        System.out.println("Số điện thoại đã tồn tại!");
                    } else {
                        System.out.println("Đã thêm liên lạc.");
                    }
                    break;
                case 2:
                    System.out.print("Nhập số điện thoại để xóa: ");
                    String phoneToDelete = scanner.nextLine();
                    contactSet.removeIf(contact -> contact.getPhoneNumber().equals(phoneToDelete));
                    System.out.println("Đã xóa liên lạc.");
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại để tìm: ");
                    String phoneToFind = scanner.nextLine();
                    boolean found = false;
                    for (Contact contact : contactSet) {
                        if (contact.getPhoneNumber().equals(phoneToFind)) {
                            System.out.println("Tìm thấy: " + contact);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy liên lạc.");
                    break;
                case 4:
                    System.out.println("Danh sách liên lạc:");
                    for (Contact contact : contactSet) {
                        System.out.println(contact);
                    }
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (true);
    }
}
