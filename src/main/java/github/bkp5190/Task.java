package github.bkp5190;

import java.time.LocalDate;

public class Task {
    private String taskName;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;

    public Task(String taskName, String description, LocalDate dueDate, TaskStatus status) {
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }
    public void setTaskName(String taskName) {this.taskName = taskName;}
    public void setDescription(String description) {this.description = description;}
    public void setDueDate(LocalDate dueDate) {this.dueDate = dueDate;}
    public void setStatus(TaskStatus status) {this.status = status;}
    public String getTaskName() {return taskName;}
    public String getDescription() {return description;}
    public LocalDate getDueDate() {return dueDate;}
    public TaskStatus getStatus() {return status;}
}

enum TaskStatus {
    TO_DO,
    IN_PROGRESS,
    COMPLETED
}