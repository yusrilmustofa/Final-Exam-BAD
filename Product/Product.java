package Exam5.Product;

public class Product {
    private String name;
    private String desc;
    private double price;
    private int stock;

    public Product(String name, String desc, double price, int stock) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - $%.2f - Stock: %d", name, desc, price, stock);
    }
}
