package dev.kei;

/**
 * Java Simple Calculator
 * Author: Arkar Min
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            UI ui = new UI();
            ui.init();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
