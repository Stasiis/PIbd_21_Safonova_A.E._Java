package Stormtrooper;
import java.awt.*;
import java.util.Random;

public class Plane extends Vehicle{
    protected  static int planeWidth = 85;
    protected  static int planeHeight = 110;

    public Plane(int maxSpeed, float weight, Color mainColor){
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }
    protected Plane(int maxSpeed, float weight, Color mainColor, int skiffWidth, int skiffHeight){
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        this.planeWidth = planeWidth;
        this.planeHeight = planeHeight;
    }
    @Override
    public void MoveTransport(Direction direction){
        float step = MaxSpeed * 100 / Weight;
        switch (direction){
            case Right:
                if (startX + step < pictureWidth - planeWidth)
                {
                    startX += step;
                }
                break;
            case Left:
                if(startX-step>0)
                {
                    startX -= step;
                }
                break;
            case Up:
                if(startY - step > 0)
                {
                    startY -= step;
                }
                break;
            case Down:
                if (startY + step < pictureHeight - planeHeight)
                {
                    startY += step;
                }
                break;
        }
    }
    @Override
    public void DrawTransport(Graphics g){
        g.clearRect(0, 0, 1000, 600);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setPaint(Color.black);

        g2d.drawRect(startX + 10, startY + 50, 75, 10);
        //nose
        g2d.drawLine(startX+10,startY+50,startX,startY+55);
        g2d.drawLine(startX,startY+55,startX+10,startY+60);
        //крылья
        g2d.drawLine(startX+25,startY+50,startX+25,startY);
        g2d.drawLine(startX+25,startY,startX+40,startY);
        g2d.drawLine(startX+40,startY,startX+45,startY+50);
        g2d.drawLine(startX+25,startY+60,startX+25,startY+110);
        g2d.drawLine(startX+25,startY+110,startX+40,startY+110);
        g2d.drawLine(startX+40,startY+110,startX+45,startY+60);
        //хвост
        g2d.drawLine(startX+70,startY+50,startX+70,startY+40);
        g2d.drawLine(startX+70,startY+40,startX+85,startY+30);
        g2d.drawLine(startX+85,startY+30,startX+85,startY+50);
        g2d.drawLine(startX+70,startY+60,startX+70,startY+70);
        g2d.drawLine(startX+70,startY+70,startX+85,startY+80);
        g2d.drawLine(startX+85,startY+80,startX+85,startY+60);
    }
}
