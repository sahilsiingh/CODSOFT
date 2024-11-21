import java.util.Scanner;

public class StudentResults {

    // Method to calculate grade based on average percentage
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C";
        } else {
            return "F";
        }
    }

    // Method to calculate and display total marks, average percentage, and grade
    public static void calculateResults(int[] marks) {
        int totalMarks = 0;
        int numSubjects = marks.length;

        // Calculate total marks
        for (int i = 0; i < numSubjects; i++) {
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

        // Get grade based on average percentage
        String grade = calculateGrade(averagePercentage);

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        // Scanner to read input from user
        Scanner scanner = new Scanner(System.in);

        // Ask user for number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Array to store marks for each subject
        int[] marks = new int[numSubjects];

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
        }

        // Call method to calculate and display results
        calculateResults(marks);

        // Close scanner
        scanner.close();
    }
}
