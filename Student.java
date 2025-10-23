public class Student {
    private int rollNo;
    private String name;
    private int age;
    private double marks;

    public Student(int rollNo, String name, int age, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters and Setters
    public int getRollNo() {
        return rollNo; 
    }
    public String getName() { 
        return name; 
    }
    public int getAge() { 
        return age; 
    }
    public double getMarks() { 
        return marks; 
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public void setAge(int age) { 
        this.age = age; 
    }
    public void setMarks(double marks) { 
        this.marks = marks; 
    }
    @Override
    public String toString() {
        return rollNo + "," + name + "," + age + "," + marks;
    }
}
