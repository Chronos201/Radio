import com.sun.javafx.cursor.StandardCursorFrame;
import com.sun.xml.internal.bind.api.impl.NameConverter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.*;
import java.awt.BorderLayout;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 * Created by Chronos on 03/01/2016.
 */
public class Window extends JFrame{
    private JTabbedPane onglet;
    private JEditorPane editorPane, apercu;

    public Window(){
        this.setLocationRelativeTo(null);
        this.setTitle("QUICI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 600);

        //Création de plusieurs Panneau
        Panneau[] tPan = {   new Panneau(), new Panneau(), new Panneau()};

        //Création de notre conteneur d'onglets
        onglet = new JTabbedPane();


        onglet.add(new Panneau());
        onglet.setIconAt((0), new ImageIcon("E:\\PFE\\img\\CQI.jpg"));
        onglet.add(new Panneau());
        onglet.setIconAt((1), new ImageIcon("E:\\PFE\\img\\Clients.jpg"));
        onglet.add(new Panneau());
        onglet.setIconAt((2), new ImageIcon("E:\\PFE\\img\\Machines.jpg"));
        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        String file = null;
        try {
            file = this.readFile("E:\\PFE\\test5-5.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        editorPane.setText(file);
        JScrollPane scrollPane = new JScrollPane(editorPane);
        onglet.add("Test 5.5",scrollPane);
        //On passe ensuite les onglets au content pane
        this.getContentPane().add(onglet);
        this.setVisible(true);
    }

    public static void main(String[] args){
        Authentification identification = new Authentification();


        //Window fen = new Window();
    }

    public String readFile(String pathname) throws IOException{
        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int)file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }
}
