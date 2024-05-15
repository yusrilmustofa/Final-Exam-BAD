package Product;

import javax.swing.*;

import Inventory.Inventory;

import java.awt.*;

public class ProductList extends JList<Product> {
    private DefaultListModel<Product> productListModel;
    private Inventory inventoryManager;

    public ProductList(Inventory inventoryManager) {
        this.inventoryManager = inventoryManager;
        productListModel = new DefaultListModel<>();
        setModel(productListModel);
        setCellRenderer(new ProductCellRenderer());
        loadProducts();
    }

    private void loadProducts() {
        for (Product product : inventoryManager.getProducts()) {
            productListModel.addElement(product);
        }
    }

    public void addProduct(Product product) {
        productListModel.addElement(product);
    }

    public void updateProduct(int index, Product product) {
        productListModel.set(index, product);
    }

    public void deleteProduct(int index) {
        productListModel.remove(index);
    }

    public Product getProduct(int index) {
        return productListModel.get(index);
    }

    public int getSelectedProductIndex() {
        return getSelectedIndex();
    }

    // Custom renderer class for displaying product details
    private static class ProductCellRenderer extends JLabel implements ListCellRenderer<Product> {
        @Override
        public Component getListCellRendererComponent(JList<? extends Product> list, Product value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(String.format("Nama: %s, Stok: %d, Harga:Rp. %.2f , Deskripsi: %s", value.getName(), value.getStock(), value.getPrice(),value.getDesc()));
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setOpaque(true);
            return this;
        }
    }
    public void filterProducts(String query) {
        DefaultListModel<Product> filteredModel = new DefaultListModel<>();
        for (int i = 0; i < productListModel.size(); i++) {
            Product product = productListModel.elementAt(i);
            if (product.getName().toLowerCase().contains(query) || product.getDesc().toLowerCase().contains(query)) {
                filteredModel.addElement(product);
            }
        }
        setModel(filteredModel);
    }
    
}
