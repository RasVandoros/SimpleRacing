package Back;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Car extends JLabel 
{
    List<Icon> iconList;
    float speed = 0;
    int direction = 0;
    boolean directionChanged = false;
    int xDirChange = 0;
    int yDirChange = 0;
    double xPosition = 0;
    double yPosition = 0;
    CollisionDetector collisionDetector;


    //Constructor
    public Car (String colour, CollisionDetector collisionDetector)
    {
        //Create the list of Icons for the car
        this.iconList = getIconList(colour);
        //Set the initial car icon
        this.setIcon(iconList.get(0));
        this.setSize(this.getPreferredSize());
        this.collisionDetector = collisionDetector;
    }

    //Set the location of the car using coordinates x and y
    public void locationSet (int x, int y)
    {
        this.setLocation(x, y);
        this.xPosition = x;
        this.yPosition = y;
    }
    
    //Increase car speed. Upper limit set to 100. Step set to 5.
    public void increaseSpeed ()
    {
        speed += 5;
        if (speed > 100) 
        {
            speed = 100;
        }
    }
    
    //Decrease car speed. Lower limit set to -100. Step set to 5.
    public void decreaseSpeed ()
    {
        speed -= 5;
        if (speed < -100) 
        {
            speed = -100;
        }
    }
    
    //Turns the car left by adding 1 to the direction variable
    public void turnLeft()
    {
        direction += 1;
        //There are 16 direction icons, therefore when reaching the end of the list we need to reset the counter to go to the first icon
        if (direction > 15) 
        {
            direction = 0;
        }
        directionChanged = true;
    }
    
    public void turnRight()
    {
        direction -= 1;
        if (direction < 0) 
        {
            direction =15;
        }
        directionChanged = true;
    }
    
    //Calculate the anglia x and y coefficients based on the direction variable. The result is used for moving the car.
    public void calculateAngles()
    {
        switch (direction)
        {
            case 0:
            xDirChange =4;
            yDirChange =0;
            break;

            case 1:
            xDirChange =3;
            yDirChange =-1;
            break;

            case 2:
            xDirChange =2;
            yDirChange =-2;
            break;
            
            case 3:
            xDirChange =1;
            yDirChange =-3;
            break;
            
            case 4:
            xDirChange =0;
            yDirChange =-4;
            break;
            
            case 5:
            xDirChange = -1;
            yDirChange =-3;
            break;
            
            case 6:
            xDirChange =-2;
            yDirChange =-2;
            break;
            
            case 7:
            xDirChange =-3;
            yDirChange =-1;
            break;
            
            case 8:
            xDirChange =-4;
            yDirChange =0;
            break;
            
            case 9:
            xDirChange =-3;
            yDirChange =1;
            break;
            
            case 10:
            xDirChange =-2;
            yDirChange =2;
            break;
            
            case 11:
            xDirChange =-1;
            yDirChange =3;
            break;
            
            case 12:
            xDirChange =0;
            yDirChange =4;
            break;
            
            case 13:
            xDirChange =1;
            yDirChange =3;
            break;
            
            case 14:
            xDirChange =2;
            yDirChange =2;
            break;

            case 15:
            xDirChange =3;
            yDirChange =1;
            break;
        }
    }
    
    //Update car by checking if the direction was changed and setting the correct icon.
    //Move the car to the updated position using the x and y cooefficients of the cars direction.
    //Apply collision detector speed modifications.
    public void Update()
    {
        if (directionChanged = true)
        {
            this.setIcon(iconList.get(direction));
            directionChanged = false;
        }
        calculateAngles();
        this.xPosition += speed * this.xDirChange * 0.1;
        this.yPosition += speed * this.yDirChange * 0.1;
        this.setLocation((int)this.xPosition,(int)this.yPosition);
        speed = speed*collisionDetector.detectColl(xPosition, yPosition, speed);
    }
    
    //Creates the icon list by accessing directory.
    public List<Icon> getIconList(String colour)
    {
        List<Icon> iconList = new ArrayList<>();
        for (int i = 1 ; i <= 16 ; i++)
        {            
            //Relative path. Application must be run from the directory where main.java is located.
            iconList.add(new ImageIcon(String.format("%s/Resources/%s_%d.png",System.getProperty("user.dir"),colour,i)));
        }
        return iconList;
    }
}

