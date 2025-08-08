import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.*;

// Class representing an expense
class Expense {
    private final String date;
    private final String description;
    private final double amount;

    public Expense(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Date: " + date + " " + " Description: " + description + " " + "Amount: " + amount;
    }
}

public class ExpenseTrackerGUI extends JFrame {

    // Components for the GUI
    private final JTextField dateField = new JTextField(10);
    private final JTextField descField = new JTextField(20);
    private final JTextField amtField = new JTextField(5);

    // List to hold expenses
    private final ArrayList<Expense> expenses = new ArrayList<>();

    // Display area for showing added expenses
    JTextArea displayArea = new JTextArea(10, 30);

    @SuppressWarnings("Convert2Lambda")
    public ExpenseTrackerGUI() {
        super("Expense Tracker");
        setLayout(new BorderLayout());

        // Panel for input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Date (DD-MM-YYYY):"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descField);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amtField);

        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                try {

                    addExpense();

                } catch (IOException ex) {

                    JOptionPane.showMessageDialog(null, "Error saving expense.");

                }

            }

        });

        JButton viewButton = new JButton("View Expenses");
        viewButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                displayExpenses();

            }

        });

        // Add buttons to the panel

        inputPanel.add(addButton);

        inputPanel.add(viewButton);

        // Add panels to frame

        add(inputPanel, BorderLayout.NORTH);

        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 400);

        setVisible(true);

    }

    private void addExpense() throws IOException {

        if (!dateField.getText().isEmpty() && !descField.getText().isEmpty() && !amtField.getText().isEmpty()) {

            double amount = Double.parseDouble(amtField.getText());

            Expense expense = new Expense(dateField.getText(), descField.getText(), amount);

            expenses.add(expense);

            saveExpenses();
            clearFields();
            JOptionPane.showMessageDialog(null, "Expense added successfully.");

        } else {
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
        }

    }

    private void clearFields() {
        dateField.setText("");
        descField.setText("");
        amtField.setText("");
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private void saveExpenses() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("expenses.txt", true))) {
            for (int i = expenses.size() - 1; i >= 0; i--) {
                writer.println(expenses.get(i).toString());
                System.out.println(expenses.get(i).toString());
            }
            writer.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void displayExpenses() {
        displayArea.setText("");
        try {
            Scanner scanner = new Scanner(getClass().getResourceAsStream("/expenses.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                displayArea.append(line);
                scanner.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            displayArea.setCaretPosition(displayArea.getDocument().getLength());
        }
    }

    public static void main(String[] args) {
        new ExpenseTrackerGUI();
    }
}
