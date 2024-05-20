package dev.kei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private final Font textAreaFont;
    private ImageIcon imageIcon;



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
    }
}