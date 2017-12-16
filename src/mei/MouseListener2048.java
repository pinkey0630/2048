package mei;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListener2048 implements MouseListener {
    Game2048 game;
    Button buttons;

    public MouseListener2048(Game2048 game, Button buttons) {
        this.game = game;
        this.buttons = buttons;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.newGame();
        System.out.println("Mouse success");

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
