package Front;
import Back.Car;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_UP;

public class RaceFrame extends JFrame implements KeyListener {

    Car car1;
    Car car2;

    //Constructor. Sets the frame and adds the cars.
    public RaceFrame (RaceTrack raceTrack, Car car1, Car car2){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 650);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(raceTrack);

        this.car1 = car1;
        this.car2 = car2;
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                car1.increaseSpeed();
                break;
            case KeyEvent.VK_DOWN:
                car1.decreaseSpeed();
                break;
            case KeyEvent.VK_LEFT:
                car1.turnLeft();
                break;
            case KeyEvent.VK_RIGHT:
                car1.turnRight();
                break;
            case KeyEvent.VK_W:
                car2.increaseSpeed();
                break;
            case KeyEvent.VK_S:
                car2.decreaseSpeed();
                break;
            case KeyEvent.VK_A:
                car2.turnLeft();
                break;
            case KeyEvent.VK_D:
                car2.turnRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
