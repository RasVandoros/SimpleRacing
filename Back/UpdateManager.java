package Back;


import Front.RaceFrame;
import Front.RaceTrack;
import javax.swing.*;

public class UpdateManager {
    Timer timer;
    Car car1;
    Car car2;

    public UpdateManager(Car car1, Car car2){
        this.car1 = car1;
        this.car2 = car2;
        car1.locationSet(375, 500);
        car2.locationSet(375,550);
        //Initiate timer and set delay between updates
        timer = new Timer(10, e-> Update());
        timer.start();
        //Set up panel and frame
        RaceTrack raceTrack = new RaceTrack(car1, car2);
        RaceFrame frame = new RaceFrame(raceTrack, car1, car2);
    }
    
    //Update method is run using the timer. Turns the car left and then updates.
    private void Update(){
        this.car1.Update();
        this.car2.Update();
    }
}
