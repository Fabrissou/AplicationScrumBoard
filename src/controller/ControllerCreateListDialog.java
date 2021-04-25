package controller;

import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;

public class ControllerCreateListDialog extends Controller {
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textField;

    @FXML
    void close(MouseEvent event) {
        closeCurrentWindow(textField);
    }

    @FXML
    void create(MouseEvent event) {
        controller.createList(textField.getText());
        closeCurrentWindow(textField);
    }

    @FXML
    void initialize() {
    }
}

