import javax.swing.*;

public class Driver{
   public static void main(String[] args){
      JFrame w= new WarInterface();
      w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      w.setSize(700,700);
      w.validate();
      w.setVisible(true);
   }

}