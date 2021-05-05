package core;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrumTask scrumTask = (ScrumTask) o;
        return Objects.equals(getTaskName(), scrumTask.getTaskName()) && Objects.equals(getTaskDate(), scrumTask.getTaskDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskName(), getTaskDate());
    }
}
