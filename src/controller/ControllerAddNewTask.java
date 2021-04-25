package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.DatePicker;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;

public class ControllerAddNewTask extends Controller {
    ControllerTaskList controller;

    public void setController(ControllerTaskList controller) {
        this.controller = controller;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textField;

    @FXML
    private DatePicker dateField;

    @FXML
    void close(MouseEvent event) {
        closeCurrentWindow(textField);
    }

    @FXML
    void create(MouseEvent event) {
        String date = dateField.getValue() == null ? "" : dateField.getValue().toString();

        controller.addTaskFromStr(textField.getText(), date.toString());
        closeCurrentWindow(textField);
    }

    @FXML
    void initialize() {
    }
}

