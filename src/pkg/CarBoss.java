package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JenniferBalling on 4/9/14.
 */
public class CarBoss extends JPanel implements ActionListener{

    //List of cars
    private List<Car> carList;

    Car red1, red2, red3;
    private static final int lane1Speed = 50;
    private static final int lane2Speed = 15;
    private static final int lane3Speed = 35;

    private static final int lane1StartX = 0;
    private static final int lane2StartX = 400;
    private static final int lane3StartX = 0;
    private static final int lane1StartY = 150;
    private static final int lane2StartY = 250;
    private static final int lane3StartY = 350;


    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Image redCarImg;


    public CarBoss(){

        Timer reDrawTimer;
        carList = new ArrayList<Car>();

        redCarImg = new Image() {
            @Override
            public int getWidth(ImageObserver observer) {
                return 0;
            }

            @Override
            public int getHeight(ImageObserver observer) {
                return 0;
            }

            @Override
            public ImageProducer getSource() {
                return null;
            }

            @Override
            public Graphics getGraphics() {
                return null;
            }

            @Override
            public Object getProperty(String name, ImageObserver observer) {
                return null;
            }
        };


        redCarImg = Toolkit.getDefaultToolkit().getImage("redCar.png");
        red1 = new Car("Red1", redCarImg, lane1StartX, lane1StartY, lane1Speed);
        red2 = new Car("Red2", redCarImg, lane2StartX, lane2StartY, lane2Speed);
        red3 = new Car("Red3", redCarImg, lane3StartX, lane3StartY, lane3Speed);

        carList.add(red1);
        carList.add(red2);
        carList.add(red3);

        setBackground(Color.darkGray);
        carList = new ArrayList<Car>();

        reDrawTimer = new Timer(1000/60, this);
        reDrawTimer.start();
    }
    public synchronized void paint (Graphics g){

        for( int i=0; i<carList.size(); i++){

            super . paint(g);
            Graphics2D g2 = (Graphics2D)g;
            Car c = carList.get(i);
            Image carImg = c.getImg();
            //Graphics2D buffer = (Graphics2D) carImg.getGraphics();


        /*for( Car c : carList) {

            Image carImage = (c.getImg());//this.createImage(getWidth(), getHeight());
            Graphics2D buffer = (Graphics2D) carImage.getGraphics();

        //Image carImage = this.createImage(getWidth(), getHeight());
        //Graphics2D buffer = (Graphics2D) bufferedImage.getGraphics();*/

            super.paint(g2);
            g2.drawImage(carImg, 0, 0, this);
    }
    }
    public synchronized void actionPerformed (ActionEvent arg0){
        List<Car> currentCars = new ArrayList<Car>();
        for(int i=0; i<currentCars.size(); i++){
            moveCar(currentCars.get(i));
            repaint();
        }
    }
    public void addCar(){
        Car car = new Car();
        carList.add(car);
    }
    public void moveCar(Car car){

        for(int j=0; j<10; j++){

            car= carList.get(j);

            car.move();

            int x = car.getX();
            int y = car.getY();

            for(int i=0; i<WIDTH;i++){
                x+=10;
                repaint();
                if(x>WIDTH-100|| x+100<0){
                    y=car.getY();
                    x= car.getX();
                }
                try{
                    Thread.sleep(car.getXSpeed());
                }catch (InterruptedException ex){
                    System.err.println("exception");
                }
            }
        }
    }
}
