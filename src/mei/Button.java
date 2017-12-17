package mei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Button extends JButton implements ActionListener {
    Game2048 game;
    JPanel2048 panel;

    private static final int BUTTON_LOCATION_X = 180;
    private static final int BUTTON_LOCATION_Y = 500;
    private static final int BUTTON_SIZE_X = 140;
    private static final int BUTTON_SIZE_Y = 50;

    public Button (Game2048 game, JPanel2048 panel) {
        this.game = game;
        this.panel = panel;
        this.setBorderPainted(false);
        this.setFont(new Font("Arial",1,14));
        this.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y);
        this.setText("NEW GAME");
        this.addActionListener(this);
        this.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Restart the game");
        game.newGame();
        game.gameOver = false;
        game.score = 0;
        game.randomGenerator();
        try {
            game.readFromFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        panel.repaint();
        System.out.println("clicked");

    }
}
