package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class MainPageShop extends Controll {
    @FXML
    private ImageView tableItem;

    @FXML
    private JFXButton buttonMPlogout;

    @FXML
    private JFXToggleNode labelNoveleties;

    @FXML
    private Button buttonHelp;

    @FXML
    private Button buttonBuy;

    @FXML
    private Button buttonBuy1;

    @FXML
    private Button buttonBuy2;

    @FXML
    private Button buttonBuy3;

    @FXML
    private Label price;

    @FXML
    private Button buttonBuy4;

    @FXML
    private Button buttonBuy5;

    @FXML
    private Button buttonBuy6;

    @FXML
    private Button buttonBuy7;

    @FXML
    private Button buttonBuy8;

    @FXML
    private Button buttonBuy9;

    @FXML
    private Button buttonBuy10;

    @FXML
    private Button buttonBuy11;

    @FXML
    public void initialize()  {

        buttonMPlogout.setOnAction(event -> {
            buttonMPlogout.getScene().getWindow().hide();
            change2(buttonMPlogout,"sample");
        });
        buttonHelp.setOnAction(event -> {
            change2(buttonHelp, "help");
        });

        buttonBuy.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy1.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy2.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy3.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy4.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy5.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy6.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy7.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy8.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy9.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy10.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
        });
        buttonBuy11.setOnAction(event -> {
            change2(buttonBuy,"BuyThings");
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
