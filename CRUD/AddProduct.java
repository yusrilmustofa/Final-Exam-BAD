package Exam5.CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Exam5.Inventory.Inventory;
import Exam5.Panel.ProductPanel;
import Exam5.Product.Product;

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

        Product product = new Product(name, desc, price, stock);
        inventoryManager.addProduct(product);
        productPanel.getProductListPanel().addProduct(product); 
        productPanel.clearFields();
    }
}
