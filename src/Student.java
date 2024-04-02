import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Project {
    private String studentName;
    private int completionTime; // in days

    public Project(String studentName, int completionTime) {
        this.studentName = studentName;
        this.completionTime = completionTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCompletionTime() {
        return completionTime;
    }
}

public class Student {
    public static void main(String[] args) {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("John", 5));
        projects.add(new Project("Alice", 7));
        projects.add(new Project("Bob", 3));
        projects.add(new Project("Carol", 6));
        projects.add(new Project("David", 8));

        Map<String, Integer> onTime = new HashMap<>();
        Map<String, Integer> late = new HashMap<>();
        Map<String, Integer> early = new HashMap<>();
        Map<String, Integer> projectCounts = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();

        for (Project project : projects) {
            String studentName = project.getStudentName();
            int completionTime = project.getCompletionTime();

            projectCounts.put(studentName, projectCounts.getOrDefault(studentName, 0) + 1);
            totalTime.put(studentName, totalTime.getOrDefault(studentName, 0) + completionTime);

            if (completionTime == 5) { // Assuming 5 days is the on-time threshold
                onTime.put(studentName, onTime.getOrDefault(studentName, 0) + 1);
            } else if (completionTime > 5) {
                late.put(studentName, late.getOrDefault(studentName, 0) + 1);
            } else {
                early.put(studentName, early.getOrDefault(studentName, 0) + 1);
            }
        }

        System.out.println("Number of projects completed on time:");
        printMap(onTime);
        System.out.println("\nNumber of projects completed late:");
        printMap(late);
        System.out.println("\nNumber of projects completed early:");
        printMap(early);
        System.out.println("\nAverage completion time for each student:");
        for (String studentName : projectCounts.keySet()) {
            int averageTime = totalTime.get(studentName) / projectCounts.get(studentName);
            System.out.println(studentName + ": " + averageTime + " days");
        }
    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}