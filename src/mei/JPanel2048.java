package mei;

import java.awt.*;
import java.io.IOException;

import javax.swing.JPanel;

public class JPanel2048 extends JPanel {
    Game2048 newGame2048;
    public JPanel2048(Game2048 newGame2048)
    {
        this.newGame2048 = newGame2048;
        newGame2048.panel = this;
    }
    public void paint(Graphics g) {
        drawBoard(g);

        drawBlocks(g);

        score(g);

        try {
            if(newGame2048.winOrLose())
                gameOver(g);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (newGame2048.game[row][col] != null && newGame2048.game[row][col].number == 2048)
                    win(g);
            }
        }
    }

    public void drawBoard(Graphics g) {
        int panelWidth = this.getWidth();
        int blockWidth = panelWidth / 4 - 20;
        g.setColor(new Color(200,200,200));

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                g.fillRoundRect(10 + j * panelWidth / 4,10 + i * panelWidth / 4, blockWidth, blockWidth, 30,30);
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,this.getWidth(),this.getWidth());

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 80));
        g.drawString("GAME OVER", 60, 300);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("Final score: " + newGame2048.score, 150, 380);
    }

    public void win(Graphics g) {
        g.setColor(new Color(204, 255, 229));
        g.fillRect(0,0,this.getWidth(),this.getWidth());

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 80));
        g.drawString("You Win", 130, 300);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("Final score: " + newGame2048.score, 150, 380);
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

    public void score(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + newGame2048.score, 465, 620);
        g.setColor(new Color(233,86,86));
        g.drawString("Highest Score: " + newGame2048.highestScore, 10, 620);
    }

    public int sideValue() {
        return this.getWidth();
    }
}
