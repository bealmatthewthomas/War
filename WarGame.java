import java.util.*;
import java.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
public class WarGame{
   public static void main(String[] args){
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
      WarInterface war=new WarInterface();
            public void run() {
                war.createAndShowGUI();
            }
        });

      Scanner keyboard= new Scanner(System.in);
      String loopCheck;
      System.out.println("Welcome, would you like to play a game of war?");
      loopCheck= keyboard.nextLine();
      while(loopCheck.equals("y")){
         Deck bigDeck=new Deck();
         bigDeck.shuffleDeck();
         CardPile playerDeck=new CardPile();
         CardPile computerDeck=new CardPile();
         for(int i=0;i<26;i++){
            
            playerDeck.addCard(bigDeck.takeNextCard());
         }
         
         for(int i=26;i<52;i++){
            computerDeck.addCard(bigDeck.takeNextCard());
         }
         Game newGame= new Game(playerDeck,computerDeck);
         newGame.playGame();
         //wanna play again?
         System.out.println("Wanna play again? (y/n)");
         loopCheck=keyboard.nextLine();
      }
   }
}