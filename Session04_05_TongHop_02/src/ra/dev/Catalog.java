package ra.dev;

import java.util.Scanner;

public class Catalog {
    //1. Cac thuoc tinh
    private int catalogId;
    private String catalogName;
    private int priority;
    private boolean catalogStatus;
    //2. Cac constructor

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.catalogStatus = catalogStatus;
    }

    //3. Cac phuong thuc
    //3.1. Cac phuong thuc get/set

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
    //3.2. Cac phuong thuc thuc hien cac chuc nang
    public void inputData(Scanner sc){
        System.out.println("Nhap vao ma danh muc: ");
        this.catalogId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao ten danh muc: ");
        this.catalogName = sc.nextLine();
        System.out.println("Nhap vao do uu tien cua danh muc: ");
        this.priority = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao trang thai cua danh muc: ");
        this.catalogStatus = Boolean.parseBoolean(sc.nextLine());
    }
    public void displayData(){
        System.out.printf("Ma DM: %d - Ten DM: %s - Do UT: %d - Trang thai: %b\n",this.catalogId,this.catalogName,this.priority,this.catalogStatus);
    }
}
