package github.bkp5190;

import java.time.LocalDate;
import java.util.Scanner;

public class TaskManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Print Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date (yyyy-MM-dd): ");
                    String dueDateStr = scanner.nextLine();
                    LocalDate dueDate = LocalDate.parse(dueDateStr);
                    System.out.println("Enter status:");
                    System.out.println("1. TO_DO");
                    System.out.println("2. IN_PROGRESS");
                    System.out.println("3. COMPLETED");
                    int statusInput = scanner.nextInt();
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
                    String taskName = scanner.nextLine();
                    Task updateTask = taskManager.getTaskName(taskName);
                    if (updateTask == null) {
                        System.out.println("Task not found.");
                        continue; // Skip the rest of the loop and start over
                    }
                    System.out.print("Enter new status (TO_DO, IN_PROGRESS, COMPLETED): ");
                    String statusInput = scanner.nextLine().trim().toUpperCase();
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
