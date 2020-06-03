package Theme6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class MainPanel extends JPanel {

    /* Маска для валидации вводимых значений
       На вход допускаются любые числовые значения,
       если вы хотите ввести вещественное число, то следует использовать "." как разделитель
     */
    DecimalFormatSymbols point = new DecimalFormatSymbols(Locale.US);
    NumberFormat mask = new DecimalFormat("##0.####", point);
    private JFormattedTextField firstInputValue = new JFormattedTextField(new NumberFormatter(mask));
    private JFormattedTextField secondInputValue = new JFormattedTextField(new NumberFormatter(mask));
    private JTextField output = new JTextField();

    private Font font = new Font("SanSerif", Font.BOLD, 15);

    private JLabel firstValue = new JLabel("Input a first value: ");
    private JLabel secondValue = new JLabel("Input a second value: ");
    private JLabel resultValue = new JLabel("Result of expression: ");
    private JLabel chooseOperation = new JLabel("Choose the operation: ");

    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton multiply = new JButton("*");
    private JButton division = new JButton("/");
    private JButton exp = new JButton("x^n");


    MainPanel() {

        setLayout(null);
        setFocusable(true);
        grabFocus();

        // Блок настройки подписей к полям ввода
        firstValue.setBounds(10, 10, 150, 30);
        add(firstValue);
        secondValue.setBounds(10, 70, 150, 30);
        add(secondValue);
        chooseOperation.setBounds(10, 140, 150, 30);
        add(chooseOperation);
        resultValue.setBounds(200, 30, 200, 30);
        resultValue.setFont(font);
        add(resultValue);


        // Блок настройки полей ввода
        firstInputValue.setBounds(10, 40, 150, 30);
        firstInputValue.setEditable(true);
        add(firstInputValue);

        secondInputValue.setBounds(10, 100, 150, 30);
        secondInputValue.setEditable(true);
        add(secondInputValue);

        // Блок настроек поля вывода
        output.setBounds(200, 70, 155, 40);
        output.setFont(font);
        output.setEditable(false);
        add(output);

        // Блок настроек кнопок
        plus.setBounds(10, 180, 50, 30);
        add(plus);
        minus.setBounds(70, 180, 50, 30);
        add(minus);
        multiply.setBounds(130, 180, 50, 30);
        add(multiply);
        division.setBounds(190, 180, 50, 30);
        add(division);
        exp.setBounds(250, 180, 70, 30);
        add(exp);


        // Блок "Слушателей"
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstInputValue.getText().length() > 0 && secondInputValue.getText().length() > 0) {
                    double firstValue = Double.parseDouble(firstInputValue.getText());
                    double secondValue = Double.parseDouble(secondInputValue.getText());
                    String result = (firstValue + secondValue) + "";
                    output.setText(result);
                }
            }
        });

        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstInputValue.getText().length() > 0 && secondInputValue.getText().length() > 0) {
                    double firstValue = Double.parseDouble(firstInputValue.getText());
                    double secondValue = Double.parseDouble(secondInputValue.getText());
                    String result = (firstValue - secondValue) + "";
                    output.setText(result);
                }
            }
        });

        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstInputValue.getText().length() > 0 && secondInputValue.getText().length() > 0) {
                    double firstValue = Double.parseDouble(firstInputValue.getText());
                    double secondValue = Double.parseDouble(secondInputValue.getText());
                    double expr = firstValue * secondValue;
                    String result = (mask.format(expr)) + "";
                    output.setText(result);
                }
            }
        });

        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstInputValue.getText().length() > 0 && secondInputValue.getText().length() > 0) {
                    double firstValue = Double.parseDouble(firstInputValue.getText());
                    double secondValue = Double.parseDouble(secondInputValue.getText());
                    double expr = firstValue / secondValue;
                    String result = (mask.format(expr)) + "";
                    output.setText(result);
                }
            }
        });

        exp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstInputValue.getText().length() > 0 && secondInputValue.getText().length() > 0) {
                    double firstValue = Double.parseDouble(firstInputValue.getText());
                    double secondValue = Double.parseDouble(secondInputValue.getText());
                    double expr = Math.pow(firstValue, secondValue);
                    String result = (mask.format(expr)) + "";
                    output.setText(result);
                }
            }
        });
    }

}
