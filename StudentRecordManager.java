import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Student Record Manager - GUI version (Java Swing)
 */
public class StudentRecordManager extends JFrame {

    private final ArrayList<Student> students = new ArrayList<>();

    private JTextField txtRoll, txtName, txtM1, txtM2, txtM3;
    private JTable table;
    private DefaultTableModel model;
    private JLabel lblStatus;

    public StudentRecordManager() {
        setTitle("Student Record Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(950, 620);
        setMinimumSize(new Dimension(850, 520));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);
        add(createStatusBar(), BorderLayout.SOUTH);
    }

    // ---------------------------------------------------------------- UI

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setBackground(new Color(30, 64, 124));
        header.setBorder(new EmptyBorder(14, 10, 14, 10));

        JLabel title = new JLabel("STUDENT RECORD MANAGER");
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        header.add(title);
        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel(new BorderLayout(10, 10));
        center.setBorder(new EmptyBorder(12, 14, 6, 14));

        JPanel top = new JPanel(new BorderLayout(0, 10));
        top.add(createFormPanel(), BorderLayout.NORTH);
        top.add(createButtonPanel(), BorderLayout.SOUTH);

        center.add(top, BorderLayout.NORTH);
        center.add(createTablePanel(), BorderLayout.CENTER);
        return center;
    }

    private JPanel createFormPanel() {
        JPanel form = new JPanel(new GridLayout(2, 5, 12, 6));
        form.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(30, 64, 124)),
                "Student Details", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 14), new Color(30, 64, 124)));

        String[] labels = {"Roll No", "Name", "Subject 1", "Subject 2", "Subject 3"};
        for (String text : labels) {
            JLabel l = new JLabel(text, SwingConstants.CENTER);
            l.setFont(new Font("SansSerif", Font.BOLD, 13));
            form.add(l);
        }

        txtRoll = new JTextField();
        txtName = new JTextField();
        txtM1 = new JTextField();
        txtM2 = new JTextField();
        txtM3 = new JTextField();

        JTextField[] fields = {txtRoll, txtName, txtM1, txtM2, txtM3};
        for (JTextField f : fields) {
            f.setFont(new Font("SansSerif", Font.PLAIN, 15));
            f.setHorizontalAlignment(JTextField.CENTER);
            f.setPreferredSize(new Dimension(100, 32));
            form.add(f);
        }
        return form;
    }

    private JPanel createButtonPanel() {
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 4));

        buttons.add(makeButton("Add", new Color(39, 150, 80), e -> addStudent()));
        buttons.add(makeButton("Update", new Color(30, 110, 200), e -> updateStudent()));
        buttons.add(makeButton("Delete", new Color(200, 50, 50), e -> deleteStudent()));
        buttons.add(makeButton("Search", new Color(120, 80, 180), e -> searchStudent()));
        buttons.add(makeButton("Show Topper", new Color(220, 140, 20), e -> showTopper()));
        buttons.add(makeButton("Show All", new Color(70, 90, 110), e -> showAll()));
        buttons.add(makeButton("Clear", new Color(110, 110, 110), e -> clearForm()));
        return buttons;
    }

    private JButton makeButton(String text, Color color, java.awt.event.ActionListener action) {
        JButton b = new JButton(text);
        b.setFont(new Font("SansSerif", Font.BOLD, 13));
        b.setBackground(color);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setOpaque(true);
        b.setBorder(new EmptyBorder(9, 18, 9, 18));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.addActionListener(action);
        return b;
    }

    private JScrollPane createTablePanel() {
        String[] columns = {"Roll No", "Name", "Subject 1", "Subject 2", "Subject 3",
                "Total", "Percentage", "Grade"};

        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setRowHeight(28);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setSelectionBackground(new Color(190, 215, 250));
        table.setSelectionForeground(Color.BLACK);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setGridColor(new Color(220, 220, 220));

        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(30, 64, 124));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setReorderingAllowed(false);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        // Clicking a row fills the form so it can be updated or deleted
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (!e.getValueIsAdjusting() && row >= 0) {
                txtRoll.setText(model.getValueAt(row, 0).toString());
                txtName.setText(model.getValueAt(row, 1).toString());
                txtM1.setText(model.getValueAt(row, 2).toString());
                txtM2.setText(model.getValueAt(row, 3).toString());
                txtM3.setText(model.getValueAt(row, 4).toString());
            }
        });

        return new JScrollPane(table);
    }

    private JPanel createStatusBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBorder(new EmptyBorder(6, 14, 8, 14));
        lblStatus = new JLabel("Ready. Add a student to begin.");
        lblStatus.setFont(new Font("SansSerif", Font.ITALIC, 13));
        bar.add(lblStatus, BorderLayout.WEST);
        return bar;
    }

    // ------------------------------------------------------ Operations

    private void addStudent() {
        try {
            int roll = parseInt(txtRoll.getText(), "Roll No");
            String name = txtName.getText().trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            }
            int m1 = parseMarks(txtM1.getText(), "Subject 1");
            int m2 = parseMarks(txtM2.getText(), "Subject 2");
            int m3 = parseMarks(txtM3.getText(), "Subject 3");

            if (findByRoll(roll) != null) {
                throw new IllegalArgumentException("A student with roll number " + roll + " already exists.");
            }

            students.add(new Student(roll, name, m1, m2, m3));
            refreshTable(students);
            clearForm();
            setStatus("Student added successfully!");
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
    }

    private void updateStudent() {
        try {
            int roll = parseInt(txtRoll.getText(), "Roll No");
            Student s = findByRoll(roll);
            if (s == null) {
                throw new IllegalArgumentException("No student found with roll number " + roll + ".");
            }
            String name = txtName.getText().trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            }
            int m1 = parseMarks(txtM1.getText(), "Subject 1");
            int m2 = parseMarks(txtM2.getText(), "Subject 2");
            int m3 = parseMarks(txtM3.getText(), "Subject 3");

            s.setName(name);
            s.setMarks(m1, m2, m3);
            refreshTable(students);
            clearForm();
            setStatus("Student updated successfully!");
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
    }

    private void deleteStudent() {
        try {
            int roll = parseInt(txtRoll.getText(), "Roll No");
            Student s = findByRoll(roll);
            if (s == null) {
                throw new IllegalArgumentException("No student found with roll number " + roll + ".");
            }
            int choice = JOptionPane.showConfirmDialog(this,
                    "Delete " + s.getName() + " (Roll " + roll + ")?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                students.remove(s);
                refreshTable(students);
                clearForm();
                setStatus("Student deleted.");
            }
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
    }

    private void searchStudent() {
        try {
            int roll = parseInt(txtRoll.getText(), "Roll No");
            Student s = findByRoll(roll);
            if (s == null) {
                setStatus("No student found with roll number " + roll + ".");
                JOptionPane.showMessageDialog(this, "Student not found.",
                        "Search", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            List<Student> result = new ArrayList<>();
            result.add(s);
            refreshTable(result);
            setStatus("Search result for roll number " + roll + ". Click 'Show All' to see everyone.");
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
    }

    private void showTopper() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No records found.",
                    "Topper", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Student topper = students.get(0);
        for (Student s : students) {
            if (s.getTotal() > topper.getTotal()) {
                topper = s;
            }
        }

        refreshTable(students);
        table.setRowSelectionInterval(students.indexOf(topper), students.indexOf(topper));
        setStatus("Topper: " + topper.getName() + " with " + topper.getTotal() + " marks.");

        JOptionPane.showMessageDialog(this,
                "Topper of the class\n\n"
                        + "Name: " + topper.getName() + "\n"
                        + "Roll No: " + topper.getRollNo() + "\n"
                        + "Total: " + topper.getTotal() + "\n"
                        + String.format("Percentage: %.2f%%%n", topper.getPercentage())
                        + "Grade: " + topper.getGrade(),
                "Topper", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAll() {
        refreshTable(students);
        setStatus("Showing all " + students.size() + " student(s).");
    }

    private void clearForm() {
        txtRoll.setText("");
        txtName.setText("");
        txtM1.setText("");
        txtM2.setText("");
        txtM3.setText("");
        table.clearSelection();
        txtRoll.requestFocus();
    }

    // ---------------------------------------------------------- Helpers

    private Student findByRoll(int roll) {
        for (Student s : students) {
            if (s.getRollNo() == roll) return s;
        }
        return null;
    }

    private int parseInt(String text, String fieldName) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a whole number.");
        }
    }

    private int parseMarks(String text, String fieldName) {
        int m = parseInt(text, fieldName);
        if (m < 0 || m > 100) {
            throw new IllegalArgumentException(fieldName + " must be between 0 and 100.");
        }
        return m;
    }

    private void refreshTable(List<Student> list) {
        model.setRowCount(0);
        for (Student s : list) {
            model.addRow(new Object[]{
                    s.getRollNo(), s.getName(),
                    s.getMark(0), s.getMark(1), s.getMark(2),
                    s.getTotal(), String.format("%.2f", s.getPercentage()), s.getGrade()
            });
        }
    }

    private void setStatus(String message) {
        lblStatus.setText(message);
    }

    private void showError(String message) {
        setStatus(message);
        JOptionPane.showMessageDialog(this, message, "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }

    // ------------------------------------------------------------- Main

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRecordManager().setVisible(true));
    }
}
