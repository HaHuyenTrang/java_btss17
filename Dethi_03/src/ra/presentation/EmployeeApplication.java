package ra.presentation;


import ra.business.EmployeeBusiness;
import java.util.Scanner;

public class EmployeeApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeBusiness business = new EmployeeBusiness(100); // Giới hạn tối đa 100 nhân viên
        int choice;

        do {
            System.out.println("---------- Employee Menu ----------");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Chỉnh sửa thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên");
            System.out.println("6. Sắp xếp danh sách nhân viên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> business.displayEmployees();
                case 2 -> business.addEmployee(sc);
                case 3 -> business.editEmployee(sc);
                case 4 -> business.deleteEmployee(sc);
                case 5 -> business.searchEmployee(sc);
                case 6 -> business.sortEmployees();
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 0);

        sc.close();
    }
}
