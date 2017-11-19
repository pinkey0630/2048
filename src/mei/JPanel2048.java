package mei;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanel2048 extends JPanel {
    Game2048 newGame2048;
    public JPanel2048(Game2048 newGame2048)
    {
        this.newGame2048 = newGame2048;
        newGame2048.panel = this;
    }
    public void paint(Graphics g) {

        int side = this.getWidth();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, side, side);
        g.setColor(Color.BLACK);
        //horizontal
        g.drawLine(0, 0, side, 0);
        g.drawLine(0, side / 4, side, side / 4);
        g.drawLine(0, side / 2, side, side / 2);
        g.drawLine(0, side * 3 / 4 , side, side * 3 / 4);
        g.drawLine(0, side, side, side);

        //vertical
        g.drawLine(0, 0, 0, side);
        g.drawLine(side / 4, 0, side / 4, side);
        g.drawLine(side / 2, 0, side / 2, side);
        g.drawLine(side * 3 / 4, 0, side * 3 / 4, side);
        g.drawLine(side, 0, side, side);
        //draw blocks
        drawBlocks(g);
    }

    public void drawBlocks(Graphics g)
    {
        for(int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (newGame2048.game[i][j] != null)
                {   newGame2048.game[i][j].drawMe(g);
                }
            }
        }
    }

    public int sideValue() {
        return this.getWidth();
    }
}
