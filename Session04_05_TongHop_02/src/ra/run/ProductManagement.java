package ra.run;

import ra.dev.Catalog;
import ra.dev.Product;

import java.util.Scanner;

public class ProductManagement {
    static Product[] arrProduct = new Product[1000];
    static Catalog[] arrCatalog = new Catalog[50];
    static int indexProduct = 0;
    static int indexCatalog = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("***********QUAN LY CUA HANG***************");
            System.out.println("1. Quan ly danh muc");
            System.out.println("2. Quan ly san pham");
            System.out.println("3. Thoat");
            System.out.print("Su lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    ProductManagement.menuCatalog(sc);
                    break;
                case 2:
                    ProductManagement.menuProduct(sc);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui long chon tu 1-3");
            }
        }while(true);
    }
    public static void menuCatalog(Scanner sc){
        boolean exitMenuCatalog = true;
        do {
            System.out.println("***************QUAN LY DANH MUC*******************");
            System.out.println("1. Nhap thong tin danh muc");
            System.out.println("2. Hien thi thong tin danh muc");
            System.out.println("3. Cap nhat thong tin danh muc");
            System.out.println("4. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choiceCatalog = Integer.parseInt(sc.nextLine());
            switch (choiceCatalog){
                case 1:
                    ProductManagement.inputListCatalog(sc);
                    break;
                case 2:
                    ProductManagement.displayListCatalog();
                    break;
                case 3:
                    ProductManagement.updateCatalog(sc);
                    break;
                case 4:
                    exitMenuCatalog = false;
                    break;
                default:
                    System.err.println("Vui long chon tu 1-4");
            }
        }while(exitMenuCatalog);
    }

    public static void menuProduct(Scanner sc){
        boolean exitMenuProduct = true;
        do {
            System.out.println("***************QUAN LY SAN PHAM**************");
            System.out.println("1. Nhap thong tin san pham");
            System.out.println("2. Tinh gia ban cho cac san pham");
            System.out.println("3. Hien thi thong tin san pham");
            System.out.println("4. Sap xep san pham theo gia ban tang dan");
            System.out.println("5. Tim kiem san pham theo ten san pham");
            System.out.println("6. Thong ke so luong va in thong tin san pham het hang");
            System.out.println("7. Cap nhat trang thai san pham theo ma san pham");
            System.out.println("8. Ban hang");
            System.out.println("9. Nhap hang");
            System.out.println("10. Thoat");
            System.out.print("Lua chon cua ban:");
            int choiceProduct = Integer.parseInt(sc.nextLine());
            switch (choiceProduct){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    exitMenuProduct = false;
                    break;
                default:
                    System.err.println("Vui long nhap tu 1-10");
            }
        }while (exitMenuProduct);
    }

    public static void inputListCatalog(Scanner sc){
        System.out.println("Nhap so danh muc can nhap thong tin: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            arrCatalog[indexCatalog] = new Catalog();
            arrCatalog[indexCatalog].inputData(sc);
            indexCatalog++;
        }
    }
    public static void displayListCatalog(){
        //Hien thi danh muc theo do uu tien
        //1. Sap xep danh muc theo do uu tien tang dan
        for (int i = 0; i < indexCatalog-1; i++) {
            for (int j = i+1; j <indexCatalog ; j++) {
                if (arrCatalog[i].getPriority()>arrCatalog[j].getPriority()){
                    Catalog temp = arrCatalog[i];
                    arrCatalog[i] = arrCatalog[j];
                    arrCatalog[j] = temp;
                }
            }
        }
        //2. Hien thi danh muc
        for (int i = 0; i < indexCatalog; i++) {
            arrCatalog[i].displayData();
        }
    }
    public static void updateCatalog(Scanner sc){
        System.out.println("Nhap vao ma danh muc can cap nhat thong tin: ");
        int catalogIdUpdate = Integer.parseInt(sc.nextLine());
        //1. Tim trong danh sach danh muc can cap nhat
        int indexCatalogUpdate = -1;
        for (int i = 0; i < indexCatalog; i++) {
            if (arrCatalog[i].getCatalogId()==catalogIdUpdate){
                indexCatalogUpdate = i;
                break;
            }
        }
        if (indexCatalogUpdate!=-1){
            //2. Cap nhat danh muc theo ma
            System.out.println("Nhap vao ten danh muc can cap nhat: ");
            String catalogName = sc.nextLine();
            if (catalogName!=""&&catalogName.length()!=0){
                arrCatalog[indexCatalogUpdate].setCatalogName(catalogName);
            }
            System.out.println("Nhap vao do uu tien cua danh muc: ");
            String priority = sc.nextLine();
            if (priority!=""&&priority.length()!=0){
                arrCatalog[indexCatalogUpdate].setPriority(Integer.parseInt(priority));
            }
            System.out.println("Nhap vao trang thai danh muc: ");
            String status = sc.nextLine();
            if (status!=""&&status.length()!=0){
                arrCatalog[indexCatalogUpdate].setCatalogStatus(Boolean.parseBoolean(status));
            }
        }else{
            System.err.println("Ma danh muc khong ton tai");
        }
    }
}
