import java.util.*;

class Student {
    private String name;
    private int id;
    private Map<String, Double> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }

    public void displayStudentRecord() {
        System.out.println("Name: " + name + ", ID: " + id);
        System.out.println("Grades:");
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            System.out.println("  Subject: " + entry.getKey() + ", Grade: " + entry.getValue());
        }
        System.out.println("Average Grade: " + calculateAverageGrade());
    }
}

public class StudentGradeManager {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(String name, int id) {
        students.add(new Student(name, id));
    }

    public static Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Assign Grade");
            System.out.println("3. Display Student Record");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    addStudent(name, id);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Student student = findStudent(studentId);
                    if (student != null) {
                        System.out.print("Enter subject: ");
                        String subject = scanner.nextLine();
                        System.out.print("Enter grade: ");
                        double grade = scanner.nextDouble();
                        student.addGrade(subject, grade);
                        System.out.println("Grade added successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int displayId = scanner.nextInt();
                    Student displayStudent = findStudent(displayId);
                    if (displayStudent != null) {
                        displayStudent.displayStudentRecord();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
