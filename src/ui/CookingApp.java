/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author jhona
 */
import context.CookingContext;
import strategy.BoilingStrategy;
import strategy.FryingStrategy;
import strategy.GrillingStrategy;

import javax.swing.*;
import java.awt.*;

public class CookingApp extends JFrame {
    private final CookingContext cookingContext;
    private final DefaultListModel<String> preparationLog;

    public CookingApp() {
        cookingContext = new CookingContext();
        preparationLog = new DefaultListModel<>();

        setTitle("Métodos de Cocción");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior: Selección de platillo
        JPanel dishPanel = new JPanel();
        dishPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        dishPanel.setBackground(new Color(255, 228, 196));

        JLabel dishLabel = new JLabel("Selecciona un platillo:");
        dishLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dishPanel.add(dishLabel);

        String[] dishes = {"Huevo", "Pescado", "Pollo"};
        JComboBox<String> dishComboBox = new JComboBox<>(dishes);
        dishComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        dishPanel.add(dishComboBox);

        add(dishPanel, BorderLayout.NORTH);

        // Panel central: Botones de estrategia
        JPanel strategyPanel = new JPanel();
        strategyPanel.setLayout(new GridLayout(1, 3, 20, 20));
        strategyPanel.setBackground(new Color(240, 255, 240));
        strategyPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton boilButton = new JButton("Hervir");
        boilButton.setFont(new Font("Arial", Font.BOLD, 14));
        boilButton.setBackground(new Color(173, 216, 230));
        boilButton.setFocusPainted(false);

        JButton fryButton = new JButton("Freír");
        fryButton.setFont(new Font("Arial", Font.BOLD, 14));
        fryButton.setBackground(new Color(255, 182, 193));
        fryButton.setFocusPainted(false);

        JButton grillButton = new JButton("Asar");
        grillButton.setFont(new Font("Arial", Font.BOLD, 14));
        grillButton.setBackground(new Color(144, 238, 144));
        grillButton.setFocusPainted(false);

        strategyPanel.add(boilButton);
        strategyPanel.add(fryButton);
        strategyPanel.add(grillButton);

        add(strategyPanel, BorderLayout.CENTER);

        // Panel inferior derecho: Área de registro de preparaciones
        JPanel logPanel = new JPanel();
        logPanel.setLayout(new BorderLayout());
        logPanel.setBorder(BorderFactory.createTitledBorder("Registro de Preparaciones"));

        JList<String> logList = new JList<>(preparationLog);
        logList.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(logList);
        scrollPane.setPreferredSize(new Dimension(300, 400));

        logPanel.add(scrollPane, BorderLayout.CENTER);
        add(logPanel, BorderLayout.EAST);

        // Panel inferior: Cocinar
        JPanel cookPanel = new JPanel();
        cookPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        cookPanel.setBackground(new Color(255, 248, 220));

        JButton cookButton = new JButton("Cocinar");
        cookButton.setFont(new Font("Arial", Font.BOLD, 16));
        cookButton.setBackground(new Color(255, 222, 173));
        cookButton.setFocusPainted(false);

        cookPanel.add(cookButton);
        add(cookPanel, BorderLayout.SOUTH);

        // Lógica de selección de estrategia
        boilButton.addActionListener(e -> cookingContext.setStrategy(new BoilingStrategy()));
        fryButton.addActionListener(e -> cookingContext.setStrategy(new FryingStrategy()));
        grillButton.addActionListener(e -> cookingContext.setStrategy(new GrillingStrategy()));

        // Lógica de botón de cocinar
        cookButton.addActionListener(e -> {
            String selectedDish = (String) dishComboBox.getSelectedItem();
            String result = cookingContext.cook(selectedDish);
            preparationLog.addElement(result);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CookingApp app = new CookingApp();
            app.setVisible(true);
        });
    }
}
