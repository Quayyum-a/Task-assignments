import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class ToDoListManagerTest {

    private ToDoListManager toDoListApp = new ToDoListManager();

    @Test
    public void testGetHeading() {
        String actual = ToDoListManager.getAppHeading();
        String expected = "To-Do List Manager";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMenu() {
        String actual = ToDoListManager.getMainMenu();
        String expected = """
            \n1. Add a task
            2. View tasks
            3. Mark task as complete
            4. Delete a task
            5. Exit""";
        assertEquals(expected, actual);
    }

    @Test
    public void testAddTask() {
        ToDoListManager.addNewTask("Valid Task");
        assertFalse(ToDoListManager.getAllTasks().isEmpty());
    }

    @Test
    public void testViewTasks() {
        ToDoListManager.addNewTask("Task 1");
        ToDoListManager.addNewTask("Task 2");
        assertNotNull(ToDoListManager.getAllTasks());
    }

    @Test
    public void testMarkComplete() {
        ToDoListApp.addNewTask("Task 1");
        Scanner scanner = new Scanner("1");
        ToDoListApp.markTaskAsComplete(scanner);
        assertTrue(ToDoListApp.getAllTasks().get(0).isCompleted());
    }

    @Test
    public void testDeleteTask() {
        ToDoListApp.addNewTask("Task 1");
        ToDoListApp.removeTask("1");
        assertTrue(ToDoListApp.getAllTasks().isEmpty());
    }

    @Test
    public void testExitApp() {
        ToDoListApp.exitApplication();
        // No assertion needed as this method just prints a message
    }
}