package github.bkp5190;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TaskManagerAppTest {
    private TaskManager taskManager;
    private UserIO userIO;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        userIO = new UserIOTest("3", "TaskName", "COMPLETED");
    }

    @Test
    void testAddTask() {
        TaskManagerApp app = new TaskManagerApp(taskManager, userIO);
        app.run();

        // Now, you can assert the behavior of your taskManager, e.g., check if the task was added.
    }

    @Test
    void testUpdateTask() {
        TaskManagerApp app = new TaskManagerApp(taskManager, userIO);
        app.run();

        // Now, you can assert the behavior of your taskManager, e.g., check if the task was updated.
    }
}