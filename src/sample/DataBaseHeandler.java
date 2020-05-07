package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DataBaseHeandler {
    public static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/bd";
    private static String namee = "root", passs = "";

    public static void SignIn(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, namee, passs);
        try {
            String queryInsert = "INSERT INTO bd.users(id,name,login,password,question,answer,role) VALUES(NULL ,?,?,?,?,?,?)";
            PreparedStatement pr = connection.prepareStatement(queryInsert);
            pr.setString(1, user.getName());
            pr.setString(2, user.getLogin());
            pr.setString(3, user.getPassword());
            pr.setString(4, user.getQuestion());
            pr.setString(5, user.getAnswer());
            pr.setInt(6, 3);
            //3-user 1-admin 2-meneger
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addItem(Item item) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, namee, passs);
        try {
            String queryInsert = "INSERT INTO bd.item(id,type,name,description,price,FM,picture) VALUES(NULL ,?,?,?,?,?,?)";
            PreparedStatement pr = connection.prepareStatement(queryInsert);
            pr.setString(1, item.getTypeI());
            pr.setString(2, item.getNamel());
            pr.setString(3, item.getDescription());
            pr.setDouble(4, item.getPrice());
            pr.setString(5, item.getMf());
            pr.setString(6, item.getPicture());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddModerator(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, namee, passs);
        String s=user.getLogin()+": "+user.getPassword();

        try {
            String queryInsert = "INSERT INTO bd.users(id,name,login,password,question,answer,role) VALUES(NULL ,?,?,?,?,?,?)";
            PreparedStatement pr = connection.prepareStatement(queryInsert);
            pr.setString(1, user.getName());
            pr.setString(2, user.getLogin());
            pr.setString(3, user.getPassword());
            pr.setString(4, user.getQuestion());
            pr.setString(5, user.getAnswer());
            pr.setInt(6, 2);
            //3-user 1-admin 2-moderator
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static int getUser(String loginA, String pas) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, namee, passs);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *from bd.users");
        int y=0;
        while (resultSet.next()) {
            String login=resultSet.getString(3);
            String pasw=resultSet.getString(4);
            int role=resultSet.getInt(7);
            if (login.equals(loginA) && pasw.equals(pas) && role==3) {
                y=3;
            }
            else if(login.equals(loginA) && pasw.equals(pas) && role==1){
                y=1;
            }
            else if(login.equals(loginA) && pasw.equals(pas) && role==2){
                y=2;
                String s=login+": "+pasw;
            }
            }
        return y;
    }
    public static ArrayList<String> updateModerators() throws ClassNotFoundException, SQLException {
        ArrayList<String> ss=new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, namee, passs);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *from bd.users");
        while (resultSet.next()) {
            String login = resultSet.getString(3);
            String pasw = resultSet.getString(4);
            int role=resultSet.getInt(7);
            if ( role == 2) {
                String s = login + ": " + pasw;
                ss.add(s);
            }
        }
        return ss;
    }
    public static void removeModerator(String login) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, namee, passs);
        PreparedStatement pr = connection.prepareStatement("DELETE FROM bd.users WHERE login=?");
        pr.setString(1,login);
        pr.executeUpdate();
        pr.close();
    }
    public static String  getQuestion(String loginnn) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, namee, passs);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *from bd.users");
        String q="Not found";
        int i=0;
        String a="";
        while (resultSet.next()) {
            String login1 = resultSet.getString(3);
            if (loginnn.equals(login1)) {
                a=resultSet.getString(5);
                i++;
            }
        }
        if(i!=0){
            return a;
        }
        else {
            return q;
        }
    }
    public static String givePass(String q, String a) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, namee, passs);
        Statement statement = connection.createStatement();
        int u=0;
        String p="incorrect answer";
        ResultSet resultSet = statement.executeQuery("SELECT *from bd.users");
        while (resultSet.next()) {
            String ques = resultSet.getString(5);
            String anns = resultSet.getString(6);
            if(q.equals(ques) && anns.equals(a)){
                p=resultSet.getString(4);
                u++;
            }
        }
        if(u!=0){
            return p;
        }
        else {
            return p;
        }
    }
    public static HashMap<Integer,String> getItems() throws ClassNotFoundException, SQLException {
        HashMap<Integer,String> hashMap=new HashMap<>();
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, namee, passs);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *from bd.item");
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String  picture=resultSet.getString(7);
            hashMap.put(id,picture);
        }
        return hashMap;
    }

}
