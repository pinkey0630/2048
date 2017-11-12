package mei;

import java.awt.*;

public class Block {
    int number;
    int row;
    int column;
    Color color;
    int small = 0;
    Game2048 game;
    public Block(int number, int row, int column, Color color, Game2048 game) {
        this.number = number;
        this.row = row;
        this.column =column;
        this.color = color;
        this.game = game;
    }

    public int getNumber() {
        return this.number;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public Color getColor() {
        return color;
    }

    public void drawMe(Graphics g)
    {
        int value = game.panel.sideValue();
        String letter = Integer.toString(number);
        g.setColor(color);
        g.fillRect(row * value/4, column * value / 4,
                value / 4 , value/4 );
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 40));
        g.drawString(letter, row * value / 4 + value / 10, column * value / 4 + value / 7);
    }
}
