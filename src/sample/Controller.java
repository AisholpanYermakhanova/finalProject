package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;

public class Controller extends Controll{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelAuto;

    @FXML
    private TextField textLogin;

    @FXML
    private TextField textPass;

    @FXML
    private Button buttonIn;

    @FXML
    private Button buttonReg;

    @FXML
    private Label labelTitle;

    @FXML
    private Button buttonForget;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        buttonReg.setOnAction(event -> {
            buttonReg.getScene().getWindow().hide();
            change2(buttonReg,"Registration");
        });

           buttonIn.setOnAction(event -> {
               String loginTT=textLogin.getText();
               String passwordD=textPass.getText();
               int t=0;
               if(textLogin.getText().equals("") && textPass.getText().equals("")){
                   String s="Write your account details";
                   t++;
                   JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
               }
               else if(textLogin.getText().equals("")) {
                   String s = "Write down your login!";
                   t++;
                   JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
               }
               else if(textPass.getText().equals("")){
                   String s = "Write down your password!";
                   t++;
                   JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
               }
               int o=10;
               DataBaseHeandler dd=new DataBaseHeandler();
               try {
                   if(t==0) {
                       o = dd.getUser(loginTT, passwordD);
                   }
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
               if(o==3){
                   change2(buttonIn, "MainPageShop"); // MainPageShop
                   buttonIn.getScene().getWindow().hide();
               }
               else if(o==2){
                   change2(buttonIn,"ModeratorPage");
                   buttonIn.getScene().getWindow().hide();
               }
               else if(o==1){
                   change2(buttonIn,"AdminPage");
                   buttonIn.getScene().getWindow().hide();
               }
               else {
                   Shake logAn=new Shake(textLogin);
                   Shake PasAn=new Shake(textPass);
                   logAn.PlayAnimation();
                   PasAn.PlayAnimation();
                   if(t==0) {
                       textLogin.setText("");
                       textPass.setText("");
                   }
               }
          });

           buttonForget.setOnAction(event -> {
               change2(buttonForget,"ForgetPage");
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
