package Stormtrooper;
import java.awt.*;
import java.util.Random;
public class Stormtrooper extends Plane{
    public Color DopColor;
    public Boolean Rockets;
    public Boolean Boombs;
    private IWeapon weapon;
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
    public Stormtrooper(int maxSpeed, float weight, Color mainColor, Color dopColor,
                    Boolean Rockets, Boolean Boombs){
        super(maxSpeed, weight, mainColor, 215, 100);
        DopColor = dopColor;
        this.Boombs = Boombs;
        this.Rockets = Rockets;
        if(Rockets && Boombs){
            Random rand = new Random();
            switch(rand.nextInt(3)){
                case 0:
                    weapon = new WeaponRect(planeHeight);
                    break;
                case 1:
                    weapon = new RocketsBoombs(planeHeight);
                    break;
                case 2:
                    weapon = new WeaponHard(planeHeight);
                    break;
            }
            weapon.setNumbWeapon(rand.nextInt(3));
        }
    }
    @Override
    public void DrawTransport(Graphics g){
        super.DrawTransport(g);
        Graphics2D g2d=(Graphics2D)g;

        if(Rockets && Boombs){
            weapon.drawWeapon(DopColor, g2d, startX, startY);
        }
    }
}
