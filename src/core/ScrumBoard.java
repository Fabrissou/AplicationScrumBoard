package core;

import controller.ControllerTaskList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ScrumBoard {
    private final ObservableList<ControllerTaskList> board = FXCollections.observableArrayList(new ArrayList<ControllerTaskList>());

    public void add(ControllerTaskList controller) {
        board.add(controller);
    }

    public void remove(ControllerTaskList controller) {
        board.remove(controller);
        controller.closeThisList();
    }
}
