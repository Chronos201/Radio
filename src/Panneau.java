/**
 * Created by Chronos on 03/01/2016.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel{
    private Color color = Color.lightGray;
    private static int COUNT = 0;
    private String message = "POPOPO";

    public Panneau() {

    }
    public void paintComponent(Graphics g){
    g.setColor(this.color);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    g.setFont(new Font("Arial", Font.BOLD, 15));
    g.drawString(this.message, 10, 20);
    // Synchronize circle
    g.drawOval(1100, 10, 35, 35);
}
}