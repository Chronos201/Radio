/**
 * Created by Chronos on 05/01/2016.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckingAuthentification implements ActionListener {

    public Connection conn;

    String login1, passwd;

    PreparedStatement statement = null;

    ResultSet resultat;

    public CheckingAuthentification(String login, String password) {
        login1 = login;
        passwd = password;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("OHOHOHHOHO");

        String driver = "com.mysql.jdbc.Driver";

        System.out.println(login1);
        System.out.println(passwd);

        String url = "jdbc:mysql://localhost:3306/quici";
        try {
            Class.forName(driver);
            System.out.println("Driver O.K.");
            Connection conn = DriverManager.getConnection(url, login1, passwd);
            System.out.println("Connexion effective !");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

}

