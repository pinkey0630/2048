package mei;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class Game2048 {

    JPanel2048 panel;
    Block[][] game = new Block[4][4];
    boolean gameOver = false;
    int score = 0;
    int highestScore = 0;
//    public Game2048() {
//        for (int i = 0; i < 4; i++)
//            for (int j = 0; j < 4; j++)
//                game[i][j] = null;
//    }

    public void newGame() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                game[i][j] = null;
            }
        }
    }


    // random generate a block
    public void randomGenerator() {
        int row = (int) (Math.random() * 4);
        int col = (int) (Math.random() * 4);
        while(game[row][col] != null) {
            row = (int) (Math.random() * 4);
            col = (int) (Math.random() * 4);
        }
        if ((int) (Math.random() * 2) == 0) {
            game[row][col] = new Block(2, row, col, new Color(250,228,228), this);
        } else
            game[row][col] = new Block(4, row, col,
                    new Color(247,210,210), this);
    }


    //move blocks and add numbers when two neighbor blocks have the same number
    public void Calculation(int keyCode) throws IOException {
        if(gameOver)
            return;
        switch (keyCode) {
            //left arrow key, i-column, j-row;
            case 37:
                System.out.println("left");
                for (int i = 1; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (i > 0 && game[i][j] != null) {
                            if (game[i-1][j] == null) {
                                while (i > 0 && game[i-1][j] == null) {
                                    game[i-1][j] = game[i][j];
                                    game[i][j] = null;
                                    game[i-1][j].row = game[i-1][j].row - 1;
                                    i--;
                                    while (i > 0 && game[i-1][j] != null
                                            && blockValue(i-1,j) == blockValue(i,j)) {
                                        game[i-1][j].number += game[i][j].number;
                                        score += blockValue(i-1, j);
                                        game[i][j] = null;
                                        i--;
                                    }
                                }
                            } else if (blockValue(i-1,j) == blockValue(i,j)) {
                                game[i-1][j].number += game[i][j].number;
                                score += blockValue(i-1, j);
                                game[i][j] = null;
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

                        if (j > 0 && game[i][j] != null) {
                            if (game[i][j-1] == null) {
                                while (j > 0 && game[i][j-1] == null) {
                                    game[i][j-1] = game[i][j];
                                    game[i][j] = null;
                                    game[i][j-1].column = game[i][j-1].column - 1;
                                    j--;
                                    while (j > 0 && game[i][j-1] != null
                                            && blockValue(i,j-1) == blockValue(i,j)) {
                                        game[i][j-1].number += game[i][j].number;
                                        score += blockValue(i,j-1);
                                        game[i][j] = null;
                                        j--;
                                    }
                                }
                            } else if (blockValue(i,j-1) == blockValue(i,j)) {
                                game[i][j-1].number += game[i][j].number;
                                score += blockValue(i,j-1);
                                game[i][j] = null;
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
                        if (i < 3 && game[i][j] != null) {
                            if (game[i+1][j] == null) {
                                while (i < 3 && game[i+1][j] == null) {
                                    game[i+1][j] = game[i][j];
                                    game[i][j] = null;
                                    game[i+1][j].row = game[i+1][j].row + 1;
                                    i++;
                                    while (i < 3 && game[i+1][j] != null
                                            && blockValue(i+1,j) == blockValue(i,j)) {
                                        game[i+1][j].number += game[i][j].number;
                                        score += blockValue(i+1,j);
                                        game[i][j] = null;
                                        i++;
                                    }
                                }
                            } else if (blockValue(i+1,j) == blockValue(i,j)) {
                                game[i+1][j].number += game[i][j].number;
                                score += blockValue(i+1,j);
                                game[i][j] = null;
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

                        if (j < 3 && game[i][j] != null) {
                            if (game[i][j+1] == null) {
                                while (j < 3 && game[i][j+1] == null) {
                                    game[i][j+1] = game[i][j];
                                    game[i][j] = null;
                                    game[i][j+1].column = game[i][j+1].column + 1;
                                    j++;
                                    while (j < 3 && game[i][j+1] != null &&
                                            blockValue(i,j+1) == blockValue(i,j)) {
                                        game[i][j+1].number += game[i][j].number;
                                        score += blockValue(i, j+1);
                                        game[i][j] = null;
                                        j++;
                                    }
                                }
                            } else if (blockValue(i,j+1) == blockValue(i,j)) {
                                game[i][j+1].number += game[i][j].number;
                                score += blockValue(i, j+1);
                                game[i][j] = null;
                                j++;
                            }
                        }
                    }
                }
                break;

            default:
                System.out.println("Please operate only " +
                        "with UP, DOWN, RIGHT, and LEFT keys.");
                break;
        }
        randomGenerator();
        panel.repaint();
        if (winOrLose())
        {
            writeToFile();
//            if (score > highestScore)
//                highestScore = score;
            System.out.println(score);
            gameOver = true;
            panel.repaint();
        }
    }
    //win or lose condition
    public boolean winOrLose() throws IOException {
        int count = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (game[row][col] != null && game[row][col].number == 2048) {
                    writeToFile();
                    return true;
                } else if (game[row][col] != null) {
                    count++;
                }
            }
        }
        if (count == 16) {
            for (int i = 1; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (blockValue(i,j) == blockValue(i-1,j) ||
                            blockValue(i,j) == blockValue(i+1,j) ||
                            blockValue(i,j) == blockValue(i,j-1) ||
                            blockValue(i,j) == blockValue(i,j+1))
                    return false;
                }
            }
            if (blockValue(0,0) == blockValue(0,1)
                    || blockValue(0,1) == blockValue(0,2) ||
                    blockValue(0,2) == blockValue(0,3))
                return false;
            else if (blockValue(0,0) == blockValue(1,0)
                    || blockValue(1,0) == blockValue(2,0) ||
                    blockValue(2,0) == blockValue(3,0))
                return false;
            else if (blockValue(0,3) == blockValue(1,3)
                    || blockValue(1,3) == blockValue(2,3) ||
                   blockValue(2,3) == blockValue(3,3))
                return false;
            else if (blockValue(3,0) == blockValue(3,1)
                    || blockValue(3,1) == blockValue(3,2) ||
                    blockValue(3,2) == blockValue(3,3))
                return false;
            else
                return true;
        }
        else
            return false;
    }
    public int blockValue(int rol, int col) {
        return game[rol][col].number;
    }

    public void writeToFile() throws IOException {
        File file = new File("/Users/pinkey/Desktop/2048/score.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(file, true));
        byte[] highScore = String.valueOf(score).getBytes();
        writer.write(highScore);
        writer.write('\n');
        writer.close();
    }

    public int readFromFile() throws FileNotFoundException, IOException {
        ArrayList<Integer> scoreHistory = new ArrayList<Integer>();
        File file = new File("/Users/pinkey/Desktop/2048/score.txt");
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            scoreHistory.add(Integer.parseInt(line));
        }
        highestScore = scoreHistory.get(0);
        for (int i = 0; i < scoreHistory.size(); i++) {
            if (scoreHistory.get(i) > highestScore)
                highestScore = scoreHistory.get(i);
        }
        reader.close();
        return highestScore;
    }


//    public int highestScore(int num) {
//        Stack<Integer> stack = new Stack<Integer>();
//        Stack<Integer> maxStack = new Stack<Integer>();
//        stack.push(num);
//        if (maxStack.isEmpty())
//            maxStack.push(num);
//
//        else
//            maxStack.push(Math.max(num, maxStack.peek()));
//        highestScore = maxStack.peek();
//
//        return highestScore;
//    }
}

