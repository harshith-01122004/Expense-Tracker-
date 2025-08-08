# Expense-Tracker-
A simple Java Swing-based Expense Tracker that allows users to add, view, and save daily expenses to a file.

## 📌 Features

- Add new expenses with:
  - Date (DD-MM-YYYY)
  - Description
  - Amount
- View all expenses in a scrollable display area.
- Automatically saves expenses to a text file (`expenses.txt`).
- Simple, user-friendly GUI built using Java Swing.

## 🛠️ Technologies Used

| Technology    | Purpose                                |
|---------------|----------------------------------------|
| Java (JDK 8+) | Programming Language                   |
| Swing         | GUI Components                         |
| AWT           | Basic UI Elements & Layout Managers    |
| File I/O      | Reading/Writing expenses to file       |

---

## 📁 Project Structure

ExpenseTracker/
├── ExpenseTrackerGUI.java   # Main application class
├── expenses.txt             # File storing saved expenses (auto-created)
├── README.md                # This file

📄 How It Works
➕ Adding Expenses

1. Inputs from the user (date, description, and amount) are collected.
2. An Expense object is created and added to an ArrayList.
3. The expense is saved to a local file named expenses.txt.
4. A dialog box confirms the successful addition.

📂 Saving to File
1. When an expense is added, the expenses.txt file is appended with the latest entry.
2. The file is located in the project directory.
3. Each run appends newly added expenses to avoid overwriting existing ones.

👀 Viewing Expenses
On clicking "View Expenses", the program attempts to read the expenses.txt file.

🙋 Author
Harshith Nigam
Java Developer | Expense Tracker Project
