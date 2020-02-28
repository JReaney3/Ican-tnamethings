import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event;

public class Maths
{
    public static void main(String args[])
    {
        JFrame a = new JFrame();
        JLabel b = new JLabel("Hello.");
        JPanel c = new JPanel();

        JButton Buttons[] = new JButton[4];
        Buttons[0] = new JButton("<");
        Buttons[1] = new JButton("=");
        Buttons[2] = new JButton(">");
        Buttons[3] = new JButton("Ask me a Question.");

        BorderLayout d = new BorderLayout();
        c.setLayout(d);

        a.setSize(300,300);
        for (int i = 0; i < 4; i++)
        {
            c.add(Buttons[i]);
            Buttons[i].setSize(100,100);
            Buttons[i].setLocation(0+i*100,100);
        }
        Buttons[3].setSize(300,100);
        Buttons[3].setLocation(0,200);

        c.add(b);
        b.setSize(300,100);
        b.setLocation(0,0);
        a.setContentPane(c);

        a.setTitle("why?");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);

        
    }
}