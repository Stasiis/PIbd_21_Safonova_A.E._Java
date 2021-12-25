package Stormtrooper;
import java.awt.*;
public class WeaponHard extends WeaponRect{
    public WeaponHard(int planeHeight){
        super(planeHeight);
    }
    @Override
    public void drawWeapon(Color dopColor, Graphics2D g2d, int startX, int startY){
        for(int i = 0; i < NumbWeapon.ordinal() +1; i++){
            g2d.setColor(dopColor);
            g2d.fillOval(startX+10, startY + 20- i * planeHeight / 15, 50, 5);
            g2d.fillRect(startX+35, startY + 20- i * planeHeight / 15, 20, 5);
            g2d.fillOval(startX+27, startY + 27+ i * planeHeight / 15, 15, 5);
            g2d.fillOval(startX+27, startY + 60+ i * planeHeight / 15, 15, 5);
            g2d.fillOval(startX+10, startY + 80 + i * planeHeight / 15, 50, 5);
            g2d.fillRect(startX+35, startY + 80+ i * planeHeight / 15, 20, 5);
        }
    }
}
