package core;

import java.time.LocalDate;
import java.util.Date;

public class ScrumTask {
    private String taskName;
    private String taskDate;

    public ScrumTask(String name, String date) {
        this.taskName = name;
        this.taskDate = date;
    }

    public ScrumTask(String name) {
        this.taskName = name;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    @Override
    public String toString() {
        return taskName + " " + taskDate;
    }
}
