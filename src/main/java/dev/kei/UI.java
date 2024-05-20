package dev.kei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UI implements ActionListener {
    // initialization fields
    private final JFrame frame;
    private final JPanel panel;
    private final JPanel subPanel1, subPanel2, subPanel3, subPanel4,
            subPanel5, subPanel6, subPanel7, subPanel8;
    private final JTextArea textArea;
    private final JButton[] buttons;
    private final JButton butAdd, butMinus, butMultiply, butDivide,
            butEqual, butCancel, butSquareRoot, butSquare, butOneDividedBy, butCos, butSin, butTan,
            butxpowerofy, butlog, butrate, butabs, butBinary, butln;
    private final String[] buttonValues = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private final Font font;
    private final Font textFont;
    private final ImageIcon imageIcon;
    private final Calculator calculator;

    // constructor
    public UI() throws IOException {
        frame = new JFrame("Calculator by Arkar Min");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        subPanel1 = new JPanel(new FlowLayout());
        subPanel2 = new JPanel(new FlowLayout());
        subPanel3 = new JPanel(new FlowLayout());
        subPanel4 = new JPanel(new FlowLayout());
        subPanel5 = new JPanel(new FlowLayout());
        subPanel6 = new JPanel(new FlowLayout());
        subPanel7 = new JPanel(new FlowLayout());
        subPanel8 = new JPanel(new FlowLayout());

        BufferedImageCustom imageCustom = new BufferedImageCustom();
        imageIcon = new ImageIcon(imageCustom.imageReturn());

        font = new Font("Consolas", Font.PLAIN, 18);
        textArea = new JTextArea(1, 20);
        textFont = new Font("Consolas", Font.BOLD, 24);

        buttons = new JButton[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonValues[i]);
        }

        butAdd = new JButton("+");
        butMinus = new JButton("-");
        butMultiply = new JButton("*");
        butDivide = new JButton("/");
        butEqual = new JButton("=");
        butCancel = new JButton("C");
        butSquareRoot = new JButton("√");
        butSquare = new JButton("x²");
        butOneDividedBy = new JButton("1/x");
        butCos = new JButton("cos");
        butSin = new JButton("sin");
        butTan = new JButton("tan");
        butxpowerofy = new JButton("x^y");
        butlog = new JButton("log");
        butrate = new JButton("%");
        butabs = new JButton("abs");
        butBinary = new JButton("bin");
        butln = new JButton("ln");

        calculator = new Calculator();
    }

    public void init() {
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(imageIcon.getImage());

        textArea.setFont(textFont);
        textArea.setEditable(false);

        for (int i = 0 ; i < 10 ; i++) {
            buttons[i].setFont(font);
        }

        butAdd.setFont(font);
        butMinus.setFont(font);
        butMultiply.setFont(font);
        butDivide.setFont(font);
        butEqual.setFont(font);
        butCancel.setFont(font);
        butSquareRoot.setFont(font);
        butSquare.setFont(font);
        butOneDividedBy.setFont(font);
        butCos.setFont(font);
        butSin.setFont(font);
        butTan.setFont(font);
        butxpowerofy.setFont(font);
        butlog.setFont(font);
        butrate.setFont(font);
        butabs.setFont(font);
        butBinary.setFont(font);
        butln.setFont(font);

        panel.add(Box.createHorizontalStrut(10));
        subPanel1.add(textArea);
        panel.add(subPanel1);

        subPanel2.add(buttons[1]);
        subPanel2.add(buttons[2]);
        subPanel2.add(buttons[3]);
        subPanel3.add(Box.createHorizontalStrut(15));
        subPanel2.add(butAdd);
        subPanel2.add(butMinus);
        subPanel2.add(butMultiply);
        panel.add(subPanel2);

        subPanel3.add(buttons[4]);
        subPanel3.add(buttons[5]);
        subPanel3.add(buttons[6]);
        subPanel3.add(Box.createHorizontalStrut(15));
        subPanel3.add(butMultiply);
        subPanel3.add(butDivide);
        panel.add(subPanel3);

        subPanel4.add(buttons[7]);
        subPanel4.add(buttons[8]);
        subPanel4.add(buttons[9]);
        subPanel4.add(Box.createHorizontalStrut(15));
        subPanel4.add(butEqual);
        subPanel4.add(butCancel);
        panel.add(subPanel4);

        subPanel5.add(Box.createHorizontalStrut(15));
        subPanel5.add(buttons[0]);
        subPanel5.add(butln);
        subPanel5.add(Box.createHorizontalStrut(210));
        panel.add(subPanel5);

        subPanel6.add(butSquare);
        subPanel6.add(butSquareRoot);
        subPanel6.add(butOneDividedBy);
        subPanel6.add(butxpowerofy);
        panel.add(subPanel6);

        subPanel7.add(butCos);
        subPanel7.add(butSin);
        subPanel7.add(butTan);
        panel.add(subPanel7);

        subPanel8.add(butlog);
        subPanel8.add(butrate);
        subPanel8.add(butBinary);
        panel.add(subPanel8);

        for (int i = 0; i < 10 ; i++) {
            buttons[i].addActionListener(this);
        }

        butAdd.addActionListener(this);
        butMinus.addActionListener(this);
        butMultiply.addActionListener(this);
        butDivide.addActionListener(this);
        butEqual.addActionListener(this);
        butCancel.addActionListener(this);
        butSquareRoot.addActionListener(this);
        butSquare.addActionListener(this);
        butOneDividedBy.addActionListener(this);
        butCos.addActionListener(this);
        butSin.addActionListener(this);
        butTan.addActionListener(this);
        butxpowerofy.addActionListener(this);
        butlog.addActionListener(this);
        butrate.addActionListener(this);
        butabs.addActionListener(this);
        butBinary.addActionListener(this);
        butln.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        Double checkNum = null;

        for (int i = 0 ; i < 10 ; i ++) {
            if (source == buttons[i]) {
                textArea.replaceSelection(buttonValues[i]);
                return;
            }
        }

        try {
            checkNum = Double.parseDouble(textArea.getText());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        if (checkNum != null || source == butCancel) {
            if (source == butAdd) {
                writer(calculator.calculateBi(Calculator.BiOperationMethods.ADD, reader()));
                textArea.replaceSelection(butAdd.getText());
            }

            if (source == butMinus) {
                writer(calculator.calculateBi(Calculator.BiOperationMethods.MINUS, reader()));
                textArea.replaceSelection(butMinus.getText());
            }

            if (source == butMultiply) {
                writer(calculator.calculateBi(Calculator.BiOperationMethods.MULTIPLY, reader()));
                textArea.replaceSelection(butMultiply.getText());
            }

            if (source == butDivide) {
                writer(calculator.calculateBi(Calculator.BiOperationMethods.DIVIDE, reader()));
                textArea.replaceSelection(butDivide.getText());
            }

            if (source == butxpowerofy) {
                writer(calculator.calculateBi(Calculator.BiOperationMethods.X_POWER_OF_Y, reader()));
                textArea.replaceSelection(butxpowerofy.getText());
            }

            if (source == butSquare) {
                writer(calculator.calculateMono(Calculator.MonoOperationMethods.SQUARE, reader()));
            }

            if (source == butSquareRoot) {
                writer(calculator.calculateMono(Calculator.MonoOperationMethods.SQUARE_ROOT, reader()));
            }

            if (source == butOneDividedBy) {
                writer(calculator.calculateMono(Calculator.MonoOperationMethods.ONE_DIVIDED_BY, reader()));
            }

            if (source == butCos) {
                writer(calculator.calculateMono(Calculator.MonoOperationMethods.COS, reader()));
            }

            if (source == butSin) {
                writer(calculator.calculateMono(Calculator.MonoOperationMethods.SIN, reader()));
            }

            if (source == butTan) {
                writer(calculator.calculateMono(Calculator.MonoOperationMethods.TAN, reader()));
            }

            if (source == butlog) {
                writer(calculator.calculateMono(Calculator.MonoOperationMethods.LOG, reader()));
            }

            if (source == butrate) {
                writer(calculator.calculateMono(Calculator.MonoOperationMethods.RATE, reader()));
            }

            if (source == butabs) {
                writer(calculator.calculateMono(Calculator.MonoOperationMethods.ABS, reader()));
            }

            if (source == butBinary) {
                parseToBinary();
            }

            if (source == butEqual) {
                writer(calculator.calculateEqual(reader()));
            }

            if (source == butCancel) {
                writer(calculator.reset());
            }
        }
        textArea.selectAll();
    }

    private void parseToBinary() {
        try {
            textArea.setText("" + Long.toBinaryString(Long.parseLong(textArea.getText())));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    public Double reader() {
        double num;
        String str;
        str = textArea.getText();
        num = Double.parseDouble(str);
        return num;
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            textArea.setText("");
        } else {
            textArea.setText(Double.toString(num));
        }
    }
}
