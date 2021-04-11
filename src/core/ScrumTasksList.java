package core;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ScrumTasksList {
    private String listName;
    private ArrayList<ScrumTask> list = new ArrayList<ScrumTask>();

    public ScrumTasksList() {
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public ArrayList<ScrumTask> getList() {
        return list;
    }

    public void setList(ArrayList<ScrumTask> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.listName = name;
    }

    public void add(String taskName, String date) {
        list.add(new ScrumTask(taskName, date));
    }

    public void remove(int index) {
        list.remove(index);
    }
}
