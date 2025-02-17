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

public class CalculatorGUI extends JFrame{
    Calculator calculate = new Calculator();
    //кнопки с вызовом операций, полями для задания данных и полем для вывода результата операции
    public void CalculatorGUI(){
        
        
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
       // pack();
        
        JPanel panel = new JPanel(new GridLayout(2,4));
        JTextField a = new JTextField(10);
        JTextField b = new JTextField(10);
        JTextField result = new JTextField(10);
        
        JButton divide = new JButton("/");
        JButton multiply = new JButton("*");
        
        panel.add(a);
        panel.add(b);
        panel.add(result);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(divide);
        panel.add(multiply);
        
        
        frame.getContentPane().add(panel);
        frame.setVisible(true);

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try {
                double answer = calculate.divide(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                result.setText(String.valueOf(answer));
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(frame,"You can't divide by 0!","OK", JOptionPane.ERROR_MESSAGE);
            }
            }
        });
        
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try {
                double answer = calculate.multiply(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()));
                result.setText(String.valueOf(answer));
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(frame,"You can't divide by 0!","OK", JOptionPane.ERROR_MESSAGE);
            }
            }
        });
    }
}
