import java.awt.event.KeyEvent;
import java.io.File;

public class Ball extends Entity {
    final public int speed = 1;
    public Vector2 velocity = new Vector2(1, -speed);

    @Override
    void Start() {
        LoadImage(new File("sprites/ball.png"));
        position = new Vector2(5 * Game.TileSize, 7 * Game.TileSize);
    }

    @Override
    void Update() {
        // Update pos according to velocity
        position.x += velocity.x;
        position.y += velocity.y;
        // Collisions with walls
        // Top wall
        if (position.y <= 0) {
            velocity = new Vector2(velocity.x, speed);
        }
        // Left wall and Right wall
        if (position.x <= 0) {
            velocity = new Vector2(speed, velocity.y);
        } else if (position.x + image.getWidth() >= Game.TileSize * Game.NumRows) {
            velocity = new Vector2(-speed, velocity.y);
        }
    }

    @Override
    void OnKeyPress(KeyEvent e) {
    }
}