package dev.kei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener {
    private final JTextField textField;
    private double firstNumber = 0;
    private String operator = "";
    private final Calculator calculator = new Calculator(UI.this);

    public UI() {
        setTitle("Arkar Min's Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        textField = new JTextField(20);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        panel.add(textField, gbc);

        String[] buttonValues = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};
        JButton[] buttons = new JButton[buttonValues.length];
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[index] = new JButton(buttonValues[index]);
                Font buttonFont = new Font("Arial", Font.PLAIN, 18);
                buttons[index].setFont(buttonFont);
                gbc.gridx = j;
                gbc.gridy = i + 1;
                panel.add(buttons[index], gbc);
                buttons[index].addActionListener(this);
                index++;
            }
        }

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();

        switch (command) {
            case "C":
                textField.setText("");
                firstNumber = 0;
                operator = "";
                break;
            case "=":
                if (!operator.isEmpty() && !textField.getText().isEmpty()) {
                    double secondNumber = Double.parseDouble(textField.getText());
                    double result = calculator.calculateResult(firstNumber, secondNumber, operator);
                    textField.setText(String.valueOf(result));
                    operator = "";
                }
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (!textField.getText().isEmpty()) {
                    firstNumber = Double.parseDouble(textField.getText());
                    operator = command;
                    textField.setText("");
                }
                break;
            default:
                textField.setText(textField.getText() + command);
                break;
        }
    }
}
