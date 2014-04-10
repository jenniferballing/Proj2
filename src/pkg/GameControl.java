package pkg;

import javax.swing.*;

/**
 * Created by JenniferBalling on 4/10/14.
 */
public class GameControl extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 400;

    public GameControl(){
        super ("Frogger: 2014");

        CarBoss panel = new CarBoss();
        setContentPane(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);

        panel.addCar();
    }

    public static void main (String [] args){
        new GameControl();
    }
}
