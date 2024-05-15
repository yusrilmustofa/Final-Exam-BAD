package Exam5.CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Exam5.Inventory.Inventory;
import Exam5.Panel.ProductPanel;
import Exam5.Product.ProductList;

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
