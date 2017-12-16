package mei;

import java.io.*;
import java.util.Stack;

public class Score {
    int num = 0;
    int highestScore = 0;
    public void readFromFile() throws FileNotFoundException, IOException {
        File file = new File("/Users/pinkey/Desktop/2048/score.txt");
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        while (br.readLine() != null) {
            num = Integer.parseInt(br.readLine());
            highestScore(num);
        }
        highestScore = highestScore(num);
        reader.close();
    }


    public int highestScore(int num) {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> maxStack = new Stack<Integer>();
        stack.push(num);
        if (maxStack.isEmpty())
            maxStack.push(num);

        else
            maxStack.push(Math.max(num, maxStack.peek()));

        return maxStack.peek();
    }
}

