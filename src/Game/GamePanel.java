/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import character.SpriteAnimation;
/**
 *
 * @author yesho
 */
public class GamePanel extends JPanel {

    // -------------------------
    // 三个动作动画
    // -------------------------
    private SpriteAnimation idleAnimation;
    private SpriteAnimation runAnimation;
    private SpriteAnimation jumpAnimation;
    private SpriteAnimation currentAnimation;

    // 玩家位置和大小
    private int playerX = 350;
    private int playerY = 250;
    private int playerWidth = 64;
    private int playerHeight = 70;

    // 速度和跳跃
    private int velX = 0;
    private int velY = 0;
    private boolean jumping = false;
    private int jumpStrength = -12; // 跳跃初速度
    private int gravity = 1;        // 重力加速度
    private int groundY = 400;      // 地面Y坐标

    // 玩家朝向
    private boolean facingRight = true;

    public GamePanel() {
        setBackground(Color.BLACK);

        
        idleAnimation = new SpriteAnimation("images/player.png", 64, 70);
        runAnimation = new SpriteAnimation("images/run.png", 80, 80);
        jumpAnimation = new SpriteAnimation("images/jump.png", 63, 64);

        currentAnimation = idleAnimation;

        // -------------------------
        // 定时器刷新动画和位置
     
        Timer timer = new Timer(20, e -> updateGame());
        timer.start();

        // -------------------------
        // 键盘监听
        // -------------------------
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A: // 向左
                        velX = -5;
                        facingRight = false;
                        break;
                    case KeyEvent.VK_D: // 向右
                        velX = 5;
                        facingRight = true;
                        break;
                    case KeyEvent.VK_SPACE: // 跳跃
                        if (!jumping) {
                            velY = jumpStrength;
                            jumping = true;
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_D:
                        velX = 0; // 停止移动
                        break;
                }
            }
        });
    }

    // -------------------------
    // 游戏更新逻辑
    // -------------------------
    private void updateGame() {
        // 更新水平位置
        playerX += velX;

        // 更新垂直位置（跳跃+重力）
        playerY += velY;
        if (playerY < groundY) {
            velY += gravity; // 下落
        } else {
            playerY = groundY; // 落地
            velY = 0;
            jumping = false;
        }

        // -------------------------
        // 根据状态切换动画
        // -------------------------
        if (jumping) {
            currentAnimation = jumpAnimation;
        } else if (velX != 0) {
            currentAnimation = runAnimation;
        } else {
            currentAnimation = idleAnimation;
        }

        // 切换动画帧
        currentAnimation.nextFrame();

        // 重绘
        repaint();
    }

    // -------------------------
    // 绘制
    // -------------------------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage frame = currentAnimation.getCurrentFrame();

        // 左右翻转
        if (!facingRight) {
            g.drawImage(frame, playerX + playerWidth, playerY, -playerWidth, playerHeight, null);
        } else {
            g.drawImage(frame, playerX, playerY, playerWidth, playerHeight, null);
        }

        // 可选：画地面
        g.setColor(Color.GREEN);
        g.fillRect(0, groundY + playerHeight, getWidth(), getHeight() - groundY);
    }
}