package ra.business;

import ra.Employee;
import java.util.Scanner;

public class EmployeeBusiness {
    private Employee[] employees;
    private int size = 0; // Số lượng nhân viên hiện tại

    public EmployeeBusiness(int capacity) {
        employees = new Employee[capacity]; // Khởi tạo mảng có kích thước cố định
    }

    // 1. Hiển thị danh sách nhân viên
    public void displayEmployees() {
        if (size == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        for (int i = 0; i < size; i++) {
            employees[i].displayData();
        }
    }

    // 2. Thêm mới nhân viên
    public void addEmployee(Scanner sc) {
        if (size >= employees.length) {
            System.out.println("Danh sách nhân viên đã đầy, không thể thêm mới.");
            return;
        }

        System.out.print("Nhập số lượng nhân viên cần thêm: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (size >= employees.length) {
                System.out.println("Không thể thêm nữa, danh sách đã đầy!");
                break;
            }
            Employee emp = new Employee();
            emp.inputData(sc);
            employees[size] = emp;
            size++;
        }
        System.out.println("Thêm nhân viên thành công!");
    }

    // 3. Chỉnh sửa thông tin nhân viên
    public void editEmployee(Scanner sc) {
        System.out.print("Nhập mã nhân viên cần sửa: ");
        String id = sc.nextLine();

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                employees[i].inputData(sc); // Nhập lại toàn bộ thông tin
                System.out.println("Cập nhật thông tin thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên.");
    }

    // 4. Xóa nhân viên
    public void deleteEmployee(Scanner sc) {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String id = sc.nextLine();

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                // Dịch các phần tử phía sau lên trước để xóa nhân viên
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null; // Xóa phần tử cuối
                size--;
                System.out.println("Xóa nhân viên thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên.");
    }

    // 5. Tìm kiếm nhân viên theo tên
    public void searchEmployee(Scanner sc) {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        String name = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeName().contains(name)) {
                employees[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy kết quả phù hợp.");
        }
    }

    // 6. Sắp xếp danh sách nhân viên theo tên (A-Z)
    public void sortEmployees() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (employees[i].getEmployeeName().compareToIgnoreCase(employees[j].getEmployeeName()) > 0) {
                    // Hoán đổi vị trí
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        System.out.println("Danh sách nhân viên đã được sắp xếp theo tên.");
    }
}
