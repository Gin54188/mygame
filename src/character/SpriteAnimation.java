/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;
import java.awt.image.BufferedImage;
/**
 *
 * @author yesho
 */
public class SpriteAnimation {

    private BufferedImage[] frames;
    private int currentFrame = 0;

    public SpriteAnimation(BufferedImage sheet, int frameWidth, int frameHeight, int frameCount) {
        frames = new BufferedImage[frameCount];

        int cols = sheet.getWidth() / frameWidth;

        for (int i = 0; i < frameCount; i++) {
            int x = (i % cols) * frameWidth;
            int y = (i / cols) * frameHeight;
            frames[i] = sheet.getSubimage(x, y, frameWidth, frameHeight);
        }
    }

    public BufferedImage getFrame() {
        return frames[currentFrame];
    }

    public void nextFrame() {
        currentFrame = (currentFrame + 1) % frames.length;
    }
}
