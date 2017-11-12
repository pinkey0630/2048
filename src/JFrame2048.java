package mei;

import javax.swing.*;
import java.awt.*;

public class JFrame2048 extends JFrame {
    public  JFrame2048(){
        this.setVisible(true);

        this.setSize(new Dimension(600,622));
        this.setResizable(false);
        this.setTitle("2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
