package Stormtrooper;
import java.awt.*;
import java.util.Random;

public class Plane {
    private int startX;
    private int startY;
    private int pictureWidth;
    private int pictureHeight;
    private static final int planeWidth = 85;
    private static final int planeHeight = 110;
    public int MaxSpeed;
    public float Weight;
    public Color MainColor;
    public Color DopColor;
    public Boolean Rockets;
    public Boolean Boombs;
    private RocketsBoombs weapon;

    private void setMaxSpeed(int MaxSpeed){
        this.MaxSpeed = MaxSpeed;
    }
    public int getMaxSpeed(){
        return MaxSpeed;
    }
    private void setWeight(float Weight){
        this.Weight = Weight;
    }
    public float getWeight(){
        return Weight;
    }
    private void setMainColor(Color MainColor){
        this.MainColor = MainColor;
    }
    public Color getMainColor(){
        return MainColor;
    }
    public void setDopColor(Color DopColor) {
        this.DopColor = DopColor;
    }
    public Color getDopColor(){
        return DopColor;
    }
    private void setRockets(Boolean Rockets){
        this.Rockets = Rockets;
    }
    public Boolean getRockets(){
        return Rockets;
    }
    private void setBoombs(Boolean Boombs){
        this.Boombs = Boombs;
    }
    public Boolean getBoombs(){
        return Boombs;
    }

    public void Init(int maxSpeed, float weight, Color mainColor, Color dopColor,
                     Boolean rockets, Boolean boombs){
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        Rockets = rockets;
        Boombs = boombs;
        weapon = new RocketsBoombs();
        weapon.Init(planeHeight);
        Random rand = new Random();
        weapon.setNumbWeapon(rand.nextInt(3));
    }

    public void SetPosition(int x, int y, int width, int height){
        startX = x;
        startY = y;
        pictureWidth = width;
        pictureHeight = height;
    }

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

        if (Rockets && Boombs){
            weapon.drawWeapon(DopColor, g2d, startX, startY);
        }
    }
}