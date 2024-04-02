import java.util.*;

public class StudentScores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accepting test scores from the user
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        int[] scores = new int[numStudents];
        System.out.println("Enter the test scores for each student:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }

        // Calculating average
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = sum / numStudents;

        // Sorting scores
        Arrays.sort(scores);

        // Calculating median
        double median;
        if (numStudents % 2 == 0) {
            median = (scores[numStudents / 2 - 1] + scores[numStudents / 2]) / 2.0;
        } else {
            median = scores[numStudents / 2];
        }

        // Counting scores above, at, and below average
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;
        for (int score : scores) {
            if (score > average) {
                aboveAverageCount++;
            } else if (score == average) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }

        // Outputting results
        System.out.println("\nResults:");
        System.out.println("Number of students above average: " + aboveAverageCount);
        System.out.println("Median score for students above average: " + median);
        System.out.println("Number of students at average: " + atAverageCount);
        System.out.println("Median score for students at average: " + median);
        System.out.println("Number of students below average: " + belowAverageCount);
        System.out.println("Median score for students below average: " + median);

        scanner.close();
    }
}
