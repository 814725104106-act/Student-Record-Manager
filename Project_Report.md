# Student Record Manager using Java Swing

## Abstract
The Student Record Manager is a desktop application developed in Java using the Swing library to store and manage student details such as roll number, name, and marks. It replaces manual record keeping with a simple, fast, and accurate digital system. Through a graphical window with text boxes, buttons, and a table, the user can add, update, delete, search, and view student records. The application automatically calculates total marks, percentage, and grade, and identifies the topper of the class. The project uses core Java concepts such as classes, objects, collections, event handling, and exception handling.

## Introduction
Schools and colleges handle large amounts of student data, and managing it on paper is time-consuming and error-prone. A computerized record system saves time, reduces mistakes, and makes information easy to retrieve. This project provides an easy-to-use graphical interface built with Java Swing, where all records are stored in an `ArrayList` and displayed in a table.

## Objectives
- To store student records in an organized way
- To provide a user-friendly graphical interface
- To reduce manual work and calculation errors
- To allow quick searching and updating of records
- To calculate total, percentage, and grade automatically
- To apply object-oriented programming concepts in a practical project

## Scope
The project can be used by small institutions, teachers, or students for basic record management. It can later be extended with file storage, a database, and login features.

## System Requirements
**Hardware:** any computer with at least 2 GB RAM and 100 MB free disk space.
**Software:** JDK 8 or above, and Visual Studio Code with the Extension Pack for Java.
**Language:** Java (Swing / AWT).

## Modules
1. **Add:** accepts roll number, name, and marks in three subjects, and rejects duplicate roll numbers and invalid marks.
2. **Update:** modifies the name and marks of an existing student.
3. **Delete:** removes a student record after confirmation.
4. **Search:** finds a student by roll number.
5. **Show Topper:** highlights the student with the highest total marks.
6. **Show All:** displays all records in the table.
7. **Clear:** resets the input boxes.

## Grading Criteria
| Percentage | Grade |
|---|---|
| 90 and above | A+ |
| 80 to 89 | A |
| 70 to 79 | B |
| 60 to 69 | C |
| 40 to 59 | D |
| Below 40 | F |

## Algorithm (Main Flow)
1. Start the program and open the main window.
2. User enters details in the form and clicks a button.
3. The program validates the input.
4. If valid, the selected operation (add, update, delete, search, topper) is performed on the student list.
5. The table is refreshed and a status message is shown.
6. If invalid, an error message is displayed.
7. Repeat until the user closes the window.

## Class Description
| Class | Purpose |
|---|---|
| `Student` | Stores roll number, name and marks; calculates total, percentage and grade |
| `StudentRecordManager` | Extends `JFrame`; builds the window (form, buttons, table, status bar) and handles all button actions |

## Swing Components Used
| Component | Use |
|---|---|
| `JFrame` | Main application window |
| `JPanel` | Grouping form, buttons and header |
| `JLabel` | Headings and status messages |
| `JTextField` | Input for roll number, name and marks |
| `JButton` | Add, Update, Delete, Search, Show Topper, Show All, Clear |
| `JTable` and `DefaultTableModel` | Displaying student records |
| `JScrollPane` | Scrolling the table |
| `JOptionPane` | Error, confirmation and information dialogs |
| Layout managers | `BorderLayout`, `GridLayout`, `FlowLayout` |

## Java Concepts Used
- Classes and objects with encapsulation (private fields, getters and setters)
- Inheritance (`StudentRecordManager` extends `JFrame`)
- `ArrayList` collection
- Arrays (for marks)
- Event handling using `ActionListener` (lambda expressions)
- Exception handling (`try-catch`, `NumberFormatException`, `IllegalArgumentException`)
- Input validation
- Methods and loops (`for-each`)
- Formatted output using `String.format`

## Screen Layout
```
+----------------------------------------------------------------+
|                    STUDENT RECORD MANAGER                      |
+----------------------------------------------------------------+
| Student Details                                                |
|  Roll No | Name | Subject 1 | Subject 2 | Subject 3            |
|  [     ] [    ] [        ]  [        ]  [        ]             |
|                                                                |
| [Add] [Update] [Delete] [Search] [Show Topper] [Show All] [Clear] |
|                                                                |
| Roll No | Name   | S1 | S2 | S3 | Total | Percentage | Grade   |
|   101   | Arun   | 85 | 90 | 78 |  253  |   84.33    |   A     |
|   102   | Priya  | 92 | 88 | 95 |  275  |   91.67    |   A+    |
+----------------------------------------------------------------+
| Status: Student added successfully!                            |
+----------------------------------------------------------------+
```

## Advantages
- Easy to use graphical interface
- Fast searching and updating
- Automatic and accurate calculation
- Input validation prevents wrong data and crashes
- Easy to understand and extend
- Needs no database or special hardware

## Limitations
- Data is lost when the application is closed, since it is stored only in memory
- Handles a single user at a time
- Fixed to three subjects

## Future Scope
- Save and load records using file handling or a database (MySQL with JDBC)
- Add login for teachers and admin
- Generate and print report cards
- Sort and filter records by marks or name
- Add charts for result analysis
- Add more subjects and subject-wise analysis

## Conclusion
The Student Record Manager successfully demonstrates how Java Swing can be used to build a practical desktop application. It simplifies the storage, retrieval, and processing of student data, and it helped in understanding object-oriented programming, collections, event handling, and GUI design. With further enhancements, it can grow into a complete student information system.
