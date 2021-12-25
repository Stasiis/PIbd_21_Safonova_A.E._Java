package Stormtrooper;
import javax.swing.*;
public class Main extends JFrame{
    public Main(){
        setTitle("Штурмовик");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocation(100, 100);
        add(new Form());
        setVisible(true);
    }
    public static void main(String[] args) {
        Main Form = new Main();
    }
}
