package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecting {

    String Url = "jdbc:postgresql://localhost:5432/dao";
    String Username = "postgres";
    String Password = "postgres";
    String ClassName = "org.postgresql.Driver";
    Connection connect;

    public Connecting() {
    }

    public Connecting(String Url, String Username, String Password, String ClassName) {
        this.Url = Url;
        this.Username = Username;
        this.Password = Password;
        this.ClassName = ClassName;
    }

    public Connection connectionOpening() {
        try {
            Class.forName(ClassName);
            connect = DriverManager.getConnection(Url, Username, Password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }

    public void connectionClosing() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
