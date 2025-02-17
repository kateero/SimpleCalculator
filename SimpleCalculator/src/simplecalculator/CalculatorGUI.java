package simplecalculator;

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

        JFrame frame = new JFrame("Êàëüêóëÿòîð");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 4));
        JTextField a = new JTextField(10);
        JTextField b = new JTextField(10);
        JTextField result = new JTextField(10);

        JButton add = new JButton("+");
        JButton substract = new JButton("-");
        JButton divide = new JButton("/");
        JButton multiply = new JButton("*");

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
                double res = calculator.add(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                result.setText(String.valueOf(res));
            }
        }
        );

        substract.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                double res = calculator.substract(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                result.setText(String.valueOf(res));
            }
        }
        );

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Double.parseDouble(b.getText()) == 0) {
                    JOptionPane.showMessageDialog(frame, "You can't divide by 0!", "OK", JOptionPane.ERROR_MESSAGE);
                } else {
                    double answer = calculator.divide(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                    result.setText(String.valueOf(answer));
                }
            }
        });

        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double answer = calculator.multiply(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                result.setText(String.valueOf(answer));
            }
        });

    }
}
