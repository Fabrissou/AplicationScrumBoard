package controller;

        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;

public class ControllerEditNameListDialog extends Controller {
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
    void changeName(MouseEvent event) {
        controller.setName(textField.getText());
        closeCurrentWindow(textField);
    }

    @FXML
    void close(MouseEvent event) {
        closeCurrentWindow(textField);
    }

    @FXML
    void initialize() {

    }
}
