import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public abstract class Entity {
    Vector2 position = new Vector2(0, 0);
    BufferedImage image;
    abstract void Start();
    abstract void Update();
    abstract void Draw(Graphics g, ImageObserver observer);
    abstract void OnKeyPress(KeyEvent e);
    void LoadImage(File file) {
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Error opening image: "+e);
        }
    }
}