
// 📌 Medium Level: Student Object Serialization & Deserialization
// 🎯 Task
// Create a Student class and implement serialization & deserialization.

// 🔹 Steps to Follow
// Define a Student class with id, name, and GPA.
// Implement Serializable interface.
// Create methods to:
// Serialize a Student object and save it to a file.
// Deserialize the Student object from the file and display its details.
// Handle FileNotFoundException, IOException, and ClassNotFoundException
// properly.
// 📄 Sample Output
// Student details saved successfully!

// Reading from file...
// Student ID: 101
// Student Name: John Doe
// Student GPA: 3.8

import java.io.*;

// Student class implementing Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student GPA: " + gpa);
    }
}

public class StudentSerializationDemo {
    public static void main(String[] args) {
        String filename = "student.ser";

        // Create and serialize a Student object
        Student student = new Student(101, "John Doe", 3.8);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(student);
            System.out.println("Student details saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }

        // Deserialize and read the Student object
        System.out.println("\nReading from file...");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student s = (Student) in.readObject();
            s.display();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading student: " + e.getMessage());
        }
    }
}
