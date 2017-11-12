package mei;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.*;

public class Game2048 {

    JPanel2048 panel;
    Block[][] game2048 = new Block[4][4];
    boolean gameover = false;
    public Game2048() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                game2048[i][j] = null;
        }
    // random generate a block
    public void randomGenerator() {
        int row = (int) (Math.random() * 4);
        int col = (int) (Math.random() * 4);
        while(game2048[row][col] != null) {
            row = (int) (Math.random() * 4);
            col = (int) (Math.random() * 4);
        }
            if ((int) (Math.random() * 2) == 0) {
                game2048[row][col] = new Block(2, row, col, Color.PINK, this);
            } else
                game2048[row][col] = new Block(4, row, col, Color.GRAY, this);
    }


    //move blocks and add numbers when two neighbor blocks have the same number
    public void Calculation(int keyCode) {
        if(gameover)
            return;
        switch (keyCode) {
            //left arrow key, i-column, j-row;
            case 37:
                System.out.println("left");
                for (int i = 1; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        //if (winOrLose(i, j) == false) break;
                        if (i > 0 && game2048[i][j] != null) {
                            if (game2048[i-1][j] == null) {
                                while (i > 0 && game2048[i-1][j] == null) {
                                    game2048[i-1][j] = game2048[i][j];
                                    game2048[i][j] = null;
                                    game2048[i-1][j].row = game2048[i-1][j].row - 1;
                                    i--;
                                }
                            } else if (game2048[i-1][j].number == game2048[i][j].number) {
                                    game2048[i-1][j].number += game2048[i][j].number;
                                    game2048[i][j] = null;
                                    i--;
                                }
                        }
                    }
                }
                break;
            //up arrow key, i-column, j-row
            case 38:
                System.out.println("up");
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; j < 4; j++) {
                        //if(winOrLose(i, j) == false) break;

                        if (j > 0 && game2048[i][j] != null) {
                            if (game2048[i][j-1] == null) {
                                while (j > 0 && game2048[i][j-1] == null) {
                                    game2048[i][j-1] = game2048[i][j];
                                    game2048[i][j] = null;
                                    game2048[i][j-1].column = game2048[i][j-1].column - 1;
                                    j--;
                                }
                            } else if (game2048[i][j-1].number == game2048[i][j].number) {
                                    game2048[i][j-1].number += game2048[i][j].number;
                                    game2048[i][j] = null;
                                    j--;
                                }
                        }
                    }
                }
                break;
            //right arrow key, i-column, j-row
            case 39:
                System.out.println("right");
                for (int i = 3; i >= 0; i--) {
                    for(int j = 0; j < 4; j++) {
                        //if(winOrLose(i, j) == false) break;
                        if (i < 3 && game2048[i][j] != null) {
                            if (game2048[i+1][j] == null) {
                                while (i < 3 && game2048[i+1][j] == null) {
                                    game2048[i+1][j] = game2048[i][j];
                                    game2048[i][j] = null;
                                    game2048[i+1][j].row = game2048[i+1][j].row + 1;
                                    i++;
                                }
                            } else if (game2048[i+1][j].number == game2048[i][j].number) {
                                    game2048[i+1][j].number += game2048[i][j].number;
                                    game2048[i][j] = null;
                                    i++;
                                }
                        }
                    }
                }
                break;

            //down arrow key, i-column, j-row
            case 40:
                System.out.println("down");
                for (int i = 0; i < 4; i++) {
                    for (int j = 3; j >= 0; j--) {
                        //if(winOrLose(i, j) == false) break;
                        if (j < 3 && game2048[i][j] != null) {
                            if (game2048[i][j+1] == null) {
                                while (j < 3 && game2048[i][j+1] == null) {
                                    game2048[i][j+1] = game2048[i][j];
                                    game2048[i][j] = null;
                                    game2048[i][j+1].column = game2048[i][j+1].column + 1;
                                    j++;
                                }
                            } else if (game2048[i][j+1].number == game2048[i][j].number) {
                                    game2048[i][j+1].number += game2048[i][j].number;
                                    game2048[i][j] = null;
                                    j++;
                                }
                        }
                    }
                }
                break;

            default:
                System.out.println("Please operate only with UP, DOWN, RIGHT, and LEFT keys.");
                break;
        }
        randomGenerator();
        panel.repaint();
        if (winOrLose())
        {
            gameover = true;
        }
    }
    //win or lose condition
    public boolean winOrLose() {
        int count = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (game2048[row][col] != null && game2048[row][col].number == 2048) {
                    return false;
                } else if (game2048[row][col] != null) {
                    count++;
                }
            }
        }
        if (count == 16)
            return true;
        else
        return false;
    }

}
