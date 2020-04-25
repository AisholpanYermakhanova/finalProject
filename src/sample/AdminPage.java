package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminPage extends Controller{

    @FXML
    private ListView<String> listviewAmoderator;

    @FXML
    private Label labelAdmin;

    @FXML
    private TextField textAmname;

    @FXML
    private TextField textAmlogin;

    @FXML
    private TextField textApass;

    @FXML
    private Button buttonAaddModerator;

    @FXML
    private Label labelAmoderator;

    @FXML
    private Button buttonAlogout;

    @FXML
    private TextField textAmques;

    @FXML
    private TextField textAmanswer;

    @FXML
    private TextField textAmLogin;

    @FXML
    private Button buttonRemove;

    @FXML
    private Label labelAremove;


    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
        DataBaseHeandler db=new DataBaseHeandler();
        try {
            for (int i = 0; i <db.updateModerators().size(); i++) {
                listviewAmoderator.getItems().add(db.updateModerators().get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        buttonAlogout.setOnAction(event -> {
            change2(buttonAlogout,"sample");
        });
        buttonRemove.setOnAction(event -> {
            String r=textAmLogin.getText();
            try {
                DataBaseHeandler db1=new DataBaseHeandler();
                db1.removeModerator(r);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            textAmLogin.setText("");
        });

        buttonAaddModerator.setOnAction(event -> {
            DataBaseHeandler db1=new DataBaseHeandler();
            User user =new User(textAmname.getText(),textAmlogin.getText(),textApass.getText(),textAmques.getText(),textAmanswer.getText());
            try {
                db1.AddModerator(user);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            textAmname.setText("");
            textAmlogin.setText("");
            textApass.setText("");
            textAmques.setText("");
            textAmanswer.setText("");
        });
    }
}
