import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Main {
    // Global Variables
    static Map<String, Set<Task>> schedule = new HashMap<>(); //keys: days of week, val: list of tasks
    static Set<Task> taskList = new HashSet<>(); //total list of all tasks
    static Map<String, Integer> weekHours = new HashMap<>(); //hours per day to work
	static String[] daysOfWeek = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static boolean grindset = false; //study mode
	static String[] categories = new String[] {"Exam", "Quiz", "Assignment", "Project"}; //types of tasks

    public static void main(String[] args) {
        // Initialize application
        System.out.println("Welcome to Task Scheduler!");

        Scanner scanner = new Scanner(System.in);

		initializeDays();
        initializeSchedule();
		//printDays();
        setUp(scanner); // Set up available hours

        //testadd
        promptUserTask(scanner);
        printSchedule();
        scanner.close();
    }

    // Method to set up available hours based on user input
    public static void setUp(Scanner scanner) {
        // Get user input for available hours
        // Update hoursAvailable and the 'available' array
        
        int habitCheck = -1;
        while ((habitCheck != 0) && (habitCheck != 1)) {
            System.out.println("Do you prefer splitting up your study hours(0) or grinding it out(1)?");
            habitCheck = scanner.nextInt();
        }
        
        if (habitCheck == 1) {
            grindset = true;
        }

        int hoursAvailable = 0;
        for (String day : daysOfWeek) {
            System.out.println("How many hours can you work on " + day + "?");
            hoursAvailable = scanner.nextInt();
    
            // Update the weekHours map
            weekHours.put(day, hoursAvailable);
        }
    }

    public static void promptUserTask(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter name of task: ");
        String name = scanner.nextLine();

        System.out.println("Enter Due Date (e.g., MM-DD-YYYY): ");
        String dueDate = scanner.nextLine();

        System.out.println("Enter Task Category (e.g., Exam, Assignment, Quiz, Project):");
        String category = scanner.nextLine();

        System.out.println("Enter Task Difficulty (1 to 3):");
        int difficulty = scanner.nextInt();

        scanner.nextLine();

        // change later to our algorithm *
        // System.out.println("Enter Time Required (in hours):");
        // int time = scanner.nextInt();

        // Create and return the Task object
        taskAdd(dueDate, name, category, difficulty);
    }

    // Method to add a new task
    public static void taskAdd(String dueDate, String name, String category, int difficulty) {
        int time = estimateTime(category, difficulty);
        Task newTask = new Task(taskList.size(), name, dueDate, category, difficulty, time);

        taskList.add(newTask);
        System.out.println("Task added");
        if (grindset) {
            grindScheduler(newTask);
        } else {
            //splitScheduler(newTask);
        }
    }

    // Method to schedule tasks
    public static void grindScheduler(Task curr) {

        // Loop forwards from the today
        int start = 7 - curr.daysAway();
        for (int i = start; i <= 6; i++) {
            String day = daysOfWeek[i];
            int availHours = weekHours.get(day);
            int est = estimateTime(curr.getCategory(), curr.getDifficulty());
            if (availHours >= est) {
                weekHours.put(day, availHours - est);
                schedule.get(day).add(curr);
                System.out.println("Task scheduled on " + day + ". Remaining hours: " + (availHours - est));
                return; // Task successfully scheduled, exit the method
            }
        }
        
        // If no day has enough available hours, print a message (scheduling failed)
        System.out.println("Not enough available time to schedule the task.");
    }

    // public static void splitScheduler(Task curr) {
        
    // }

    public static void initializeSchedule() {
        for (String day : daysOfWeek) {
            schedule.put(day, new HashSet<Task>());
        }
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

	// Print the current days of the week
    public static void printDays() {
        for (String day : daysOfWeek) {
            System.out.println(day);
        }
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
    public static int estimateTime(String category, int difficulty) {
        int est = 0;

        if (category.equals("Exam") || category.equals("Project")) {
            est = 3 * difficulty;
        } else if (category.equals("Quiz")) {
            est = 2 * difficulty;
        } else if (category.equals("Assignment")) {
            est = difficulty;
        }

        return est;
    }

    public static void printSchedule() {
        if (schedule.isEmpty()) {
            System.out.println("The schedule is currently empty.");
            return;
        }

        System.out.println("Schedule Contents:");
        for (Map.Entry<String, Set<Task>> entry : schedule.entrySet()) {
            String day = entry.getKey();
            Set<Task> tasks = entry.getValue();

            System.out.println("\nDay: " + day);
            if (tasks.isEmpty()) {
                System.out.println("  No tasks scheduled.");
            } else {
                for (Task task : tasks) {
                    System.out.println("  - Task ID: " + task.getTaskID() +
                                    ", Name: " + task.getCategory() +
                                    ", Due Date: " + task.getDueDate() +
                                    ", Difficulty: " + task.getDifficulty() +
                                    ", Estimated Time: " + estimateTime(task.getCategory(), task.getDifficulty()) + " hours");
                }
            }
        }
    }


    // Method to analyze completed tasks (data processing)
    // public static void processData() {
    //     // TODO: Implement logic to process and analyze task completion data
    // }

    // Method to handle reminders
    // public static void reminders() {
    //     // TODO: Implement reminder notifications
    // }
}

