import java.util.*;
public class Game{
   private Scanner keyboard= new Scanner(System.in);
   private CardPile player;
   private CardPile computer;
   private CardPile playerDiscard=new CardPile();
   private CardPile computerDiscard=new CardPile();
   private Card playerCard;
   private Card computerCard;
   public Game(CardPile playerD, CardPile computerD){
      player=playerD;
      computer=computerD;
   }
   public void playGame(){
      //play the game while a player still has card
      while(((computer.getDeckSize()+computerDiscard.getDeckSize())>0)&&((player.getDeckSize()+playerDiscard.getDeckSize())>0)){
         //take each players cards from the back of the list
         //(imagining the back of the list being the top of the deck)
         System.out.println("Input any key to continue!");
         keyboard.nextLine();
         playerCard=player.getNextCard();
         computerCard=computer.getNextCard();
         if (playerCard.getRank()<computerCard.getRank()){
            player.takeNextCard();
            computerDiscard.addCard(playerCard);
            computer.takeNextCard();
            computerDiscard.addCard(computerCard);
            System.out.println("Computer card "+computerCard.toString()+" is larger than "+playerCard.toString());
         }else if(computerCard.getRank()<playerCard.getRank()){
            computer.takeNextCard();
            player.takeNextCard();
            playerDiscard.addCard(computerCard);
            playerDiscard.addCard(playerCard);
            System.out.println("Player card "+playerCard.toString()+" is larger than "+computerCard.toString());
         }else if(computerCard.getRank()==playerCard.getRank()){
            /*if(){
            
            }else{
               
            }*/
         }else{System.out.println("ERROR");}
      }   

   }
}