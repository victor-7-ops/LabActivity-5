package LeapYear;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class LeapYearGUI extends JFrame{
    private JPanel pnlMain;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI() {
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = Integer.parseInt(tfYear.getText());
                String message = "";

                try {
                    if (input == 0)
                        throw new zeroError();
                    else if (input < 0)
                        throw new less_zeroError();
                    else {
                        boolean leap_year = false;
                        if (input % 4 == 0) {
                            if (input % 100 == 0) {
                                if (input % 400 == 0) {
                                    leap_year = true;
                                } else {
                                    leap_year = false;
                                }
                            } else {
                                leap_year = true;
                            }
                        }
                        if (leap_year)
                            message = "Leap year";
                        else
                            message = "Not a leap year";
                    }
                } catch (zeroError ze) {
                    message = "Input must be a non-zero integer";
                } catch (less_zeroError lze) {
                    message = "Input must not be less than zero";
                }
                JOptionPane.showMessageDialog(btnCheckYear, message);
            }
        });
    }
    public static void main(String[] args) {
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.pnlMain);
        app.setTitle("Leap Year Checker");
        app.setSize(500, 250);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public class zeroError extends Throwable {
        public zeroError() {}
    }

    public class less_zeroError extends Throwable {
        public less_zeroError() {}
    }
}

