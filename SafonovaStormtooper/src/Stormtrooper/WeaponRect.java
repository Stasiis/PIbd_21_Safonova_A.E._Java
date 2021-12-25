package Stormtrooper;
import java.awt.*;

public class WeaponRect extends RocketsBoombs{
    public WeaponRect(int planeHeight){
        super(planeHeight);
    }
    @Override
    public void drawWeapon(Color DopColor,Graphics2D g2d, int startX, int startY){
        for(int i = 0; i < NumbWeapon.ordinal() +1; i++){
            g2d.setColor(DopColor);
            g2d.fillRect(startX+10, startY + 20- i * planeHeight / 15, 50, 5);
            g2d.fillRect(startX+27, startY + 27+ i * planeHeight / 15, 5, 5);
            g2d.fillRect(startX+27, startY + 60+ i * planeHeight / 15, 5, 5);
            g2d.fillRect(startX+10, startY + 80 + i * planeHeight / 15, 50, 5);
        }
    }
}
