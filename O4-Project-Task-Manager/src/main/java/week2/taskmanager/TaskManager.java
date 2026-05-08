package main.java.week2.taskmanager;

import java.util.ArrayList;

import static java.lang.IO.println;
import static java.lang.IO.readln;

public class TaskManager {

    void main() {
        var menu = """
                -- Task Manager--
                %s
                -----------------
                Select an option: \s""".formatted("""
                1. Add a task
                2. List tasks
                3. Mark task as done
                4. Exit
                """);
        var tasks = new ArrayList<Task>();
        while (true) {
            String input = readln(menu);
            if (input == null || input.isBlank()) continue;
            int op = Integer.parseInt(input);
            switch (op) {
                case 1 -> {
                    String name = readln("enter task name: ");
                    String type = readln("enter task type: ");
                    if (name != null && !name.isBlank()) {
                        var task = new Task(name.strip(), type.strip());
                        tasks.add(task);
                    }

                    println("task added successfully");
                }
                case 2 -> {
                    if (tasks.isEmpty())
                        println("task list is currently empty");
                    else {
                        for (var i = 0; i < tasks.size(); i++)
                            println("%d  name: %s status: %s"
                                    .formatted(i + 1, tasks.get(i).getName(), tasks.get(i).getStatus()));
                    }
                }
                case 3 -> {
                    if (tasks.isEmpty())
                        println("no tasks to mark done");
                    else {
                        String indexStr = readln("Enter task number to mark done: ");
                        int index = Integer.parseInt(indexStr.strip()) - 1;

                        if (index >= 0 && index < tasks.size()) {
                            tasks.get(index).markDone();
                            println("Task updated!");
                        } else {
                            println("Invalid task number.");
                        }
                    }
                }
                case 4 -> {
                    println("Exiting....");
                    return;
                }
                default -> println("Invalid option. Try again");
            }
        }

    }
}
