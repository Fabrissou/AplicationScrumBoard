package controller;

import java.time.LocalDate;

import core.ScrumTask;
import core.ScrumTasksList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class ControllerTaskList extends Controller {
    Controller paneController;
    ScrumTasksList newList = new ScrumTasksList();
    ObservableList<ScrumTask> newObsList = FXCollections.observableList(newList.getList());

    public void setPaneController(Controller paneController) {
        this.paneController = paneController;
    }

    public void setNewList(ScrumTasksList list) {
        newList = list;
        setName(newList.getListName());
        newObsList = FXCollections.observableList(newList.getList());
        listOfTasks.setItems(newObsList);
    }

    @FXML
    private ListView<ScrumTask> listOfTasks;

    @FXML
    private AnchorPane backPanel;

    @FXML
    public Text taskListName;

    @FXML
    public MenuItem deleteThisList;

    @FXML
    void editNameList(ActionEvent event) {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        TextField listName = new TextField();
        Button edit = new Button("Изменить название");
        Button cancel = new Button("Отмена");
        buttons.getChildren().addAll(edit, cancel);
        box.getChildren().addAll(new Label("Введите новое название списка"), listName, buttons);
        Scene scene = new Scene(box);
        showWindow(scene);

        cancel.setOnMouseClicked(mouseEvent -> closeCurrentWindow(cancel));

        edit.setOnMouseClicked(mouseEvent -> {
            setName(listName.getText());
            listName.clear();
            closeCurrentWindow(cancel);
        });
    }

    @FXML
    void addNew(MouseEvent event) {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        TextField nameTask = new TextField();
        Button create = new Button("Создать");
        Button cancel = new Button("Отмена");
        DatePicker datePicker = new DatePicker();
        Label name = new Label("Введите название задачи:");
        Label date = new Label("Введите дату:");
        name.setMinHeight(25);
        date.setMinHeight(25);
        buttons.getChildren().addAll(create, cancel);
        box.getChildren().addAll(name, nameTask, date, datePicker, new Label(), buttons);
        Scene scene = new Scene(box);
        showWindow(scene);

        cancel.setOnMouseClicked(mouseEvent -> closeCurrentWindow(cancel));

        create.setOnMouseClicked(mouseEvent -> {
            String taskName = nameTask.getText();
            LocalDate currentDate = datePicker.getValue();

            if (!("".equals(taskName) && currentDate == null)) {
                newObsList.add(new ScrumTask(taskName, currentDate == null ? "" : currentDate.toString()));
            }
            closeCurrentWindow(create);
        });
    }

    @FXML
    void closeList(ActionEvent event) {
        closeThisList();
    }

    @FXML
    void editSelectedItem(ActionEvent event) {
        ScrumTask thisTask = listOfTasks.getSelectionModel().getSelectedItem();
        int index = listOfTasks.getSelectionModel().getSelectedIndex();

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        TextField nameTask = new TextField();
        DatePicker datePicker = new DatePicker();
        Button editNameButton = new Button("Изменить задачу");
        Button deleteButton = new Button("Удалить задачу");
        Label name = new Label("Введите новое название задачи:");
        Label date = new Label("Введите новую дату:");
        name.setMinHeight(25);
        date.setMinHeight(25);
        buttons.getChildren().addAll(editNameButton, deleteButton);
        box.getChildren().addAll(name, nameTask, date, datePicker, new Label(), buttons);
        Scene scene = new Scene(box);
        showWindow(scene);

        deleteButton.setOnMouseClicked(mouseEvent -> {
            newList.remove(index);
            closeCurrentWindow(deleteButton);
        });

        editNameButton.setOnMouseClicked(mouseEvent -> {
            if (!("").equals(nameTask.getText())) {
                thisTask.setTaskName(nameTask.getText());
            }

            if (datePicker.getValue() != null) {
                thisTask.setTaskDate(datePicker.getValue().toString());
            }

            listOfTasks.refresh();
            closeCurrentWindow(editNameButton);
        });
    }

    @FXML
    void initialize() {
        listOfTasks.setItems(newObsList);
    }

    void setName(String name) {
        newList.setName(name);
        taskListName.setText(name);
    }

    public void closeThisList() {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        Button yes = new Button("Да");
        Button no = new Button("Нет");
        HBox but = new HBox(yes, no);
        but.setAlignment(Pos.CENTER);
        box.getChildren().addAll(new Label("Вы действительно хотите удалить этот список?"), but);
        Scene scene = new Scene(box);
        showWindow(scene);

        yes.setOnMouseClicked(MouseEvent -> {
            paneController.getTaskTable().getChildren().remove(backPanel);
            paneController.scrumBoard.remove(newList);
            closeCurrentWindow(yes);
        });

        no.setOnMouseClicked(MouseEvent -> closeCurrentWindow(no));
    }
}
