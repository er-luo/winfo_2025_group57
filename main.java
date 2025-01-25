import java.util.*;

public class main {
    // Global Variables
    static Map<Integer, ArrayList<Object>> taskList = new HashMap<>();
    static Map<String, Integer> weekHours = new HashMap<>();
    static int hoursAvailable = 24;
	static String[] daysOfWeek = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static boolean grindset = false;
    static boolean[] available = new boolean[24]; // Represents 12 hours of availability

    public static void main(String[] args) {
        // Initialize application
        System.out.println("Welcome to Task Scheduler!");

		initializeDays();

        setUp(); // Set up available hours

        // Example usage:
        //taskAdd(1, "2025-01-31", 3, "Study", estimateTime("Study")); // Add a sample task
        //scheduler(); // Schedule tasks
    }

    // Method to set up available hours based on user input
    public static void setUp() {
        // Get user input for available hours
        // Update hoursAvailable and the 'available' array
        Scanner scanner = new Scanner(System.in);

        for (String day : daysOfWeek) {
            System.out.println("How many hours can you work on " + day + "?");
            int hoursAvailable = scanner.nextInt();
    
            // Update the weekHours map
            weekHours.put(day, hoursAvailable);
        }
        scanner.close();
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
    public static void grindScheduler(Task curr) {

        // Get the starting day
        
        // Loop backwards from the start day towards today (day 0)
        for (int i = curr.daysAway - 1; i >= 0; i--) {
            String day = dayOfWeek(i);  // Convert the index to the day name (you can use your existing method)
            int availableHours = weekHours.get(day);  // Get available hours for the day
            
            // Check if the current day has enough available hours for the task
            if (availableHours >= curr.time) {
                // If there are enough hours, subtract the time required for the task
                weekHours.put(day, availableHours - curr.time);
                System.out.println("Task scheduled on " + day + ". Remaining hours: " + (availableHours - curr.time));
                return; // Task successfully scheduled, exit the method
            }
        }
        
        // If no day has enough available hours, print a message (scheduling failed)
        System.out.println("Not enough available time to schedule the task.");
    }

	// Initialize the array with days starting from today
    public static void initializeDays() {
        // Get today's day as a string
        String today = getToday();

        // Find today's index in the daysOfWeek array
        int todayIndex = findTodayIndex(today);

        // Shift the array to have today's day at the front
        String[] newDays = new String[7];

        for (int i = 0; i < 7; i++) {
            newDays[i] = daysOfWeek[(todayIndex + i) % 7]; // Circular shift
        }

        daysOfWeek = newDays;
    }

	// Get today's day (e.g., "Monday", "Tuesday", etc.)
    public static String getToday() {
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();  // Get today's day of the week
        return dayOfWeek.toString();  // Return as a string (e.g., "MONDAY", "TUESDAY", etc.)
    }

	// Find the index of today's day in the daysOfWeek array
    public static int findTodayIndex(String today) {
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (daysOfWeek[i].equalsIgnoreCase(today)) {
                return i;  // Return the index of today
            }
        }
        return -1;
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

	public 

    // Method to analyze completed tasks (data processing)
    public static void processData() {
        // TODO: Implement logic to process and analyze task completion data
    }

    // Method to handle reminders
    public static void reminders() {
        // TODO: Implement reminder notifications
    }
}

