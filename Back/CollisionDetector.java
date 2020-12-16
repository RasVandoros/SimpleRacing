package Back;

import java.awt.*;

public class CollisionDetector 
{
    Rectangle outerBound;
    Rectangle innerBound;
    
    //Constructor. Takes two rectangles as arguements (inner and outer racetrack limits)
    public CollisionDetector(Rectangle outerBound, Rectangle innerBound)
    {
        this.outerBound = outerBound;
        this.innerBound = innerBound;
    }

    //Detects collisions of the car with the racetrack. If the two collide, speed is set to 10%
    public float detectColl (double x, double y, float speed)
    {
        if (outerBound.contains(x, y) && !innerBound.contains(x, y))
        {
            return  1f;
        }
        return 0.1f;
    }
}