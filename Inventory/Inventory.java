package Inventory;

import java.util.ArrayList;
import java.util.List;

import Product.Product;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int index, Product product) {
        products.set(index, product);
    }

    public void deleteProduct(int index) {
        products.remove(index);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String generateMonthlyReport() {
        StringBuilder report = new StringBuilder();
        report.append("Laporan Inventaris Bulanan\n\n");
        for (Product product : products) {
            report.append(product.toString()).append("\n");
        }
        return report.toString();
    }
}
