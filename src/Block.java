import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

public class Block extends Entity {
    public Block() {
        LoadImage(new File("sprites/block.png"));
    }

    @Override
    void Start() {
        System.out.println("Hello, World");
    }

    @Override
    void Update() {
    }

    @Override
    void Draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                image,
                position.x * Game.TileSize,
                position.y * Game.TileSize,
                observer
        );
    }

    @Override
    void OnKeyPress(KeyEvent e) {
    }
}