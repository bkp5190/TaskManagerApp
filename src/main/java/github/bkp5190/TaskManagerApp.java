package github.bkp5190;

import java.time.LocalDate;

public class TaskManagerApp {
    private final TaskManager taskManager;
    private final UserIO userIO;

    public TaskManagerApp(TaskManager taskManager, UserIO userIO) {
        this.taskManager = taskManager;
        this.userIO = userIO;
    }

    public void run() {
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Print Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = userIO.readInt();
            userIO.readLine(); // Consume the newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task name: ");
                    String taskName = userIO.readLine();
                    System.out.print("Enter description: ");
                    String description = userIO.readLine();
                    System.out.print("Enter due date (yyyy-MM-dd): ");
                    String dueDateStr = userIO.readLine();
                    LocalDate dueDate = LocalDate.parse(dueDateStr);
                    System.out.println("Enter status:");
                    System.out.println("1. TO_DO");
                    System.out.println("2. IN_PROGRESS");
                    System.out.println("3. COMPLETED");
                    int statusInput = userIO.readInt();
                    TaskStatus status;
                    switch (statusInput) {
                        case 1 -> status = TaskStatus.TO_DO;
                        case 2 -> status = TaskStatus.IN_PROGRESS;
                        case 3 -> status = TaskStatus.COMPLETED;
                        default -> {
                            System.out.println("Invalid status entered. Please enter 1, 2, or 3.");
                            continue; // Skip the rest of the loop and start over
                        }
                    }
                    Task task = new Task(taskName, description, dueDate, status);
                    taskManager.addTask(task);
                }
                case 2 -> taskManager.printTasks();
                case 3 -> {
                    System.out.println("Enter the name of the task you wish to update: ");
                    String taskName = userIO.readLine();
                    Task updateTask = taskManager.getTaskName(taskName);
                    if (updateTask == null) {
                        System.out.println("Task not found.");
                        continue; // Skip the rest of the loop and start over
                    }
                    System.out.print("Enter new status (TO_DO, IN_PROGRESS, COMPLETED): ");
                    String statusInput = userIO.readLine().trim().toUpperCase();
                    try {
                        TaskStatus status = TaskStatus.valueOf(statusInput);
                        updateTask.setStatus(status);
                        System.out.println("Task updated successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid status entered. Please enter TO_DO, IN_PROGRESS, or COMPLETED.");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting the application.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        UserIO userIO = new ConsoleUserIO(); // Your UserIO implementation
        TaskManagerApp app = new TaskManagerApp(taskManager, userIO);
        app.run();
    }
}
