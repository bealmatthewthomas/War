import javax.swing.*;

public class Driver{
   public static void main(String[] args){
      JFrame w= new WarInterface();
      w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      w.setSize(1000,1000);
      w.validate();
      w.setVisible(true);
   }

}