package controller;

        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.DatePicker;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;

public class ControllerEditSelectedItem extends Controller {
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
    void changeTask(MouseEvent event) {
        controller.changeTask(textField.getText(), dateField.getValue());
        closeCurrentWindow(textField);
    }

    @FXML
    void close(MouseEvent event) {
        controller.removeTask();
        closeCurrentWindow(textField);
    }

    @FXML
    void initialize() {

    }
}
