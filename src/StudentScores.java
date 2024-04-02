import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}

public class StudentScores {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 85));
        students.add(new Student("Alice", 92));
        students.add(new Student("Bob", 78));
        students.add(new Student("Carol", 63));
        students.add(new Student("David", 75));
        students.add(new Student("Emma", 80));
        students.add(new Student("Frank", 88));

        double totalScore = 0;
        List<Double> scores = new ArrayList<>();

        for (Student student : students) {
            totalScore += student.getScore();
            scores.add(student.getScore());
        }

        double averageScore = totalScore / students.size();

        Collections.sort(scores);

        int belowAverageCount = 0;
        int atAverageCount = 0;
        int aboveAverageCount = 0;

        for (double score : scores) {
            if (score < averageScore) {
                belowAverageCount++;
            } else if (score == averageScore) {
                atAverageCount++;
            } else {
                aboveAverageCount++;
            }
        }

        double medianBelowAverage = median(scores.subList(0, belowAverageCount));
        double medianAtAverage = median(scores.subList(belowAverageCount, belowAverageCount + atAverageCount));
        double medianAboveAverage = median(scores.subList(belowAverageCount + atAverageCount, students.size()));

        System.out.println("Number of students who scored:");
        System.out.println("Above the average: " + aboveAverageCount);
        System.out.println("At the average: " + atAverageCount);
        System.out.println("Below the average: " + belowAverageCount);
        System.out.println("\nMedian score for each group:");
        System.out.println("Above the average: " + medianAboveAverage);
        System.out.println("At the average: " + medianAtAverage);
        System.out.println("Below the average: " + medianBelowAverage);
    }

    private static double median(List<Double> numbers) {
        int middle = numbers.size() / 2;
        if (numbers.size() % 2 == 1) {
            return numbers.get(middle);
        } else {
            return (numbers.get(middle - 1) + numbers.get(middle)) / 2.0;
        }
    }
}