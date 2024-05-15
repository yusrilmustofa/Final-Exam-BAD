package Exam5.main;

import javax.swing.*;

import Exam5.Inventory.Inventory;
import Exam5.Panel.ProductPanel;
import Exam5.Panel.ReportPanel;
import Exam5.Panel.SearchPanel;
import Exam5.Product.ProductList;

import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Inventory Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            Inventory inventoryManager = new Inventory();

            ProductList productListPanel = new ProductList(inventoryManager);
            frame.add(new JScrollPane(productListPanel), BorderLayout.CENTER);

            ProductPanel productPanel = new ProductPanel(inventoryManager, productListPanel);
            frame.add(productPanel, BorderLayout.SOUTH);

            SearchPanel searchPanel = new SearchPanel(productListPanel);
            frame.add(searchPanel, BorderLayout.NORTH);

            ReportPanel reportPanel = new ReportPanel(inventoryManager);
            frame.add(reportPanel, BorderLayout.WEST);
 
            JButton exitButton = new JButton("Keluar");
            exitButton.addActionListener(e -> System.exit(0));
            frame.add(exitButton, BorderLayout.EAST);

            frame.setVisible(true);
        });
    }
}
