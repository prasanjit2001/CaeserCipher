/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caesarciphergui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CaesarCipherGUI extends JFrame {

   private JTextField inputField;
    private JTextField outputField;
    private JButton encryptButton;
    private JButton decryptButton;
     public static String encrypt(String plaintext, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encryptedText.append((char) ((c - base + shift) % 26 + base));
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }
     public static String decrypt(String ciphertext, int shift) {
        return encrypt(ciphertext, 26 - shift);
    }
    
     public CaesarCipherGUI() {
        // Initialize GUI components and layout

        inputField = new JTextField(20);
        outputField = new JTextField(20);
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");
         setVisible(true);

        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int shift =  Integer.parseInt(JOptionPane.showInputDialog("Enter Shift Value:"));
                String inputText = inputField.getText();
                String encryptedText = CaesarCipherGUI.encrypt(inputText, shift);
                outputField.setText(encryptedText);
                 setVisible(true);
            }
        });
          decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int shift =  Integer.parseInt(JOptionPane.showInputDialog("Enter Shift Value:"));
                String inputText = inputField.getText();
                String decryptedText = CaesarCipherGUI.decrypt(inputText, shift);
                outputField.setText(decryptedText);
                 setVisible(true);
            }
        });
            JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Input Text:"));
        panel.add(inputField);
        panel.add(new JLabel("Output Text:"));
        panel.add(outputField);
        panel.add(encryptButton);
        panel.add(decryptButton);

        // Add the panel to the frame
        add(panel);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setTitle("Caesar Cipher");
        setVisible(true);
    }

    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> new CaesarCipherGUI());
    }
    
}
