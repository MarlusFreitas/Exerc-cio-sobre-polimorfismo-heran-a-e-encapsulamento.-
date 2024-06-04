import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;
import entities.ImportedProduct;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int totalProducts = sc.nextInt();
        for(int i = 1; i <= totalProducts; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)?");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if(ch == 'i'){
                System.out.print("Custom fee: ");
                Double customFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customFee));
            } else if (ch == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, date));
            } else if(ch == 'c'){
                list.add(new Product(name, price));
            } else {
                System.out.println("Tipo de produto invalido!");
            }
        }

        System.out.println("PRICE TAGS:");
        for (Product product : list) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}
