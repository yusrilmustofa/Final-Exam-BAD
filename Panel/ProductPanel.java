package Exam5.Panel;

import javax.swing.*;

import Exam5.CRUD.AddProduct;
import Exam5.CRUD.DeleteProduct;
import Exam5.CRUD.UpdateProduct;
import Exam5.Inventory.Inventory;
import Exam5.Product.ProductList;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class ProductPanel extends JPanel {
    private JTextField nameField;
    private JTextField descField;
    private JTextField priceField;
    private JTextField stockField;
    private Inventory inventoryManager;
    private ProductList productListPanel;

    public ProductPanel(Inventory inventoryManager, ProductList productListPanel) {
        this.inventoryManager = inventoryManager;
        this.productListPanel = productListPanel;
        setLayout(new GridLayout(6, 2));

        nameField = new JTextField(20);
        descField = new JTextField(20);
        priceField = new JTextField(20);
        stockField = new JTextField(20);

        add(new JLabel("Nama Produk:"));
        add(nameField);
        add(new JLabel("Deskripsi:"));
        add(descField);
        add(new JLabel("Harga:"));
        add(priceField);
        add(new JLabel("Jumlah Stok:"));
        add(stockField);

        JButton addButton = new JButton("Tambah Produk");
        addButton.addActionListener(new AddProduct(this, inventoryManager));
        add(addButton);

        JButton updateButton = new JButton("Perbarui Produk");
        updateButton.addActionListener(new UpdateProduct(this, inventoryManager));
        add(updateButton);

        JButton deleteButton = new JButton("Hapus Produk");
        deleteButton.addActionListener(new DeleteProduct(this, inventoryManager));
        add(deleteButton);
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getDescField() {
        return descField.getText();
    }

    public double getPriceField() {
        double price = 0;
        try {
            price = Double.parseDouble(priceField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harga tidak valid.");
        }
        return price;
    }

    public int getStockField() {
        int stock = 0;
        try {
            stock = Integer.parseInt(stockField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Stok tidak valid.");
        }
        return stock;
    }

    public void clearFields() {
        nameField.setText("");
        descField.setText("");
        priceField.setText("");
        stockField.setText("");
    }

    public ProductList getProductListPanel() {
        return productListPanel;
    }

    public void setPriceField(double price) {
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        priceField.setText(rupiahFormat.format(price));
    }
}
