package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationController extends Controll {

    @FXML
    private Button buttonBack;

    @FXML
    private Label labelReg;

    @FXML
    private TextField textName;

    @FXML
    private TextField textRLogin;

    @FXML
    private TextField textQues;

    @FXML
    private TextField textAns;

    @FXML
    private PasswordField textRPass;

    @FXML
    private Button buttonRAdd;

    @FXML
    public void initialize() {
        buttonRAdd.setOnAction(event -> {
            int t=0;
            DataBaseHeandler dataBaseHeandler=new DataBaseHeandler();
            User user =new User(textName.getText(),textRLogin.getText(),textRPass.getText(),textQues.getText(),textAns.getText());
            if(textName.getText().equals("") && textRLogin.getText().equals("") && textRPass.getText().equals("") && textQues.getText().equals("") && textAns.getText().equals("")){
                String s="All lines are required!";
                t++;
                JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
            }
             else if(textName.getText().equals("")){
                String s="You need to write your name!";
                t++;
                JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
            }
            else if(textRLogin.getText().equals("")){
                String s="You need to create your login :/";
                t++;
                JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
            }
            else if(textRPass.getText().equals("")){
                String s="You need to create password!";
                t++;
                JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
            }
            else if(textQues.getText().equals("")){
                String s="You need to give your personal verification question";
                t++;
                JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
            }
            else if(textAns.getText().equals("")){
                String s="You need to give right answer";
                t++;
                JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.PLAIN_MESSAGE);
            }
            try {
                if(t==0) {
                    dataBaseHeandler.SignIn(user);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(t==0) {
                textName.setText("");
                textRLogin.setText("");
                textRPass.setText("");
                textQues.setText("");
                textAns.setText("");
            }
        });

        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            change2(buttonBack, "sample");
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

