package mei;

import java.awt.*;
import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
            Game2048 game = new Game2048();
            mei.JFrame2048 frame = new mei.JFrame2048();
            JPanel2048 panel = new JPanel2048(game);
            KeyControl2048 key = new KeyControl2048(game);
            Button button = new Button(game, panel);
            MouseListener2048 mouse = new MouseListener2048(game, button);

            panel.addMouseListener(mouse);
            frame.addKeyListener(key);
            frame.add(panel, BorderLayout.CENTER);
            button.setPreferredSize(new Dimension(20,20));
            frame.add(button, BorderLayout.SOUTH);
            frame.setLocationRelativeTo(null);
            game.randomGenerator();
            game.readFromFile();
    }
}
