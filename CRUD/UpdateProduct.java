package CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Inventory.Inventory;
import Panel.ProductPanel;
import Product.Product;
import Product.ProductList;

public class UpdateProduct implements ActionListener {
    private ProductPanel productPanel;
    private Inventory inventoryManager;

    public UpdateProduct(ProductPanel productPanel, Inventory inventoryManager) {
        this.productPanel = productPanel;
        this.inventoryManager = inventoryManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProductList productListPanel = productPanel.getProductListPanel();
        int selectedIndex = productListPanel.getSelectedProductIndex();
        if (selectedIndex != -1) {
            String name = productPanel.getNameField();
            String desc = productPanel.getDescField();
            double price = productPanel.getPriceField();
            int stock = productPanel.getStockField();

            // Perbarui produk yang ada dengan data baru
            Product updatedProduct = new Product(name, desc, price, stock);
            inventoryManager.updateProduct(selectedIndex, updatedProduct); 
            productListPanel.updateProduct(selectedIndex, updatedProduct);
        } else {
            JOptionPane.showMessageDialog(productPanel, "Pilih produk untuk diperbarui.");
        }
    }
}
