import javax.swing.*;

public class Main {
    public static void Init() {
        JFrame window = new JFrame("Breakout");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game game = new Game();
        window.add(game);
        window.addKeyListener(game);

        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Init();
            }
        });
    }
}