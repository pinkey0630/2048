package mei;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
            Game2048 game = new Game2048();
            game.randomGenerator();
            KeyControl2048 key = new KeyControl2048(game);
            mei.JFrame2048 frame = new mei.JFrame2048();
            JPanel2048 panel = new JPanel2048(game);
            frame.addKeyListener(key);
            frame.add(panel, BorderLayout.CENTER);

    }
}
