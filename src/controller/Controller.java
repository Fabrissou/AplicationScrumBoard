package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import core.ScrumBoard;
import core.ScrumTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {
    ScrumBoard scrumBoard = new ScrumBoard();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private FlowPane taskTable;

    @FXML
    private Button createNewTask;

    @FXML
    void saveProgress(ActionEvent event) {
    }

    @FXML
    void closeDesk(ActionEvent event) {
        closeCurrentWindow(taskTable);
    }

    @FXML
    private void createNewTask(MouseEvent event) {
        VBox box = new VBox();
        HBox buttons = new HBox();
        box.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.CENTER);
        TextField nameList = new TextField();
        Button create = new Button("Создать список");
        Button cancel = new Button("Отмена");
        buttons.getChildren().addAll(create, cancel);
        box.getChildren().addAll(new Label("Введите название списка"), nameList, buttons);
        showWindow(new Scene(box));

        cancel.setOnMouseClicked(mouseEvent -> {
            closeCurrentWindow(cancel);
        });

        create.setOnMouseClicked(mouseEvent -> {
            FXMLLoader listLoader = new FXMLLoader();
            listLoader.setLocation(getClass().getResource("../resources/taskList.fxml"));

            try {
                listLoader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            ControllerTaskList taskListController = listLoader.getController();
            scrumBoard.add(taskListController);
            taskListController.setTable(taskTable);
            taskListController.setName(nameList.getText());
            nameList.clear();
            taskTable.getChildren().add(listLoader.getRoot());
            closeCurrentWindow(create);
        });
    }

    @FXML
    void initialize() {

    }

    void showWindow(Scene scene) {
        Stage dialog = new Stage();
        dialog.setMaxHeight(400);
        dialog.setMaxWidth(400);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setScene(scene);
        dialog.show();
    }

    void closeCurrentWindow(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
