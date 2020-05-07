package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleNode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class MainPageShop extends Controll {
public static  int i;
    @FXML
    private Button buttonSwapL;

    @FXML
    private Button buttonSwapR;

    @FXML
    private JFXButton buttonMPlogout;

    @FXML
    private JFXToggleNode labelNoveleties;

    @FXML
    private ImageView imag;

    @FXML
    private Label textItem;

    @FXML
    private Button buttonHelp;

    @FXML
    private JFXComboBox<String> combobox;
    ObservableList<String> list= FXCollections.observableArrayList();

    @FXML
    public void initialize()  {
        String a = "Almaty";
        String b = "Nursyltan";
        String c = "Karaganda";
        String d = "Pavlodar";
        String o = "Oskemen";
        list.addAll(a,b,c,d,o);
        combobox.setItems(list);

        buttonMPlogout.setOnAction(event -> {
            buttonMPlogout.getScene().getWindow().hide();
            change2(buttonMPlogout,"sample");
        });
        i=1;
        buttonSwapR.setOnAction(event -> {
            DataBaseHeandler db=new DataBaseHeandler();
            i++;
            try {
                String sa=db.getItems().get(i);
                Image image = new Image(getClass().getResource("1\\item8.jpeg").toExternalForm());
                imag.setImage(image);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            textItem.setText("weredsfdsfd sdfdgd \n jdfjdsshf ");
        });

        buttonSwapL.setOnAction(event -> {
            int q=1;
            DataBaseHeandler db=new DataBaseHeandler();
            while (true){
                int t=1;
                try {
                    if(db.getItems().get(t).equals(imag.getImage())){
                        q=t;
                        break;
                    }
                    else{
                        t++;
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });

        buttonHelp.setOnAction(event -> {
            change2(buttonHelp,"help");
            buttonHelp.getScene().getWindow().hide();
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
    public void change(Button button, String url) {
        button.getScene().getWindow().hide();
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
