package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class ForgetPage {

    @FXML
    private Label labelFpass;

    @FXML
    private Label labelFans;

    @FXML
    private Label labelFques;

    @FXML
    private Label labelFlog;

    @FXML
    private Label labelFoget;

    @FXML
    private TextField textFlog;

    @FXML
    private Label textFque;

    @FXML
    private TextField textFans;

    @FXML
    private TextField textFpass;

    @FXML
    private Button buttonFget;

    @FXML
    private Button buttonFcheck;

    @FXML
    private Button buttonFback;

    @FXML
    public void initialize() {
        buttonFback.setOnAction(event -> {
            buttonFback.getScene().getWindow().hide();
        });
        buttonFget.setOnAction(event -> {
            String g="";
             g=textFlog.getText().trim(); //loginField
            DataBaseHeandler db=new DataBaseHeandler();
            try {
                String a=db.getQuestion(g);//question
                if(!g.equals("") && !a.equals("Not faund")) {
                    textFque.setText(a);
                }
                else if(textFlog.getText().equals("")){
                    String s="Write down your login!";
                    JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
                }
                else if(a.equals("A")){
                    String d="You don't have any account!";
                    JOptionPane.showMessageDialog(null, d, "Error", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        buttonFcheck.setOnAction(event -> {
            String a=textFans.getText();
            DataBaseHeandler db=new DataBaseHeandler();
            try {
                String s=db.givePass(textFque.getText(),textFans.getText());
                    textFpass.setText(s);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

}
