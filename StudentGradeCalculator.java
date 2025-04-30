import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentGradeCalculator {

    public double calculateAverageGrade(String fileName) {
        double total = 0;
        int count = 0;

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                int grade = Integer.parseInt(parts[1]);
                total += grade;
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        if (count > 0) {
            return total / count;
        } else {
            return 0;
        }
    }

    public void printStudentGrades(String fileName) {
        System.out.println("Student Grades:");
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void main(String[] args) {
        StudentGradeCalculator sgc = new StudentGradeCalculator();
        String fileName = "grades.txt";

        sgc.printStudentGrades(fileName);
        double average = sgc.calculateAverageGrade(fileName);
        System.out.printf("\nAverage Grade: %.2f\n", average);
    }
}
