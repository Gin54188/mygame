/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import character.SpriteAnimation;
import util.ImageLoader;
/**
 *
 * @author yesho
 */
public class GamePanel extends JPanel {

    private SpriteAnimation animation;
    private Timer timer;

    public GamePanel() {
        setBackground(Color.BLACK);

        // ️ 修改为你自己的 sprite sheet 路径
        BufferedImage spriteSheet = ImageLoader.loadImage("images/player.png");

        // ️ 修改为你素材的真实参数
        // frameWidth, frameHeight, totalFrames
        animation = new SpriteAnimation(spriteSheet, 64, 64, 8);

        timer = new Timer(120, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animation.nextFrame();
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(animation.getFrame(), 350, 250, null);
    }
}
