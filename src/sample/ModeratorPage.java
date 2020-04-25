package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

public class ModeratorPage {
    @FXML
    private Label labelModerator;

    @FXML
    private TextField textIType;

    @FXML
    private TextField textIname;

    @FXML
    private TextField textIDescription;

    @FXML
    private TextField textIprice;

    @FXML
    private RadioButton radioButtonIM;

    @FXML
    private RadioButton radioButtonIF;

    @FXML
    private TextField textIPhoto;

    @FXML
    private Label labelIPicture;

    @FXML
    private Button buttonUpload;

    @FXML
    private Button buttonBack;

    @FXML
    private TableView<String> listViewM;

    //private ObservableList<String> observableList= FXCollections.observableArrayList();

    @FXML
    void initialize(){
        ArrayList<String> arrayList = new ArrayList<>();
        DataBaseHeandler data=new DataBaseHeandler();
        buttonUpload.setOnAction(event -> {
            int p=0;
            if(textIprice.equals("")) {
                JOptionPane.showMessageDialog(null, "Add full information!", "Error", JOptionPane.PLAIN_MESSAGE);
            }

            String MF="p";
            if(radioButtonIM.isSelected()){
                MF="m";
            }
            else if(radioButtonIF.isSelected()){
                MF="f";
            }
            if(!textIType.equals("") || !textIname.equals("") || !textIDescription.equals("") || !textIprice.equals("") || !MF.equals("") || !textIPhoto.equals("")) {
                Item item = new Item(textIType.getText(), textIname.getText(), textIDescription.getText(), p, MF, textIPhoto.getText());
                try {
                    data.addItem(item);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Add full information!", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            if(!textIprice.equals("") && !textIname.equals("") && !textIDescription.equals("") && !MF.equals("") && !textIPhoto.equals("")){
                textIprice.setText("");
                textIname.setText("");
                textIDescription.setText("");
                textIPhoto.setText("");
                textIType.setText("");
            }
        });

    }
}
