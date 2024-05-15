package Exam5.Panel;

import javax.swing.*;

import Exam5.Inventory.Inventory;
import Exam5.Product.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

public class ReportPanel extends JPanel {
    private Inventory inventoryManager;

    public ReportPanel(Inventory inventoryManager) {
        this.inventoryManager = inventoryManager;
        setLayout(new BorderLayout());

        JTextArea reportArea = new JTextArea(20, 40);
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton generateButton = new JButton("Generate Laporan");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder reportBuilder = new StringBuilder();
                reportBuilder.append("Laporan Inventaris Bulanan\n\n");
                reportBuilder.append(String.format("%-20s%-20s%-20s\n", "Nama Produk", "Jumlah Stock", "Harga (Rp)"));
                reportBuilder.append("------------------------------------------------------------\n");

                for (Product product : inventoryManager.getProducts()) {
                    reportBuilder.append(String.format("%-20s%-20d%-20s\n", product.getName(), product.getStock(), formatToRupiah(product.getPrice())));
                }

                reportArea.setText(reportBuilder.toString());
            }
        });
        add(generateButton, BorderLayout.SOUTH);
    }

    private String formatToRupiah(double price) {
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return rupiahFormat.format(price);
    }
}
