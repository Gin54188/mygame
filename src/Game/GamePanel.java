/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
/**
 *
 * @author yesho
 */
public class GamePanel extends JPanel {

    public GamePanel() {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.drawString("MyGame is running", 350, 300);
    }
}
