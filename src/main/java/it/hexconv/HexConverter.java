package it.hexconv;


import javax.swing.*;
import java.awt.*;

public class HexConverter extends JFrame {
    private JTextField inputField;
    private JTextField outputField;
    private JButton convert;
    private JButton cleanButton;

    public HexConverter() {
        setTitle("HexConverter - ®BSiragusa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(HexConverter.class.getResource("/bear.png"));
        setIconImage(icon.getImage());

        inputField = new JTextField();
        outputField = new JTextField();
        convert = new JButton("Convert");
        cleanButton = new JButton("Clean");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(new JLabel("Input (hex or string):"));
        panel.add(inputField);
        panel.add(new JLabel("Output (string or hex):"));
        panel.add(outputField);
        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.add(convert);
        buttonPanel.add(cleanButton);
        convert.addActionListener(e -> convertToString());
        cleanButton.addActionListener(e -> clean());

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    private void convertToString() {
        String input = inputField.getText();
        try {
            if (input.matches("[0-9A-Fa-f]+")) {
                // Se l'input è esadecimale, converti in testo
                outputField.setText(hexToString(input));
            } else {
                // Se l'input è testo, converti in esadecimale
                outputField.setText(stringToHex(input));
            }
        } catch (NumberFormatException ex) {
            outputField.setText("Formato esadecimale non valido!");
        }
    }



    private void clean() {
        inputField.setText("");
        outputField.setText("");

    }
    private String hexToString(String hex) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            result.append((char) Integer.parseInt(str, 16));
        }
        return result.toString();
    }



    private String stringToHex(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            result.append(String.format("%02X", (int) ch));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HexConverter().setVisible(true));
    }
}