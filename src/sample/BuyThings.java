package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyThings extends Controll{

    @FXML
    private JFXButton buttonBuyy;

    @FXML
    private JFXButton buttonCanel;

    @FXML
    private TextField labelCard;

    @FXML
    public void initialize()  {
        buttonBuyy.setOnAction(event -> {
            String l=labelCard.getText();
            if(!l.equals("")) {
                buttonBuyy.getScene().getWindow().hide();
            }
        });

        buttonCanel.setOnAction(event -> {
            buttonCanel.getScene().getWindow().hide();
        });
    }

    @Override
    public void change2(Button button, String url) {

        FXMLLoader loader  = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/" + url + ".fxml"));
        try {
            loader.load();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
