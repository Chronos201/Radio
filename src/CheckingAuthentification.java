/**
 * Created by Chronos on 05/01/2016.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckingAuthentification implements ActionListener {

    private Connection conn;
    static Boolean working;
    private String login1;
    private String passwd;
    private String url;

    PreparedStatement statement = null;

    ResultSet resultat;

    public CheckingAuthentification(String login, String password, Boolean work) {
        setLogin1(login);
        setPasswd(password);
        working = work;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String driver = "com.mysql.jdbc.Driver";
        System.out.println(getLogin1());
        System.out.println(getPasswd());

        setUrl("jdbc:mysql://localhost:3306/quici");
        try {
            Class.forName(driver);
            System.out.println("Driver O.K.");
            Connection conn = DriverManager.getConnection(getUrl(), getLogin1(), getPasswd());
            System.out.println("Connexion effective !");
            working = true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }


    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getLogin1() {
        return login1;
    }

    public void setLogin1(String login1) {
        this.login1 = login1;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

