package dev.kei;

import javax.swing.*;

/**
 * Java Simple Calculator
 * Author: Arkar Min
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            SwingUtilities.invokeLater(UI::new);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
