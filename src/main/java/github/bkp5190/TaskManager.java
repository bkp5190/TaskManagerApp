package github.bkp5190;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    public TaskManager() {
        tasks = new ArrayList<>();
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
    public void updateTask(String taskName, Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskName().equals(taskName)) {
                tasks.set(i, updatedTask);
            }
        }
    }
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
    public Task getTaskName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                return task;
            }
        }
        return null;
    }
    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }
}
