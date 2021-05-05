package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ControllerCloseThisList extends Controller {
    ControllerTaskList controller;

    public void setController(ControllerTaskList controller) {
        this.controller = controller;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closeButton;

    @FXML
    void close(MouseEvent event) {
        closeCurrentWindow(closeButton);
    }

    @FXML
    void removeThisList(MouseEvent event) {
        controller.removeCurrentList();
        closeCurrentWindow(closeButton);
    }

    @FXML
    void initialize() {

    }
}

