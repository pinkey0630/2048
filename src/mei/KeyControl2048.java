package mei;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl2048 implements KeyListener {
    Game2048 newGame;
    public KeyControl2048(Game2048 newGame) {
        this.newGame = newGame;
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        newGame.movement(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
