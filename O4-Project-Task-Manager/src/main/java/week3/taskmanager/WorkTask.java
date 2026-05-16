package main.java.week3.taskmanager;

public class WorkTask extends Task implements Displayable {

    private String project;

    public WorkTask(String name, String project) {
        super(name);
        this.project = project;
    }

    @Override
    public String display() {
        return super.display() + " (Project: " + project + ")";
    }
}
