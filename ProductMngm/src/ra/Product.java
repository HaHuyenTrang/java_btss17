package ra;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;


    public Product() {
    }
    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    // Getters và Setters
    public String getProductId() {
        return productId;
    }

//    public void setProductId(String productId) {
//        this.productId = productId;
//    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Phương thức tính lợi nhuận
    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }

    // Phương thức nhập dữ liệu
    public void inputData(Scanner scanner, Product[] arrProduct) {
        System.out.print("Nhập mã sản phẩm (4 ký tự): ");
        this.productId = scanner.nextLine();

        System.out.print("Nhập tên sản phẩm (6-50 ký tự): ");
        this.productName = scanner.nextLine();

        do {
            System.out.print("Nhập giá nhập (lớn hơn 0): ");
            this.importPrice = scanner.nextFloat();
        } while (this.importPrice <= 0);

        do {
            System.out.print("Nhập giá xuất (lớn hơn ít nhất 20% giá nhập): ");
            this.exportPrice = scanner.nextFloat();
        } while (this.exportPrice < this.importPrice * 1.2);

        this.calProfit(); // Tính lợi nhuận

        do {
            System.out.print("Nhập số lượng sản phẩm (lớn hơn 0): ");
            this.quantity = scanner.nextInt();
        } while (this.quantity <= 0);
        scanner.nextLine(); // Clear buffer

        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();

        System.out.print("Nhập trạng thái sản phẩm (true: Đang bán, false: Không bán): ");
        this.status = scanner.nextBoolean();
    }

    // Phương thức hiển thị thông tin sản phẩm
    public void displayData() {
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Lợi nhuận: " + this.profit);
        System.out.println("Số lượng: " + this.quantity);
        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Trạng thái: " + (this.status ? "Đang bán" : "Không bán"));
        System.out.println("----------------------------------");
    }
}
