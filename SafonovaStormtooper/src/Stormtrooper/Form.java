package Stormtrooper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Form extends JPanel{
    private ITransport plane;
    JButton ButtonCreatePlane = new JButton("Создать самолет");
    JButton ButtonCreateStormTrooper = new JButton("Создать штурмовик");
    JButton ButtonDown = new JButton(new ImageIcon("src/com/down.png"));
    JButton ButtonUp = new JButton(new ImageIcon("src/com/up.png"));
    JButton ButtonLeft = new JButton(new ImageIcon("src/com/left.png"));
    JButton ButtonRight = new JButton(new ImageIcon("src/com/rigth.png"));

    private void drawAll(){
        plane.DrawTransport(getGraphics());
        paintComponents(getGraphics());
    }

    public class Click implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String actionStr = event.getActionCommand();
            switch(actionStr){
                case "Up":
                    plane.MoveTransport(Direction.Up);
                    break;
                case "Down":
                    plane.MoveTransport(Direction.Down);
                    break;
                case "Left":
                    plane.MoveTransport(Direction.Left);
                    break;
                case "Right":
                    plane.MoveTransport(Direction.Right);
                    break;
            }
            drawAll();
        }
    }

    public void addButton(JButton button, int buttonX, int buttonY, int buttonWidth, int buttonHeigth){
        button.setBounds(buttonX, buttonY, buttonWidth, buttonHeigth);
        add(button);
    }

    public Form(){
        setBackground(Color.white);
        setLayout(null);

        ButtonDown.setActionCommand("Down");
        ButtonUp.setActionCommand("Up");
        ButtonLeft.setActionCommand("Left");
        ButtonRight.setActionCommand("Right");
        
        addButton(btnCreatePlane, 8, 8, 150, 30);
        addButton(btnCreateStormTrooper, 160, 8, 150, 30);
        addButton(ButtonUp, 900, 460, 30, 30);
        addButton(ButtonDown, 900, 500, 30, 30);
        addButton(ButtonLeft, 860, 500, 30, 30);
        addButton(ButtonRight, 940, 500, 30, 30);

       btnCreatePlane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                plane = new Plane(rand.nextInt(100) + 300, rand.nextInt(1000) + 2000, Color.BLACK);
                plane.SetPosition(rand.nextInt(10) + 100, rand.nextInt(50) + 100, getWidth(), getHeight());
                drawAll();
            }
        });
        btnCreateStormTrooper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                plane = new Stormtrooper(rand.nextInt(100)+300, rand.nextInt(1000)+2000, Color.BLACK, Color.red, true, true);
                plane.SetPosition(rand.nextInt(50)+100, rand.nextInt(50)+100, getWidth(), getHeight());
                drawAll();
            }
        });

        ButtonDown.addActionListener(new Click());
        ButtonUp.addActionListener(new Click());
        ButtonLeft.addActionListener(new Click());
        ButtonRight.addActionListener(new Click());
    }
}
