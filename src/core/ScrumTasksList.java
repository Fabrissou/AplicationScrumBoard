package core;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ScrumTasksList {
    private String name;
    private final ObservableList<ScrumTask> list = FXCollections.observableArrayList(new ArrayList<ScrumTask>());

    public ScrumTasksList() {
    }

    public ObservableList<ScrumTask> getList() {
        return list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(String taskName, String date) {
        list.add(new ScrumTask(taskName, date));
    }

    public void remove(int index) {
        list.remove(index);
    }
}
