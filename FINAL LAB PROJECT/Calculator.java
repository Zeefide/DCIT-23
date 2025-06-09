import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private final JTextField display;
    private final JTextField input;
    private double result = 0;
    private String operator = "";
    private boolean startNewNumber = true;  // To clear input on new number start

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Segoe UI", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        input = new JTextField();
        input.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        input.setHorizontalAlignment(JTextField.RIGHT);
        add(input, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Segoe UI", Font.BOLD, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789".contains(command)) {
            if (startNewNumber) {
                input.setText(command);
                startNewNumber = false;
            } else {
                input.setText(input.getText() + command);
            }
        } else if (command.equals("C")) {
            input.setText("");
            display.setText("0");
            result = 0;
            operator = "";
            startNewNumber = true;
        } else if (command.equals("=")) {
            calculateResult();
            startNewNumber = true;
        } else {  // Operators + - * /
            if (!input.getText().isEmpty()) {
                if (!operator.isEmpty()) {
                    // Calculate intermediate result before new operator
                    calculateResult();
                } else {
                    result = Double.parseDouble(input.getText());
                }
                operator = command;
                display.setText(result + " " + operator);
                startNewNumber = true;
            } else if (!operator.isEmpty()) {
                // Allow changing operator if no new number typed yet
                operator = command;
                display.setText(result + " " + operator);
            }
        }
    }

    private void calculateResult() {
        if (operator.isEmpty() || input.getText().isEmpty()) {
            return; // Nothing to calculate
        }

        double num = Double.parseDouble(input.getText());

        switch (operator) {
            case "+" -> result += num;
            case "-" -> result -= num;
            case "*" -> result *= num;
            case "/" -> result = (num != 0) ? result / num : 0;
        }

        input.setText(String.valueOf(result));
        display.setText(result + " (Answer)");
        operator = "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
