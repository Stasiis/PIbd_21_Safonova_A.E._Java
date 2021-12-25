package Stormtrooper;
import java.awt.*;

public class RocketsBoombs {
    private CountRocketsBoombs NumbWeapon;
    private static int planeHeight;

    public void setNumbWeapon(int NumbWeapon){
        this.NumbWeapon = CountRocketsBoombs.values()[NumbWeapon];
    }

    public void drawWeapon(Color dopColor, Graphics2D g2d, int startX, int startY){
        for(int i = 0; i < NumbWeapon.ordinal()+1; i++){
            g2d.setColor(dopColor);
            g2d.fillOval(startX+10, startY + 20- i * planeHeight / 15, 50, 5);
            g2d.fillOval(startX+27, startY + 27+ i * planeHeight / 15, 5, 5);
            g2d.fillOval(startX+27, startY + 60+ i * planeHeight / 15, 5, 5);
            g2d.fillOval(startX+10, startY + 80 + i * planeHeight / 15, 50, 5);
        }
    }

    public void Init(int planeHeight){
        this.planeHeight = planeHeight;
    }
}