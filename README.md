# Student Record Manager (Java Swing GUI Mini Project)

A desktop window application to add, update, delete, search and view student
records, with automatic total, percentage, grade and topper detection.

## Project Structure

```
StudentRecordManager/
├── src/
│   ├── Student.java               (Student class - data + calculations)
│   └── StudentRecordManager.java  (Main class - Swing window and all operations)
├── docs/
│   └── Project_Report.md          (Full report content for submission)
├── .vscode/
│   ├── launch.json                (Run configuration)
│   └── settings.json
├── run.bat                        (Run on Windows)
├── run.sh                         (Run on Linux / Mac)
└── README.md
```

## Requirements

1. JDK 8 or above (JDK 17 or 21 recommended): https://adoptium.net
2. Visual Studio Code
3. VS Code extension: **Extension Pack for Java** (by Microsoft)

## How to Run in VS Code

1. Unzip the folder.
2. Open VS Code -> File -> Open Folder -> select `StudentRecordManager`.
3. Wait a few seconds for the Java extension to finish loading.
4. Open `src/StudentRecordManager.java`.
5. Press **F5**, or click the **Run** link above `public static void main`.
6. The application window opens on your screen.

If an old window or terminal is still running, stop it first (red square button
in the debug toolbar), then run again.

## Alternative: Run from the Terminal

Windows: double-click `run.bat`

Linux / Mac: `./run.sh`

Or manually:

```
mkdir bin
javac -d bin src/*.java
java -cp bin StudentRecordManager
```

## How to Use the Application

| Button | What it does |
|---|---|
| Add | Fills Roll No, Name and 3 marks, then click Add to save a new student |
| Update | Click a row in the table (or type the Roll No), change the values, then click Update |
| Delete | Click a row (or type the Roll No), then click Delete and confirm |
| Search | Type a Roll No, then click Search to show only that student |
| Show Topper | Highlights the student with the highest total and shows the details |
| Show All | Shows every student again after a search |
| Clear | Empties all the text boxes |

Tip: clicking any row in the table automatically fills the form boxes.

## Validation

- Roll No must be a whole number and must be unique
- Name cannot be empty
- Marks must be whole numbers between 0 and 100
- Wrong input shows an error message and never crashes the program

## Grading

| Percentage | Grade |
|---|---|
| 90 and above | A+ |
| 80 - 89 | A |
| 70 - 79 | B |
| 60 - 69 | C |
| 40 - 59 | D |
| Below 40 | F |

## Troubleshooting

- **"javac is not recognized"**: JDK is not installed or not in PATH. Install the JDK and restart VS Code.
- **No Run button visible**: install the "Extension Pack for Java" and reopen the folder.
- **Window does not appear**: check the taskbar, it may have opened behind VS Code.
## Project Screenshot
![Student Record Manager](docs/Screenshot%202026-11-04%20220622.png)
