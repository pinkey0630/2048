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
        g.setColor(changeColor());
        g.fillRect(row * value / 4, column * value / 4,
                value / 4 , value / 4 );
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 40));
        g.drawString(letter, row * value / 4 + value / 10, column * value / 4 + value / 7);
    }

    public Color changeColor() {
        switch (number) {
            case 2:    return new Color(255,230,210);
            case 4:    return new Color(255,220,200);
            case 8:    return new Color(250,210,190);
            case 16:   return new Color(245,200,180);
            case 32:   return new Color(245,190,170);
            case 64:   return new Color(240,170,150);
            case 128:  return new Color(240,150,130);
            case 256:  return new Color(240,140,100);
            case 512:  return new Color(235,120,90);
            case 1024: return new Color(230,100,70);
            case 2048: return new Color(230,80,50);
        }
        return new Color(240,240,240);
    }
}
