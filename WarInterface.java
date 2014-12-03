import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WarInterface extends JFrame{
        private Game game;
        private JLabel j1;
        private JLabel j2;
        private JLabel j3;
        private JLabel j4;
        private JButton j5;
        private JLabel j6;
        private JLabel j7;
        private JLabel j8;
        private JLabel j9;
        private Card playerCard;
        private Card computerCard;
        public WarInterface(){ 
        
           setLayout(new GridLayout(0,3));
           game= new Game();
           
           //get text
           //add player card image
           j1= new JLabel();
      //     j1.setIcon(new ImageIcon("pics/2h.jpg"));
           this.getContentPane().add(j1);
           
           //War thing
           j2 = new JLabel("WAR");
           this.getContentPane().add(j2);
           //add compute card
           j3=new JLabel();
           j3.setIcon(new ImageIcon("pics/5h.jpg"));
           this.getContentPane().add(j3);
           //add cad back
           j4= new JLabel();
           j4.setIcon(new ImageIcon("pics/back.jpg"));
           this.getContentPane().add(j4);
           j5= new JButton("Click to action");
           //make button
           j5.addActionListener(new ButtonListener()); 
           this.getContentPane().add(j5);
           

           j6= new JLabel();
           j6.setIcon(new ImageIcon("pics/back.jpg"));
           this.getContentPane().add(j6);
           
           j7= new JLabel("Player");
           this.getContentPane().add(j7);
           
           j8= new JLabel();
           this.getContentPane().add(j8);
           
           j9= new JLabel("Computer");
           this.getContentPane().add(j9);   
   
 }  
   private class ButtonListener implements ActionListener{
   public void actionPerformed(ActionEvent e){
      if(((game.getPlayer().getDeckSize())+game.getPlayerDiscard().getDeckSize())>0&&((game.getComputer().getDeckSize())+(game.getComputerDiscard().getDeckSize())>0)){
          try{
            playerCard=(game.getPlayer()).takeNextCard();
          }catch(ArrayIndexOutOfBoundsException f){
            (game.getPlayer()).cloneCardPile((game.getPlayerDiscard()).getCardPile());
            (game.getPlayer()).shuffleDeck();
            game.setPlayerDiscard(new CardPile());
            playerCard=(game.getPlayer()).takeNextCard();
          } 
          j1.setIcon(new ImageIcon(playerCard.getImage()));

          try{
            computerCard=(game.getComputer()).takeNextCard();
          }catch(ArrayIndexOutOfBoundsException f){
            (game.getComputer()).cloneCardPile((game.getComputerDiscard()).getCardPile());
            (game.getComputer()).shuffleDeck();
            game.setComputerDiscard(new CardPile());
            computerCard=(game.getComputer()).takeNextCard();
          } 
          j3.setIcon(new ImageIcon(computerCard.getImage()));
      }
         //top player card goes to j1 top compute card goes to j3
         // 
    }
 }      
}

