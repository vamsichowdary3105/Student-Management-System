public class StudentManagementSystem {
    private static StudentManager studentManager = new StudentManager();
    private static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = InputUtil.getIntInput("Enter your choice: ");
            handleChoice(choice);
        }
    }

    private static void printMenu() {
        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. List Students");
        System.out.println("4. Search Student");
        System.out.println("5. Update Student");
        System.out.println("6. Exit");
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                removeStudent();
                break;
            case 3:
                listStudents();
                break;
            case 4:
                searchStudent();
                break;
            case 5:
                updateStudent();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addStudent() {
        String name = InputUtil.getStringInput("Enter student name: ");
        int age = InputUtil.getIntInput("Enter student age: ");
        studentManager.addStudent(new Student(nextId++, name, age));
    }

    private static void removeStudent() {
        int id = InputUtil.getIntInput("Enter student ID to remove: ");
        studentManager.removeStudent(id);
    }

    private static void listStudents() {
        studentManager.listStudents();
    }

    private static void searchStudent() {
        String name = InputUtil.getStringInput("Enter student name to search: ");
        Student student = studentManager.searchStudent(name);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        int id = InputUtil.getIntInput("Enter student ID to update: ");
        String newName = InputUtil.getStringInput("Enter new name: ");
        int newAge = InputUtil.getIntInput("Enter new age: ");
        studentManager.updateStudent(id, newName, newAge);
    }
}
