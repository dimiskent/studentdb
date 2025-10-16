import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDB db = new StudentDB("students.ser");
        List<Student> students = db.getStudents();
        boolean run = true;
        do {
            System.out.println("Student Manager!");
            System.out.println("0) Exit");
            System.out.println("1) View Students");
            System.out.println("2) Add Student");
            System.out.println("3) Reset DB");
            System.out.print("=> ");
            switch (scanner.nextLine().charAt(0)) {
                case '0' -> run = false;
                case '1' -> {
                    if(!students.isEmpty()) {
                        System.out.println("Student List:");
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    } else System.out.println("No students!");
                }
                case '2' -> {
                    String name;
                    while (true) {
                        System.out.print("Name: ");
                        name = scanner.nextLine().trim();
                        if(name.isEmpty()) System.out.println("Name shouldn't be empty!");
                        else break;
                    }
                    int id;
                    while (true) {
                        System.out.print("ID: ");
                        if(scanner.hasNextInt()) {
                            id = scanner.nextInt();
                            if(id > 0) break;
                            else System.out.println("ID must be positive!");
                        } else {
                            System.out.println("ID must be a whole number!");
                        }
                    }
                    double grade;
                    while (true) {
                        System.out.print("Grade /100: ");
                        if(scanner.hasNextDouble()) {
                            grade = scanner.nextDouble();
                            if(grade >= 0 && grade <= 100) break;
                            else System.out.println("Grade is /100, should be between 0 & 100!");
                        } else {
                            System.out.println("Grade must be a number!");
                        }
                    }
                    students.add(new Student(name, id, grade));
                    db.saveStudents(students);
                    System.out.println("Student " + name + " added successfully!");
                    if(scanner.hasNextLine()) scanner.nextLine();
                }
                case '3' -> {
                    students = new ArrayList<>();
                    db.saveStudents(students);
                }
                default -> System.out.println("Invalid command!");
            }
        } while (run);
        System.out.println("Goodbye!");
        scanner.close();
    }
}
