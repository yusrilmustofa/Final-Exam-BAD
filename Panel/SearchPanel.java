package Panel;

import javax.swing.*;

import Product.ProductList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {
    private JTextField searchField;
    private ProductList productListPanel;

    public SearchPanel(ProductList productListPanel) {
        this.productListPanel = productListPanel;
        setLayout(new FlowLayout());

        searchField = new JTextField(20);
        JButton searchButton = new JButton("Cari");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText().toLowerCase();
                productListPanel.filterProducts(query);
            }
        });

        add(new JLabel("Cari Produk:"));
        add(searchField);
        add(searchButton);
    }
}
