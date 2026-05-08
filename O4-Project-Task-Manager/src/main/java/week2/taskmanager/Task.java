package main.java.week2.taskmanager;

class Task {

    private String name;
    private String status;
    private String type;

    public Task(String name, String type) {
        this.name = name;
        this.type = type;
        this.status = "pending";
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return """
                Task {
                  name: %s,
                  status: %s,
                  type: %s
                }
                """.formatted(name, status, type);
    }

    public void markDone() {
        this.status = "done";
    }
}
