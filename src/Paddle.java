import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.File;

class Paddle extends Entity {
    @Override
    void Start() {
        LoadImage(new File("sprites/paddle.png"));
        position = new Vector2(0, 10);
    }

    @Override
    void Update() {
    }

    @Override
    void OnKeyPress(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                position.x -= 1;
                break;
            case KeyEvent.VK_RIGHT:
                position.x += 1;
                break;
            default:
                break;
        }
    }
}