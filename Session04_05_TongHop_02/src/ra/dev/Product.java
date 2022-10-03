package ra.dev;

import java.util.Scanner;

public class Product {
    //1. Cac thuoc tinh
    private String productId;
    private String productName;
    private String title;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private String descriptions;
    private boolean productStatus;
    //has-a
    private Catalog catalog;
    //2. Cac constructor

    public Product() {
    }

    public Product(String productId, String productName, String title, float importPrice, float exportPrice, int quantity, String descriptions, boolean productStatus, Catalog catalog) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
        this.catalog = catalog;
    }
    //3. Cac phuong thuc
    //3.1. Cac phuong thuc get/set

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    //3.2. Cac phuong thuc chuc nang
    public void inputData(Scanner sc, Catalog[] arrCatalog, int indexMax) {
        System.out.println("Nhap vao ma san pham: ");
        this.productId = sc.nextLine();
        System.out.println("Nhap vao ten san pham: ");
        this.productName = sc.nextLine();
        System.out.println("Nhap vao tieu de san pham: ");
        this.title = sc.nextLine();
        System.out.println("Nhap vao gia nhap cua san pham:");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap vao so luong san pham:");
        this.quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao mo ta san pham:");
        this.descriptions = sc.nextLine();
        System.out.println("Nhap vao trang thai san pham:");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Chon danh muc san pham cua san pham: ");
        for (int i = 0; i < indexMax; i++) {
            System.out.printf("%d.%s\n", (i + 1), arrCatalog[i].getCatalogName());
        }
        System.out.print("Lua chon cua ban: ");
        int indexChoice = Integer.parseInt(sc.nextLine());
        //Set doi tuong danh muc cho san pham
        this.catalog = arrCatalog[indexChoice - 1];
    }

    public void displayData() {
        System.out.printf("Ma SP: %s - Ten SP: %s - Tieu de: %s\n", this.productId, this.productName, this.title);
        System.out.printf("Gia nhap: %f - gia xuat: %f - So luong: %d\n", this.importPrice, this.exportPrice, this.quantity);
        String trangThai = "";
        if (this.productStatus) {
            trangThai = "Con ban";
        } else {
            trangThai = "Khong ban";
        }
        System.out.printf("Trang thai: %s - Danh muc: %s\n",trangThai,this.catalog.getCatalogName());
    }

    public void calExportPrice() {
        this.exportPrice = this.importPrice * 1.2F;
    }
}
