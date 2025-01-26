import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Task {
    private String dueDate, category, name;
    private int difficulty, time;
    private final int taskID;
    
    public Task (int taskID, String name, String dueDate, String category, int difficulty, int time) {
        this.name = name;
        this.taskID = taskID;
        this.dueDate = dueDate;
        this.category = category;
        this.difficulty = difficulty;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String newDate) {
        this.dueDate = newDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int newDifficulty) {
        this.difficulty = newDifficulty;
    }

    public int getTime() {
        return 0;
    }

    public void setTime(int newTime) {
        this.time = newTime;
    }

    // days away
    public int daysAway() {
        // Define the date format of dueDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        // Parse dueDate into a LocalDate
        LocalDate dueDateParsed = LocalDate.parse(dueDate, formatter);

        // Get today's date
        LocalDate today = LocalDate.now();

        // Calculate days between today and dueDate
        return (int) ChronoUnit.DAYS.between(today, dueDateParsed);
    }

}