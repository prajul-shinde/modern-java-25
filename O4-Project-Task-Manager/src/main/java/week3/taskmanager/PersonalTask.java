package main.java.week3.taskmanager;

public class PersonalTask extends Task implements Displayable {
    private String category;

    public PersonalTask(String name, String category) {
        super(name);
        this.category = category;
    }

    @Override
    public String display() {
        return super.display() + " (Category: " + category + ")";
    }
}
