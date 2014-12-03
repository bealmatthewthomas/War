import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarInterface {
    public final static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container contentPane) {
        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        }
        //add player card image
        JLabel pc= new JLabel();
        pc.setIcon(new ImageIcon("pics/2h.jpg"));
        //add computer card image
        JLabel cc= new JLabel();
        cc.setIcon(new ImageIcon("pics/5h.jpg"));
        //add cad back
        JLabel pcb= new JLabel();
        pcb.setIcon(new ImageIcon("pics/back.jpg"));
        
        JLabel ccb= new JLabel();
        ccb.setIcon(new ImageIcon("pics/back.jpg"));
        //make button
        JButton button= (new JButton("Click to continue"));
          button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("y");
            }
        });      


        
        //        Any number of rows and 2 columns
        
        contentPane.setLayout(new GridLayout(0,3));
   
        contentPane.add(pcb);
        contentPane.add(new JLabel("WAR"));
        contentPane.add(ccb);
        contentPane.add((pc));
        contentPane.add(button);
        contentPane.add(cc);
      
    }

    public static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("WAR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane and components in GridLayout
        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

   /* public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });*/
    }
}