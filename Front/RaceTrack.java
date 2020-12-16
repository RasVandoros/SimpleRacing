package Front;

import Back.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaceTrack  extends JPanel implements ActionListener {

    //Constructor. Set up Panel and car locations.
    public RaceTrack(Car car1, Car car2){
        this.setLayout(null);
        car1.locationSet(375, 500);
        car2.locationSet(375, 550);
        this.add(car1);
        this.add(car2);
    }

    @Override
    public void paintComponent (Graphics g)
    {
        //Paint the racetrack.
        super.paintComponent(g);
        Color c1 = Color.green;
        g.setColor(c1);
        g.fillRect(150, 200, 550, 300);
        Color c2 = Color.black;
        g.setColor(c2);
        g.drawRect(50, 100, 750, 500); // outer edge
        g.drawRect(150, 200, 550, 300); //inner edge
        Color c3 = Color.yellow;
        g.setColor(c3);
        g.drawRect(100, 150, 650, 400); // mid-laner marker
        Color c4 = Color.white;
        g.setColor(c4);g.drawLine(425, 500, 425, 600); // start Line
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println(e.getActionCommand());
    }
}
