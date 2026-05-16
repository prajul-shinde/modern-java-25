import main.java.week3.taskmanager.PersonalTask;
import main.java.week3.taskmanager.Task;
import main.java.week3.taskmanager.WorkTask;

import static java.lang.IO.println;
import static java.lang.IO.readln;

void main() {

    var menu = """
            ---------------------
            TASK MANAGER
            ---------------------
            %s
            ---------------------
            """.formatted("""
            Choose an option: 
             1. Add task
             2. List tasks
             3. Mark done
             4. Exit
            """);
    var tasks = new ArrayList<Task>();
    while (true) {
        String operation = readln(menu);
        if (operation == null || operation.isBlank()) return;
        int op = Integer.parseInt(operation);
        switch (op) {
            case 1 -> {
                String name = readln("enter task name");
                if (name == null || name.isBlank()) break;
                String type = readln("Is this a Work or Personal task? (W/P):");
                if (type != null && type.toLowerCase().startsWith("w")) {
                    String project = readln("Enter project name: ");
                    tasks.add(new WorkTask(name, project));
                    println("Work task added successfully!");
                } else {
                    String category = readln("Enter category (e.g., Home, Health): ");
                    tasks.add(new PersonalTask(name, category));
                    println("Personal task added successfully!");
                }
            }
            case 2 -> {
                if (tasks.isEmpty())
                    println("tasks list is currently empty");
                else {
                    println("your tasks");
                    for (var i = 0; i < tasks.size(); i++) {
                        println("%d %s: %s"
                                .formatted(i + 1, tasks.get(i).display()));
                    }
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
                println("Exiting... GoodBye!");
                return;
            }
            default -> println("Invalid option. Try again");
        }
    }
}