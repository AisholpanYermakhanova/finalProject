package sample;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;

public class help {

    @FXML
    public static ListView<String> listMes;

    @FXML
    public static TextField textMassage;

    @FXML
    public static Button buttonsend;


    @FXML
    public void initialize() {

    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1" , 1500);
        System.out.println("Client Start Working");
        Scanner scanner = new Scanner(System.in);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            while (true) {
                String s=scanner.nextLine();
                output.writeObject(s);
                System.out.println((String)input.readObject());

            }
    }
}


