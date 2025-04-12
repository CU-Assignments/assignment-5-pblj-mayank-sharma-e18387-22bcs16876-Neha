// 📌 Hard Level: Employee Management System
// 🎯 Task
// Develop a menu-based application with the following options: 1️⃣ Add an
// Employee 2️⃣ Display All Employees 3️⃣ Exit

// 🔹 Steps to Follow
// Create an Employee class with:
// Employee ID
// Name
// Designation
// Salary
// Implement file handling to store employee details persistently.
// Provide an interactive menu-based system for user input.
// Ensure proper exception handling.
// 📄 Sample Output
// Menu:
// 1. Add an Employee
// 2. Display All Employees
// 3. Exit

// Choose an option: 1
// Enter Employee ID: 1001
// Enter Employee Name: Alice
// Enter Designation: Software Engineer
// Enter Salary: 60000
// Employee added successfully!

// Menu:
// 1. Add an Employee
// 2. Display All Employees
// 3. Exit

// Choose an option: 2
// Employee ID: 1001, Name: Alice, Designation: Software Engineer, Salary: 60000

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String designation;
    double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee ID: " + id +
                ", Name: " + name +
                ", Designation: " + designation +
                ", Salary: " + salary);
    }
}

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = loadEmployees();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Designation: ");
                    String designation = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());

                    employees.add(new Employee(id, name, designation, salary));
                    saveEmployees(employees);
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    System.out.println("All Employees:");
                    for (Employee emp : employees) {
                        emp.display();
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Employee> loadEmployees() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Employee>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
