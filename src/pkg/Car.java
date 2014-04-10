package pkg;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by JenniferBalling on 4/9/14.
 */
public class Car {
    private int x;
    private int y;
    private String name;
    private Image img;
    private int xSpeed;

    public Car(){
        name="";
        x=0;
        y=0;
        xSpeed = 0;
        img = Toolkit.getDefaultToolkit().getImage("redCar.png");
    }
    public Car(String name, Image img, int x, int y, int xSpeed){
        this.name = name;
        this.img = img;
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
    }
    public Car(Car car){
        x = car.x;
        y = car.y;
        name = car.name;
        img = car.img;
        xSpeed = car.xSpeed;
    }
    public void move(){
        x+= xSpeed;
    }
    public void draw (Graphics g){
        ImageObserver watch = new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        };
        g.drawImage(img, x, y, watch);
    }
    public int getX (){
        return this.x;
    }
    public void setX (int x){
        this.x = x;
    }
    public int getY (){
        return this.y;
    }
    public void setY (int y){
        this.y = y;
    }
    public int getXSpeed(){
        return xSpeed;
    }
    public void setxSpeed (int value){
        this.xSpeed= value;
    }
    public Image getImg () {
        return this.img;
    }
    public void setImg(Image pic){
        this.img = pic;
    }

}
