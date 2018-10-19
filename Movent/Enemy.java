package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Enemy extends Circle {
    int speedx =5;
    int speedy =5;

    public Enemy(int x, int y, int radius){
        super(20,20,radius, Color.RED);
        setLayoutX(x);
        setLayoutY(y);

    }
    public void move(){
        if (getLayoutX()<=10)speedx =5;
        if (getLayoutY()<=10)speedy =5;
        if (getLayoutX()>=790)speedx =-5;
        if (getLayoutY()>=590)speedy =-5;

        setLayoutX(getLayoutX()+speedx);
        setLayoutY(getLayoutY()+speedy);
    }


}
