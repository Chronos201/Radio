/**
 * Created by Chronos on 05/01/2016.
 */


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

    /* Cette classe est l'interface d'affichage de la Connexion   */

public class Authentification extends JFrame implements ActionListener {

    public JLabel login, mdp;
    public JTextField login1;
    public JPasswordField mdp1;
    public JButton valider, annuler;
    public Connection conn;
    public PreparedStatement statement = null;
    public ResultSet resultat;


    public Authentification() {

        super();
        this.setTitle(" QUICI ");
        this.setSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        login = new JLabel("Login");
        login1 = new JTextField();

        mdp = new JLabel("Mot de Passe");
        mdp1 = new JPasswordField();

        valider = new JButton("Valider ");
        annuler = new JButton("Annuler");


        Container contenu = this.getContentPane();
        contenu.setLayout(null);

        contenu.add(login);
        login.setBounds(20, 20, 100, 20);

        contenu.add(login1);
        login1.setBounds(150, 20, 150, 20);

        contenu.add(mdp);
        mdp.setBounds(22, 55, 100, 20);

        contenu.add(mdp1);
        mdp1.setBounds(150, 55, 150, 20);

        contenu.add(valider);
        valider.setBounds(125, 100, 77, 20);

        contenu.add(annuler);
        annuler.setBounds(225, 100, 82, 20);

        valider.addActionListener(this);

        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String testLogin = login1.getText();
        String testPassword = mdp1.getText();
        System.out.println(testLogin);
        try {
            CheckingAuthentification ca = new CheckingAuthentification(testLogin,testPassword);
            ca.actionPerformed(e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

}




