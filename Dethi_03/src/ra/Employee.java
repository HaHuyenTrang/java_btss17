package ra;

import ra.validate.validate;

import java.util.Scanner;

public class Employee implements IApp {
    private String employeeId;
    private String employeeName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private float coefficient;
    private int allowanceSalary = 0;
    private String department;
    private byte status = 1;

    public Employee() {}

    public Employee(String employeeId, String employeeName, String birthday, String phoneNumber, boolean sex,
                    float coefficient, int allowanceSalary, String department, byte status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.coefficient = coefficient;
        this.allowanceSalary = allowanceSalary;
        this.department = department;
        this.status = status;
    }

    // Getter và Setter
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isSex() { return sex; }
    public void setSex(boolean sex) { this.sex = sex; }

    public float getCoefficient() { return coefficient; }
    public void setCoefficient(float coefficient) { this.coefficient = coefficient; }

    public int getAllowanceSalary() { return allowanceSalary; }
    public void setAllowanceSalary(int allowanceSalary) { this.allowanceSalary = allowanceSalary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public byte getStatus() { return status; }
    public void setStatus(byte status) { this.status = status; }



    @Override
    public void inputData(Scanner sc) {
        // Nhập và kiểm tra mã nhân viên
        do {
            System.out.print("Nhập mã nhân viên (NVxxxx): ");
            employeeId = sc.nextLine();
            if (!validate.isValidEmployeeId(employeeId)) {
                System.out.println("Mã nhân viên không hợp lệ! Định dạng: NV1234.");
            }
        } while (!validate.isValidEmployeeId(employeeId));
        System.out.print("Nhập tên nhân viên: ");
        this.employeeName = sc.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        this.birthday = sc.nextLine();

        // Nhập và kiểm tra số điện thoại
        do {
            System.out.print("Nhập số điện thoại: ");
            phoneNumber = sc.nextLine();
            if (!validate.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Số điện thoại không hợp lệ! Phải có 10 số và bắt đầu bằng 0.");
            }
        } while (!validate.isValidPhoneNumber(phoneNumber));

        System.out.print("Nhập giới tính (true - Nam, false - Nữ): ");
        this.sex = sc.nextBoolean();


        // Nhập và kiểm tra hệ số lương
        do {
            System.out.print("Nhập hệ số lương: ");
            coefficient = sc.nextFloat();
            if (!validate.isValidCoefficient(coefficient)) {
                System.out.println("Hệ số lương phải lớn hơn 0!");
            }
        } while (!validate.isValidCoefficient(coefficient));

        // Nhập và kiểm tra phụ cấp lương
        do {
            System.out.print("Nhập phụ cấp lương: ");
            allowanceSalary = sc.nextInt();
            sc.nextLine();
            if (!validate.isValidAllowance(allowanceSalary)) {
                System.out.println("Phụ cấp lương không được âm!");
            }
        } while (!validate.isValidAllowance(allowanceSalary));


        System.out.print("Nhập phòng ban: ");
        this.department = sc.nextLine();
    }


    public float getTotalSalary() {
        return BASE_SALARY * coefficient + allowanceSalary;
    }

    private String getStatusText() {
        switch (status) {
            case 1: return "Đang làm việc";
            case 2: return "Đang nghỉ phép";
            case 3: return "Đã nghỉ việc";
            default: return "Không xác định";
        }
    }


    @Override
    public void displayData() {
        String gender = sex ? "Nam" : "Nữ";
//        String statusText = switch (status) {
//            case 1 -> "Đang làm việc";
//            case 2 -> "Đang nghỉ phép";
//            case 3 -> "Đã nghỉ việc";
//            default -> "Không xác định";
//        };

        System.out.println("Mã NV: " + employeeId + ", Tên: " + employeeName + ", Ngày sinh: " + birthday +
                ", Giới tính: " + gender + ", SĐT: " + phoneNumber + ", Lương: " + getTotalSalary() +
                ", Phòng ban: " + department + ", Trạng thái: " + getStatusText());
    }

}
