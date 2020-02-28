import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Maths implements ActionListener
{   
    private JFrame a = new JFrame();
    private JLabel b = new JLabel("Hello.");
    private JPanel c = new JPanel();

    private JButton Buttons[] = new JButton[4];

    private BorderLayout d = new BorderLayout();
    
    public void Maths()
    {
        Buttons[0] = new JButton("<");
        Buttons[1] = new JButton("=");
        Buttons[2] = new JButton(">");
        Buttons[3] = new JButton("Ask me a Question.");
        
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

        Buttons[0].addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Hello.");
    }
}