import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Game extends JPanel implements ActionListener, KeyListener {
    public static final int TileSize = 30;
    public static final int NumCols = 20;
    public static final int NumRows = 20;
    public static final int UpdateRate = 16;
    public static final Vector2 BlockCount = new Vector2(10, 3);

    public static List<Entity> entityList = new ArrayList<>();
    public static Ball ball;
    public static Entity paddle;

    public Game() {
        setPreferredSize(new Dimension(TileSize * NumCols, TileSize * NumRows));

        // Init State
        // Make 10 * 3 grid of blocks
        for(int i = 0; i < BlockCount.y; i++) {
            for(int j = 0; j < BlockCount.x * 2; j+=2) {
                entityList.add(new Block(j * TileSize, i * TileSize));
            }
        }
        // Make paddle
        paddle = new Paddle();

        // Make ball
        ball = new Ball();

        // Call Start function
        for(Entity e : entityList) {
            e.Start();
        }
        paddle.Start();
        ball.Start();
        // Update Loop
        Timer timer = new Timer(UpdateRate, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Update blocks
        for(int e_index = 0; e_index < entityList.size(); e_index++) {
            Entity e = entityList.get(e_index);
            e.Update();
            // Collision
            // Bottom
            if ( e.position.x <= ball.position.x && e.position.x + 60 >= ball.position.x && ball.position.y == e.position.y + 30) {
                ball.velocity.y = -1;
                entityList.remove(e_index);
            }
            // Top
            if ( e.position.x <= ball.position.x && e.position.x + 60 > ball.position.x && ball.position.y + 15 == e.position.y) {
                ball.velocity.y = 1;
                entityList.remove(e_index);
            }
            // Left
            if ( e.position.y <= ball.position.y && e.position.y + 30 > ball.position.y && ball.position.x + 15 == e.position.x) {
                ball.velocity.x = -1;
                entityList.remove(e_index);
            }
            // Right
            if ( e.position.y <= ball.position.y && e.position.y + 30 > ball.position.y && ball.position.x == e.position.x + 60) {
                ball.velocity.x = 1;
                entityList.remove(e_index);
            }
        }
        // Update ball
        ball.Update();
        // Update paddle
        paddle.Update();
        // Paddle Collisions
        if ( paddle.position.x <= ball.position.x && paddle.position.x + 120 >= ball.position.x && ball.position.y + 30 == paddle.position.y + 15) {
            ball.velocity.y = -1;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Change bg color
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        for(Entity e : entityList) {
            e.Draw(g, this);
        }
        paddle.Draw(g, this);
        ball.Draw(g, this);

        // Smooths animations
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        for(Entity e : entityList) {
            e.OnKeyPress(keyEvent);
        }
        paddle.OnKeyPress(keyEvent);
        ball.OnKeyPress(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}