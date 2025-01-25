import java.util.*;

public class main {
    // Global Variables
    static Map<Integer, ArrayList<Object>> taskList = new HashMap<>();
    static int[] weekHours = new int[7]; //week day
    static int hoursAvailable = 24;
    static boolean[] available = new boolean[24]; // Represents 12 hours of availability

    public static void main(String[] args) {
        // Initialize application
        System.out.println("Welcome to Task Scheduler!");

        // Example usage:
        //setUp(); // Set up unavailable hours
        //taskAdd(1, "2025-01-31", 3, "Study", estimateTime("Study")); // Add a sample task
        //scheduler(); // Schedule tasks
    }

    // Method to set up unavailable hours based on user input
    public static void setUp() {
        // Get user input for unavailable hours
        // Update hoursAvailable and the 'available' array
        
        for (day : weekHours) {
            // Gets start time and end time when user is unavailable
            
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter start time (0-23):");
            int startTime = myObj.nextInt();
            System.out.println("Enter end time (0-23):");
            int endTime = myObj.nextInt();


            for (int i = startTime; i < endTime; i++) {
                if (available[i]) { 
                    available[i] = false;
                    hoursAvailable--;
                }
            }

            System.out.println("Blocked time from " + startTime + " to " + endTime);
            System.out.println("Hours available: " + hoursAvailable);
        }
		
    }

    // Method to add a new task
    public static void taskAdd(String dueDate, String category, int difficulty, int time) {
        ArrayList<Object> newTask = new ArrayList<>();
        newTask.add(dueDate);
        newTask.add(category);
        newTask.add(difficulty);
        newTask.add(time);

        taskList.put(taskList.size(), newTask);
        // System.out.println("Task added: " + newTask);
    }

    // Method to schedule tasks
    public static void scheduler() {
        // TODO: Implement scheduling logic
        System.out.println("Scheduling tasks...");
    }

    // Helper method to estimate time based on category
    public static int estimateTime(String category) {
        // TODO: Implement time estimation logic based on category
        // Placeholder for now
        return switch (category.toLowerCase()) {
            case "study" -> 2;
            case "work" -> 3;
            case "exercise" -> 1;
            default -> 2; // Default estimate
        };
    }

    // Method to analyze completed tasks (data processing)
    public static void processData() {
        // TODO: Implement logic to process and analyze task completion data
    }

    // Method to handle reminders
    public static void reminders() {
        // TODO: Implement reminder notifications
    }
}

