import java.util.*;
class Product {
    String pname;
    String pid;
    int price;
    Product(String pname, String pid, int price) {
        this.pname = pname;
        this.pid = pid;
        this.price = price;
    }
    public String toString() {
        return "Product Name: " + pname + ", Product Id: " + pid + ", Price(in k): " + price;
    }
}
public class ProductList {
    public static List<Product> pl = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    static void addProduct() {
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String pname = sc.nextLine();
        System.out.print("Enter Product ID: ");
        String pid;
        pid=sc.nextLine();
        System.out.print("Enter Price (in K): ");
        int price = sc.nextInt();
        Product p = new Product(pname, pid, price);
        pl.add(p);
        System.out.println("Product added successfully!");
    }
    static void printProducts() {
        if (pl.isEmpty()) {
            System.out.println("ProductList is empty.");
        } else {
            pl.sort(Comparator.comparing(p -> p.price));
            System.out.println("Products:");
            for (Product p : pl) {
                System.out.println(p);
            }
        }
    }
    static void deleteProduct() {
        sc.nextLine();
        System.out.print("Enter Product ID to delete: ");
        String pid = sc.nextLine();
        boolean removed = pl.removeIf(Product -> Product.pid.equals(pid));
        if (removed) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }
    static void searchProduct() {
        sc.nextLine();
        System.out.print("Enter Product ID to search: ");
        String pid = sc.nextLine();
        boolean found = false;
        for (Product p : pl) {
            if (p.pid.equals(pid)) {
                System.out.println("Found: " + p);
                found = true;
            }
        }
        if (!found)
            System.out.println("Product not found.");
    }
    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\nPhoneProduct Menu:");
            System.out.println("1. Add Product\n2. Delete Product\n3. Print Products\n4. Search Product\n0. Exit\n");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:addProduct();
						break;
                case 2:deleteProduct();
						break;
                case 3:printProducts();
						break;
                case 4:searchProduct();
						break;
                case 0:System.out.println("Exiting ProductList.");
						break;
                default:System.out.println("Invalid Choice. Try again.");
            }
        } while (ch != 0);
    }
}