/*
public void playGame(){
      //play the game while a player still has card
      while(((computer.getDeckSize()+computerDiscard.getDeckSize())>0)&&((player.getDeckSize()+playerDiscard.getDeckSize())>0)){
         //take each players cards from the back of the list
         //(imagining the back of the list being the top of the deck)
         System.out.println("Input any key to continue!");
         keyboard.nextLine();
         //try to take a card, if that doesnt work go to discard, if that doesnt work that player loses!
         try{
            playerCard=player.takeNextCard();
         }catch(ArrayIndexOutOfBoundsException e){
            player.cloneCardPile(playerDiscard.getCardPile());
            player.shuffleDeck();
            playerDiscard=new CardPile();
            playerCard=player.takeNextCard();
         }
         try{
            computerCard=computer.takeNextCard();
         }catch(ArrayIndexOutOfBoundsException e){
            computer.cloneCardPile(computerDiscard.getCardPile());
            computer.shuffleDeck();
            computerDiscard=new CardPile();
            computerCard=computer.takeNextCard();
         }
         if (playerCard.getRank()<computerCard.getRank()){
            computerDiscard.addCard(playerCard);
            computerDiscard.addCard(computerCard);
            System.out.println("Computer card "+computerCard.toString()+" is larger than "+playerCard.toString());
         }else if(computerCard.getRank()<playerCard.getRank()){
            playerDiscard.addCard(computerCard);
            playerDiscard.addCard(playerCard);
            System.out.println("Player card "+playerCard.toString()+" is larger than "+computerCard.toString());
         }else if(computerCard.getRank()==playerCard.getRank()){
            CardPile playerWar= new CardPile();
            CardPile computerWar=new CardPile();
            int warCount=1;
            playerWar.addCard(playerCard);
            computerWar.addCard(computerCard);
            war(playerWar,computerWar,warCount);
         }else{System.out.println("ERROR");}
         System.out.println("P: "+player.getDeckSize()+" C: "+ computer.getDeckSize());  
         System.out.println("PD: "+playerDiscard.getDeckSize()+" C: "+computerDiscard.getDeckSize());

      } 
      if((player.getDeckSize()+playerDiscard.getDeckSize())<1){
         System.out.println("Player is out of cards and loses.");
      }else if((computer.getDeckSize()+computerDiscard.getDeckSize())<1){
         System.out.println("Computer is out of cards and loses.");
      }
      
   }
   public void war(CardPile p, CardPile c,int w){
      //collect all cards in war pile
      int warCount=w;
      CardPile playerWar=p;
      CardPile computerWar=c;
      int exceptionCount;
      System.out.println("WAR!");
      //check if either player will run out of cards since they cant happen at the same time if else is fine
      
      if((player.getDeckSize()+playerDiscard.getDeckSize())<2){
         System.out.println("Player is out of cards and loses!");
      }else if((computer.getDeckSize()+computerDiscard.getDeckSize())<2){
         System.out.println("Computer is out of cards and loses!");
         //if not add cards from either the main deck or the discard
      }else{
         for(int i=0;i<2;i++){
            try{
               playerWar.addCard(player.takeNextCard());
               
            }catch(IndexOutOfBoundsException e){
               player.cloneCardPile(playerDiscard.getCardPile());
               player.shuffleDeck();
               playerDiscard=new CardPile();
               playerWar.addCard(player.takeNextCard());           
            }
         }
         for(int i=0;i<2;i++){
            try{
               computerWar.addCard(computer.takeNextCard());
               
            }catch(IndexOutOfBoundsException e){
               computer.cloneCardPile(computerDiscard.getCardPile());
               computer.shuffleDeck();
               computerDiscard=new CardPile();
               computerWar.addCard(computer.takeNextCard());           
            }
         }
         //now compare the latest war card;
         int warMult=((warCount*2)+1);
         if(((computerWar.getNextCard()).getRank())>((playerWar.getNextCard()).getRank())){
            System.out.println("Computer card "+(computerWar.getNextCard().toString())+" is bigger than "+ playerWar.getNextCard().toString());
            for(int i=0;i<warMult;i++){
               computerDiscard.addCard(playerWar.takeNextCard());
               computerDiscard.addCard(computerWar.takeNextCard());
            }
         }else if(((playerWar.getNextCard()).getRank())>((computerWar.getNextCard()).getRank())){
            System.out.println("Player card "+(playerWar.getNextCard().toString())+" is bigger than "+ computerWar.getNextCard().toString());
            for(int i=0;i<warMult;i++){
               playerDiscard.addCard(playerWar.takeNextCard());
               playerDiscard.addCard(computerWar.takeNextCard());
            }
         }else if(((playerWar.getNextCard()).getRank())==((playerWar.getNextCard()).getRank())){
            warCount++;
            war(playerWar,computerWar,warCount);
            System.out.println("Second war declared! press enter to continue");
            keyboard.nextLine();
         }
      }
   }
   public CardPile getPlayer(){return player;}
   public CardPile getComputer(){return computer;}  
}
*/