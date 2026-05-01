package main.java.taskmanager;

import java.util.ArrayList;

import static java.lang.IO.println;
import static java.lang.IO.readln;

public class TaskManager {

    void main() {

        var tasks = new ArrayList<String>();
        var menu = """
                -- Task Manager--
                %s
                -----------------
                Select an option: \s""".formatted("""
                1. Add a task
                2. List tasks
                3. Exit
                """);
        while (true) {
            String input = readln(menu);
            if (input == null || input.isBlank()) continue;
            int op = Integer.parseInt(input.strip());
            switch (op) {
                case 1 -> {
                    String task = readln("Enter task name: ");
                    if (task != null && !task.isBlank())
                        tasks.add(task);
                    println("Task added!");
                }
                case 2 -> {
                    if (tasks.isEmpty())
                        println("tasks list is currently empty");
                    else {
                        println("your tasks");
                        for (var i = 0; i < tasks.size(); i++) {
                            println("%d %s".formatted(i + 1, tasks.get(i)));
                        }
                    }
                }
                case 3 -> {
                    println("Exiting... GoodBye!");
                    return;
                }
                default -> println("Invalid option. Try again");
            }
        }
    }
}
