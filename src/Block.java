import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

public class Block extends Entity {
    public Block(int x, int y) {
        position = new Vector2(x, y);
        LoadImage(new File("sprites/block.png"));
    }

    @Override
    void Start() {
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