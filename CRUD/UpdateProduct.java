package Exam5.CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Exam5.Inventory.Inventory;
import Exam5.Panel.ProductPanel;
import Exam5.Product.Product;
import Exam5.Product.ProductList;

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

            Product updatedProduct = new Product(name, desc, price, stock);
            inventoryManager.updateProduct(selectedIndex, updatedProduct); 
            productListPanel.updateProduct(selectedIndex, updatedProduct);
        } else {
            JOptionPane.showMessageDialog(productPanel, "Pilih produk untuk diperbarui.");
        }
    }
}
