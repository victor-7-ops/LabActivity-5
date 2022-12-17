package FoodOrdering;

import SimpleCalc.SimpleCalcGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class FoodOrderGUI extends JFrame {
    private JPanel pnlMain;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    public static void main(String[] args) {
        FoodOrderGUI app = new FoodOrderGUI();
        app.setContentPane(app.pnlMain);
        app.setTitle("Food Ordering System");
        app.setSize(768, 768);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public FoodOrderGUI() {
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbNone);
        bg.add(rb5);
        bg.add(rb10);
        bg.add(rb15);
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                if (cPizza.isSelected())
                    total += 100;
                if (cBurger.isSelected())
                    total += 80;
                if (cFries.isSelected())
                    total += 65;
                if (cSoftDrinks.isSelected())
                    total += 55;
                if (cTea.isSelected())
                    total += 50;
                if (cSundae.isSelected())
                    total += 40;

                if (rb5.isSelected())
                    total -= total * .05;
                else if (rb10.isSelected())
                    total -= total * .10;
                else if (rb15.isSelected())
                    total -= total * .15;

                String amount = String.format("%.02f", total);
                JOptionPane.showMessageDialog(btnOrder, "The total price is Php " + amount);
            }
        });
    }
}
