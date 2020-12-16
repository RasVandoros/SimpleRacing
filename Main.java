import Back.Car;
import Back.CollisionDetector;
import Back.UpdateManager;
import java.awt.*;

public class Main {

    //Entry point
    public static void main(String[] args)
    {
        //Set up collider to match inner and outer box of the racetrack.
        CollisionDetector racetrackCollider = new CollisionDetector(new Rectangle(30,80,740,510), (new Rectangle(120,170,560,310)));
        //Initiate manager instance and the two cars. 
        UpdateManager instance = new UpdateManager(new Car("orange",racetrackCollider), new Car("blue",racetrackCollider));
    }
}
