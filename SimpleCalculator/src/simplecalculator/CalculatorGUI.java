package simplecalculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI {

    public CalculatorGUI() {
        //кнопки с вызовом операций, полями для задания данных и полем для вывода результата операции
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 4));
        JTextField a = new JTextField(10);
        JTextField b = new JTextField(10);
        JTextField result = new JTextField(10);

        JButton add = new JButton("+");
        JButton substract = new JButton("-");

        panel.add(a);
        panel.add(b);
        panel.add(result);

        panel.add(add);
        panel.add(substract);

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
    }
}
