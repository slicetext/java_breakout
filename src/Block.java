import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

public class Block extends Entity {
    public Block(int x, int y) {
        position = new Vector2(x, y);
    }

    @Override
    void Start() {
        LoadImage(new File("sprites/block.png"));
    }

    @Override
    void Update() {
    }

    @Override
    void OnKeyPress(KeyEvent e) {
    }
}