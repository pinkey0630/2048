package mei;

public class Game2048 {

    Block[][] game2048 = new Block[4][4];
    public Game2048() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                game2048[i][j] = null;
        }

    public void randomGenerator() {
        int row = (int) (Math.random() * 4);
        int col = (int) (Math.random() * 4);
        if ((int)Math.random() * 2 == 0)
            game2048[row][col].number = 2;
        else
            game2048[row][col].number = 4;
    }

//    public void movement(int keyCode) {
//
//        switch (keyCode) {
//            //left arrow key
//            case 37:
//                for (int i = 0; i < 4; i++) {
//                    for (int j = 3; j > 0; j--) {
//                        if (game2048[i][j] != null) {
//                            while (game2048[i][j-1] == null && j > 0)
//                                j--;
//                            }
//                        }
//                    }
//                    break;
//            //up arrow key
//            case 38:
//                for (int i = 3; i > 0; i--) {
//                    for (int j = 0; j < 4; j++) {
//                        if (game2048[i][j] != null) {
//                            while (game2048[i-1][j] == null && i > 0)
//                                i--;
//                        }
//                    }
//                }
//                break;
//            //right arrow key
//            case 39:
//                for (int i = 0; i < 4; i++) {
//                    for (int j = 0; j < 4; j++) {
//                        if (game2048[i][j] != null) {
//                            while (game2048[i][j+1] == null && j < 3)
//                                j++;
//                        }
//                    }
//                }
//                break;
//            //down arrow key
//            case 40:
//                for (int i = 0; i < 4; i++) {
//                    for (int j = 0; j < 4; j++) {
//                        if (game2048[i+1][j] != null) {
//                            while (game2048[i][j] == null && i < 3)
//                            i++;
//                        }
//                    }
//                }
//                break;
//            default:
//                System.out.println("Please operate only with UP, DOWN, RIGHT, and LEFT");
//                break;
//                }
//        }

    public void Calculation(int keyCode) {
        switch (keyCode) {
            //left arrow key
            case 37:
                for (int i = 0; i < 4; i++) {
                    for (int j = 3; j > 0; j--) {
                        if(winOrLose(i, j) == false) break;
                        if (game2048[i][j] != null && j > 0) {
                            while (game2048[i][j-1].number == game2048[i][j].number) {
                                game2048[i][j-1].number += game2048[i][j].number;
                                game2048[i][j] = null;
                                j--;
                            }
                        }
                    }
                }
                break;
            //up arrow key
            case 38:
                for (int i = 3; i > 0; i--) {
                    for (int j = 0; j < 4; j++) {
                        if(winOrLose(i, j) == false) break;
                        if (game2048[i][j] != null && i > 0) {
                            while (game2048[i-1][j].number == game2048[i][j].number) {
                                game2048[i-1][j].number += game2048[i][j].number;
                                game2048[i][j] = null;
                                i--;
                            }
                        }
                    }
                }
                break;
            //right arrow key
            case 39:
                for (int i = 0; i < 4; i++) {
                    for(int j = 0; j < 4; j++) {
                        if(winOrLose(i, j) == false) break;
                        if (game2048[i][j] != null && j < 3) {
                            while (game2048[i][j+1].number == game2048[i][j].number) {
                                game2048[i][j+1].number += game2048[i][j].number;
                                game2048[i][j] = null;
                                j++;
                            }
                        }

                    }
                }
                break;

            //down arrow key
            case 40:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if(winOrLose(i, j) == false) break;
                        if (game2048[i][j] != null & i < 3) {
                            while (game2048[i+1][j].number == game2048[i][j].number) {
                                game2048[i+1][j].number += game2048[i][j].number;
                                game2048[i][j] = null;
                                i++;
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Please operate only with UP, DOWN, RIGHT, and LEFT keys.");
                break;
        }
    }

    public boolean winOrLose(int row, int col) {
        int count = 0;
        for (row = 0; row < 4; row++) {
            for (col = 0; col < 4; col++) {
                if (game2048[row][col].number == 2048) {
                    return false;
                } else if (game2048[row][col] != null) {
                    count++;
                }
            }
        }
        if (count == 16)
            return false;
        else
        return true;
    }
}
