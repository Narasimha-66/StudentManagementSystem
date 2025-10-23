import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    manager.addStudent(new Student(roll, name, age, marks));
                    break;

                case 2:
                    System.out.print("Enter Roll No to delete: ");
                    int rollDelete = sc.nextInt();
                    manager.deleteStudent(rollDelete);
                    break;

                case 3:
                    System.out.print("Enter Roll No to update: ");
                    int rollUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = sc.nextInt();
                    System.out.print("Enter new Marks: ");
                    double newMarks = sc.nextDouble();
                    manager.updateStudent(rollUpdate, newName, newAge, newMarks);
                    break;

                case 4:
                    manager.viewAll();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
