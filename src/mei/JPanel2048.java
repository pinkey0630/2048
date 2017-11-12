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
//        int small = 0;
//        int f_height = 0;
//        int f_width = 0;

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
//        if(this.getWidth() < this.getHeight()) {
//            small = this.getWidth();
//            f_height = this.getHeight();
//            g.fillRect(0, (f_height - small)/2, small, small);
//            g.setColor(Color.BLACK);
//            //heng xian
//            g.drawLine(0, (f_height - small)/2, small, (f_height - small)/2);
//            g.drawLine(0, (f_height - small)/2 + small/4, small, (f_height - small)/2 + small/4);
//            g.drawLine(0, (f_height - small)/2 + small/2, small, (f_height - small)/2 + small/2);
//            g.drawLine(0, (f_height - small)/2 + small*3/4, small, (f_height - small)/2 + small*3/4);
//            g.drawLine(0, (f_height - small)/2 + small, small, (f_height - small)/2 + small);
//            //shu xian
//            g.drawLine(0, (f_height - small)/2, 0, (f_height - small)/2 + small);
//            g.drawLine(small/4, (f_height - small)/2, small/4, (f_height - small)/2 + small);
//            g.drawLine(small/2, (f_height - small)/2, small/2, (f_height - small)/2 + small);
//            g.drawLine(small*3/4, (f_height - small)/2, small*3/4, (f_height - small)/2 + small);
//            g.drawLine(small, (f_height - small)/2, small, (f_height - small)/2 + small);
//        }else if(this.getWidth() > this.getHeight()){
//            small = this.getHeight();
//            f_width = this.getWidth();
//            g.fillRect((f_width - small)/2, 0, small, small);
//            g.setColor(Color.BLACK);
//            //heng xian
//            g.drawLine((f_width - small)/2, 0, (f_width - small)/2 + small, 0);
//            g.drawLine((f_width - small)/2, small/4, (f_width - small)/2 + small, small/4);
//            g.drawLine((f_width - small)/2, small/2, (f_width - small)/2 + small, small/2);
//            g.drawLine((f_width - small)/2, small*3/4, (f_width - small)/2 + small, small*3/4);
//            g.drawLine((f_width - small)/2, small, (f_width - small)/2 + small, small);
//            //shu xian
//            g.drawLine((f_width - small)/2, 0, (f_width - small)/2, small);
//            g.drawLine((f_width - small)/2 + small/4, 0, (f_width - small)/2 + small/4, small);
//            g.drawLine((f_width - small)/2 + small/2, 0, (f_width - small)/2 + small/2, small);
//            g.drawLine((f_width - small)/2 + small*3/4, 0, (f_width - small)/2 + small*3/4, small);
//            g.drawLine((f_width - small)/2 + small, 0, (f_width - small)/2 + small, small);
//
//        }

    }

    public void drawBlocks(Graphics g)
    {
        for(int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (newGame2048.game2048[i][j] != null)
                {   newGame2048.game2048[i][j].drawMe(g);
                }
            }
        }
    }

    public int sideValue() {
        return this.getWidth();
    }
}
