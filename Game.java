import java.util.*;
public class Game{
   private Scanner keyboard= new Scanner(System.in);
   private CardPile player;
   private CardPile computer;
   private CardPile playerDiscard=new CardPile();
   private CardPile computerDiscard=new CardPile();
   private Card playerCard;
   private Card computerCard;
   public Game(){
         Deck bigDeck=new Deck();
         bigDeck.shuffleDeck();
         player=new CardPile();
         computer=new CardPile();
         for(int i=0;i<26;i++){
            
            player.addCard(bigDeck.takeNextCard());
         }
         
         for(int i=26;i<52;i++){
            computer.addCard(bigDeck.takeNextCard());
         }

   }
   public CardPile getPlayer(){return player;}
   public CardPile getComputer(){return computer;}  
   public CardPile getPlayerDiscard(){return playerDiscard;}
   public CardPile getComputerDiscard(){return computerDiscard;}
   public void setPlayer(CardPile c){player=c;}
   public void setComputer(CardPile c){computer=c;}  
   public void setPlayerDiscard(CardPile c){playerDiscard=c;}
   public void setComputerDiscard(CardPile c){computerDiscard=c;}

}
