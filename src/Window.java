import com.mysql.jdbc.Statement;
import com.mysql.jdbc.*;
import com.sun.javafx.cursor.StandardCursorFrame;
import com.sun.xml.internal.bind.api.impl.NameConverter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.BorderLayout;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Created by Chronos on 03/01/2016.
 */
public class Window extends JFrame {
    private JTabbedPane onglet;
    private JEditorPane editorPane, apercu;
    private Connection conn;
    private String login;
    JLabel statusImage;
    JButton synchro;


    public Window(Connection conn, String login1) {
        this.conn = conn;
        login = login1;
        this.setLocationRelativeTo(null);
        this.setTitle("QUICI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);

        //Création de plusieurs Panneau
        //Panneau[] tPan = {new Panneau(), new Panneau(), new Panneau()};


        //Création de notre conteneur d'onglets
        onglet = new JTabbedPane();


        onglet.add(new Panneau());
        onglet.setIconAt((0), new ImageIcon("img\\CQI.jpg"));
        onglet.add(new Panneau());
        onglet.setIconAt((1), new ImageIcon("img\\Clients.jpg"));
        onglet.add(new Panneau());
        onglet.setIconAt((2), new ImageIcon("img\\Machines.jpg"));

        // Affichage de la synchronization
        synchro = new JButton(new ImageIcon("img\\synchronize.png"));
        synchro.setContentAreaFilled(false);
        synchro.setBounds(1118, 41, 64, 64);

        // Fetch les informations de l'utilisateur, affichage de son status
        //Création d'un objet Statement
        java.sql.Statement state;
        try {
            String name=null;
            state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery("SELECT STATUS,LOGIN FROM AUTHENTIFICATION WHERE LOGIN=login");
            System.out.printf("coco");
            while (result.next()) {
                System.out.printf("fesse");
                if (result.getString("status").equalsIgnoreCase("admin")) {
                    System.out.println(login);
                    statusImage = new JLabel (new ImageIcon("img\\admin.png"));
                    statusImage.setBounds(1010, 5, 70, 50);
                }
                if (result.getString("status").equalsIgnoreCase("rt")) {
                    System.out.println(login);
                    statusImage = new JLabel (new ImageIcon("img\\rt.png"));
                    statusImage.setBounds(1010, 5, 70, 50);
                }
                if (result.getString("status").equalsIgnoreCase("user")) {
                    System.out.println(login);
                    statusImage = new JLabel (new ImageIcon("img\\user.png"));
                    statusImage.setBounds(1010, 5, 70, 50);
                }




                if (!(result.getString("login").isEmpty())){
                    name = result.getString("login");
                }
            }
            statusImage.setFont(new Font("Aria",Font.PLAIN,10));
            statusImage.setText(name);
            statusImage.setHorizontalAlignment(SwingConstants.LEFT);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //Rajouter du texte depuis un fichier
        /*editorPane = new JEditorPane();
        editorPane.setEditable(false);
        String file = null;
        try {
            file = this.readFile("E:\\PFE\\test5-5.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        editorPane.setText(file);
        JScrollPane scrollPane = new JScrollPane(editorPane);
        onglet.add("Test 5.5",scrollPane);*/


        //On passe ensuite les onglets au content pane
        this.getContentPane().add(statusImage);
        this.getContentPane().add(synchro);
        this.getContentPane().add(onglet);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    // Pour lire les fichiers d'explication des divers tests et les afficher dans un conteneur
    public String readFile(String pathname) throws IOException {
        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int) file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }


}
