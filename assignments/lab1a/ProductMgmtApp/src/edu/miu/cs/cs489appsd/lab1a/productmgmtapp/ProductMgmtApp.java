package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55),
                new Product(2927458265L, "Apple", "2022-12-09", 18, 1.09),
                new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99)
        };

        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparingDouble(Product::getUnitPrice).reversed());

        // Print Products in JSON format
        System.out.println("JSON Format:");
        System.out.println("[");
        for (int i = 0; i < products.length; i++) {
            Product p = products[i];
            System.out.printf(
                    "  {\"productId\": %d, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f}%s%n",
                    p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice(),
                    (i == products.length - 1) ? "" : ","
            );
        }
        System.out.println("]");

        // Print Products in XML format
        System.out.println("\nXML Format:");
        System.out.println("<products>");
        for (Product p : products) {
            System.out.printf(
                    "  <product productId=\"%d\" name=\"%s\" dateSupplied=\"%s\" quantityInStock=\"%d\" unitPrice=\"%.2f\" />%n",
                    p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()
            );
        }
        System.out.println("</products>");

        // Print Products in CSV format
        System.out.println("\nCSV Format:");
        System.out.println("productId, name, dateSupplied, quantityInStock, unitPrice");
        for (Product p : products) {
            System.out.printf(
                    "%d, %s, %s, %d, %.2f%n",
                    p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()
            );
        }
    }
}
