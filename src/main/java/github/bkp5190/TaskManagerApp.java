package github.bkp5190;

import java.time.LocalDate;

public class TaskManagerApp {
    public static void main(String[] args) {
        // Create a TaskManager instance
        TaskManager taskManager = new TaskManager();

        // Create and add some tasks to the task manager
        Task task1 = new Task("Finish assignment", "Complete Java assignment", LocalDate.now(), TaskStatus.IN_PROGRESS);
        taskManager.addTask(task1);

        Task task2 = new Task("Study for exam", "Review study material", LocalDate.of(2023, 9, 29), TaskStatus.TO_DO);
        taskManager.addTask(task2);

        // Print the tasks in the task manager
        taskManager.printTasks();

        // Update a task
        Task updatedTask = new Task("Finish assignment", "Complete Java assignment", LocalDate.of(2023, 10, 28), TaskStatus.COMPLETED);
        taskManager.updateTask("Finish assignment", updatedTask);

        // Print the updated tasks
        taskManager.printTasks();
    }
}
