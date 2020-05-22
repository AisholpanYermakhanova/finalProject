package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class ModeratorPage extends Controll {
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
    void initialize(){
        ArrayList<String> arrayList = new ArrayList<>();
        DataBaseHeandler data=new DataBaseHeandler();
        buttonUpload.setOnAction(event -> {
            int p=0;
            p= Integer.parseInt(textIprice.getText());
            String MF="p";
            if(radioButtonIM.isSelected()){
                MF="m";
            }
            else if(radioButtonIF.isSelected()){
                MF="f";
            }
                Item item = new Item(textIType.getText(), textIname.getText(), textIDescription.getText(), p, MF, textIPhoto.getText());
                try {
                    data.addItem(item);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            if(!textIprice.equals("") && !textIname.equals("") && !textIDescription.equals("") && !MF.equals("") && !textIPhoto.equals("")){
                textIprice.setText("");
                textIname.setText("");
                textIDescription.setText("");
                textIPhoto.setText("");
                textIType.setText("");
            }
        });
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            change2(buttonBack,"sample");
        });
    }
    private static String url = "jdbc:mysql://localhost:3306/Users";
    private static String name = "root", pass = "";

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        ServerSocket serverSocket = new ServerSocket(1500);
        System.out.println("Server start work and wait client");
        Socket socket = serverSocket.accept();
        System.out.println("client is connected");
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        Scanner u = new Scanner(System.in);

        while (true) {
            String s = (String) input.readObject();
            System.out.println(s);
            String p="hello";
            if (s.equals(p)) {
                System.out.println("hi");
                String o="hi";
                output.writeObject(o);
            }
            else {
                String r=u.nextLine();
                output.writeObject(r);
            }

        }

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
