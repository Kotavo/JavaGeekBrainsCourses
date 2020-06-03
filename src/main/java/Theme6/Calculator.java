package Theme6;

import java.lang.reflect.InvocationTargetException;
import javax.swing.*;

public class Calculator {

    private JFrame window;

    public Calculator() {
        window = new JFrame("Calculator");
        window.setSize(400,250);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new MainPanel());
        window.setVisible(true);
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                new Calculator();
            }
        });

    }
}
