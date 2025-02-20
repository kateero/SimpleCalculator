package simplecalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI {

    public CalculatorGUI() {

        JFrame frame = new JFrame("Simple calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 4));
        JTextField a = new JTextField(10);
        JTextField b = new JTextField(10);
        JTextField result = new JTextField(10);

        JButton add = new JButton("+");
        add.setBackground(Color.getHSBColor(0.97f, 0.3f, 1.0f));
        add.setFont(new Font("Lato", Font.PLAIN, 25));

        JButton substract = new JButton("-");
        substract.setBackground(Color.getHSBColor(0.17f, 0.35f, 1.0f));
        substract.setFont(new Font("Lato", Font.PLAIN, 25));

        JButton divide = new JButton("/");
        divide.setBackground(Color.getHSBColor(0.58f, 0.3f, 1.0f));
        divide.setFont(new Font("Lato", Font.PLAIN, 25));

        JButton multiply = new JButton("*");
        multiply.setBackground(Color.getHSBColor(0.83f, 0.3f, 1.0f));
        multiply.setFont(new Font("Lato", Font.PLAIN, 25));

        panel.add(a);
        panel.add(b);
        panel.add(result);
        panel.add(new JLabel(""));
        panel.add(add);
        panel.add(substract);
        panel.add(divide);
        panel.add(multiply);

        frame.getContentPane().add(panel);

        Calculator calculator = new Calculator();

        frame.setVisible(true);

        add.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (areNumbers(a, b)) {
                    double res = calculator.add(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                    result.setText(String.valueOf(res));
                }
            }
        }
        );

        substract.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (areNumbers(a, b)) {
                    double res = calculator.substract(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                    result.setText(String.valueOf(res));
                }
            }
        }
        );

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areNumbers(a, b)) {
                    if (Double.parseDouble(b.getText()) == 0) {
                        JOptionPane.showMessageDialog(frame, "You can't divide by 0!", "OK", JOptionPane.ERROR_MESSAGE);
                    } else {
                        double answer = calculator.divide(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                        result.setText(String.valueOf(answer));
                    }
                }

            }
        });

        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areNumbers(a, b)) {
                    double answer = calculator.multiply(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                    result.setText(String.valueOf(answer));
                }
            }
        });

    }

    private boolean areNumbers(JTextField value1, JTextField value2) {
        boolean flag;
        try {
            double checked1 = Double.parseDouble(value1.getText());
            double checked2 = Double.parseDouble(value2.getText());
            flag = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Only numbers are allowed!", "Ok", JOptionPane.ERROR_MESSAGE);
            value1.setText(null);
            value2.setText(null);
            flag = false;
        }
        return flag;
    }
}
