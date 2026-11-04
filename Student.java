public class Student {
    private int rollNo;
    private String name;
    private int[] marks = new int[3];   // 3 subjects

    public Student(int rollNo, String name, int m1, int m2, int m3) {
        this.rollNo = rollNo;
        this.name = name;
        setMarks(m1, m2, m3);
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getMark(int index) { return marks[index]; }

    public void setMarks(int m1, int m2, int m3) {
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
    }

    public int getTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    public double getPercentage() {
        return getTotal() / 3.0;
    }

    public String getGrade() {
        double p = getPercentage();
        if (p >= 90) return "A+";
        else if (p >= 80) return "A";
        else if (p >= 70) return "B";
        else if (p >= 60) return "C";
        else if (p >= 40) return "D";
        else return "F";
    }
}
