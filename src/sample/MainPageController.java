package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;


import java.io.IOException;
import java.util.ArrayList;

public class MainPageController extends Controller {

    @FXML
    private Button buttonMlogout;

    @FXML
    private TextField textSerch;

    @FXML
    private Button buttonSearch;

    @FXML
    private Text texMnameUser;

    @FXML
    private TableColumn<?, ?> column1;

    @FXML
    private TableColumn<?, ?> column2;

    @FXML
    private TableView<String> listViewM;

    @FXML
    public void initialize() {
        buttonMlogout.setOnAction(event -> {
            change2(buttonMlogout,"sample");
        });


    }
}
