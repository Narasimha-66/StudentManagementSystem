import java.io.*;
import java.util.*;

public class StudentManager {
    private static final String FILE_NAME = "students.txt";
    private List<Student> students = new ArrayList<>();

    public StudentManager() {
        loadStudentsFromFile();
    }

    // Load data from file
    private void loadStudentsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int roll = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    double marks = Double.parseDouble(data[3]);
                    students.add(new Student(roll, name, age, marks));
                }
            }
        } catch (IOException e) {
            // file might not exist initially
        }
    }

    // Save data to file
    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // CRUD operations
    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public void deleteStudent(int rollNo) {
        students.removeIf(s -> s.getRollNo() == rollNo);
        saveToFile();
    }

    public void updateStudent(int rollNo, String name, int age, double marks) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                s.setName(name);
                s.setAge(age);
                s.setMarks(marks);
                saveToFile();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void viewAll() {
        for (Student s : students) {
            System.out.println(s.getRollNo() + " | " + s.getName() + " | " + s.getAge() + " | " + s.getMarks());
        }
    }
}
