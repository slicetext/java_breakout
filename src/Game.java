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

    public static List<Entity> entityList = new ArrayList<>();

    public Game() {
        setPreferredSize(new Dimension(TileSize * NumCols, TileSize * NumRows));

        // Init State
        entityList.add(new Block());

        // Update Loop
        Timer timer = new Timer(UpdateRate, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for(Entity e : entityList) {
            e.Update();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Entity e : entityList) {
            e.Draw(g, this);
        }

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
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}