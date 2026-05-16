package main.java.week3.taskmanager;

public class Task implements Displayable {

    private String name;
    private String status;

    public Task(String name) {
        this.name = name;
        this.status = "pending";
    }

    public void markDone() {
        this.status = "done";
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public String display() {
        return getStatus() + " " + name;
    }
}