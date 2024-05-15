package CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Inventory.Inventory;
import Panel.ProductPanel;
import Product.Product;

public class AddProduct implements ActionListener {
    private ProductPanel productPanel;
    private Inventory inventoryManager;

    public AddProduct(ProductPanel productPanel, Inventory inventoryManager) {
        this.productPanel = productPanel;
        this.inventoryManager = inventoryManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = productPanel.getNameField();
        String desc = productPanel.getDescField();
        double price = productPanel.getPriceField();
        int stock = productPanel.getStockField();

        Product newProduct = new Product(name, desc, price, stock);
        inventoryManager.addProduct(newProduct); // Menambahkan produk baru ke InventoryManager
        productPanel.getProductListPanel().addProduct(newProduct); // Menambahkan produk baru ke panel daftar produk
        productPanel.clearFields(); // Menghapus nilai field setelah menambahkan produk baru
    }
}
