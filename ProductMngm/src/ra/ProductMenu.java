package ra;

import java.util.Scanner;

public class ProductMenu {
    private static Product[] products = new Product[100]; // Giả sử tối đa 100 sản phẩm
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProducts(scanner);
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    calculateProfit();
                    break;
                case 4:
                    sortByProfit();
                    break;
                case 5:
                    filterByPrice(scanner);
                    break;
                case 6:
                    searchByName(scanner);
                    break;
                case 7:
                    importProduct(scanner);
                    break;
                case 8:
                    sellProduct(scanner);
                    break;
                case 9:
                    updateStatus(scanner);
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 10);
        scanner.close();
    }

    private static void addProducts(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            if (count >= products.length) {
                System.out.println("Không thể thêm sản phẩm, bộ nhớ đầy!");
                return;
            }
            products[count] = new Product();
            products[count].inputData(scanner, products);
            count++;
        }
    }

    private static void displayProducts() {
        if (count == 0) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        for (int i = 0; i < count; i++) {
            products[i].displayData();
        }
    }

    private static void calculateProfit() {
        for (int i = 0; i < count; i++) {
            products[i].calProfit();
        }
        System.out.println("Đã tính lợi nhuận cho tất cả sản phẩm.");
    }

    private static void sortByProfit() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (products[i].getProfit() < products[j].getProfit()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sản phẩm theo lợi nhuận giảm dần.");
    }

    private static void filterByPrice(Scanner scanner) {
        System.out.print("Nhập khoảng giá từ: ");
        float fromPrice = scanner.nextFloat();
        System.out.print("Nhập khoảng giá đến: ");
        float toPrice = scanner.nextFloat();
        scanner.nextLine();
        int countFiltered = 0;
        for (int i = 0; i < count; i++) {
            if (products[i].getExportPrice() >= fromPrice && products[i].getExportPrice() <= toPrice) {
                products[i].displayData();
                countFiltered++;
            }
        }
        if (countFiltered == 0) {
            System.out.println("Không có sản phẩm nào trong khoảng giá này.");
        }
    }

    private static void searchByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (products[i].getProductName().equalsIgnoreCase(name)) {
                products[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm có tên: " + name);
        }
    }

    private static void importProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần nhập: ");
        String id = scanner.nextLine();
        System.out.print("Nhập số lượng cần nhập: ");
        int qty = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (products[i].getProductId().equals(id)) {
                products[i].setQuantity(products[i].getQuantity() + qty);
                System.out.println("Đã nhập thêm " + qty + " sản phẩm.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã: " + id);
    }

    private static void sellProduct(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần bán: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số lượng cần bán: ");
        int qty = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (products[i].getProductName().equalsIgnoreCase(name) && products[i].getQuantity() >= qty) {
                products[i].setQuantity(products[i].getQuantity() - qty);
                System.out.println("Đã bán " + qty + " sản phẩm.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm hoặc số lượng không đủ.");
    }

    private static void updateStatus(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
        String id = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (products[i].getProductId().equals(id)) {
                products[i].setStatus(!products[i].isStatus());
                System.out.println("Đã cập nhật trạng thái sản phẩm.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã: " + id);
    }
}
