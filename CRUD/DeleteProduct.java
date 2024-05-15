package CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Inventory.Inventory;
import Panel.ProductPanel;
import Product.ProductList;

public class DeleteProduct implements ActionListener {
    private ProductPanel productPanel;
    private Inventory inventoryManager;

    public DeleteProduct(ProductPanel productPanel, Inventory inventoryManager) {
        this.productPanel = productPanel;
        this.inventoryManager = inventoryManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProductList productListPanel = productPanel.getProductListPanel();
        int selectedIndex = productListPanel.getSelectedProductIndex();
        if (selectedIndex != -1) {
            productListPanel.deleteProduct(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(productPanel, "Pilih produk untuk dihapus.");
        }
    }
}
