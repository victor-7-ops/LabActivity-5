package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI extends JFrame {
    private JPanel pnlMain;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;

    public static void main(String[] args) {
        SimpleCalcGUI app = new SimpleCalcGUI();
        app.setContentPane(app.pnlMain);
        app.setTitle("Simple Calculator");
        app.setSize(768, 400);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public SimpleCalcGUI() {
        cbOperations.addItem("+");
        cbOperations.addItem("-");
        cbOperations.addItem("*");
        cbOperations.addItem("/");

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(tfNumber1.getText()), num2 = Integer.parseInt(tfNumber2.getText());
                int result = 0;
                String op = (String)cbOperations.getSelectedItem();
                switch (op) {
                    case "+" :
                        result = num1 + num2;
                        break;
                    case "-" :
                        result = num1 - num2;
                        break;
                    case "*" :
                        result = num1 * num2;
                        break;
                    case "/" :
                        try {
                            result = num1 / num2;
                        } catch (ArithmeticException ae) {
                            JOptionPane.showMessageDialog(btnCompute, "Cannot divide by zero");
                        }
                        break;
                }
                lblResult.setText(String.valueOf(result));
            }
        });
    }
}
