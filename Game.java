import java.util.*;
public class Game{
   private Scanner keyboard= new Scanner(System.in);
   private CardPile player;
   private CardPile computer;
   private CardPile playerDiscard=new CardPile();
   private CardPile computerDiscard=new CardPile();
   private Card playerCard;
   private Card computerCard;
   /**
   *Makes a new game!
   */
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
   /**
   *returns player deck
   *@return player deck
   */
   public CardPile getPlayer(){return player;}
   /**
   *returns computer deck
   *@return computer deck
   */
   public CardPile getComputer(){return computer;}
   /**
   *returns the player discard
   *@return  returns playerdiscard
   */
   public CardPile getPlayerDiscard(){return playerDiscard;}
   /**
   *returnsteh computer discard
   *@return returns computer 
   */
   public CardPile getComputerDiscard(){return computerDiscard;}
   /**
   *set player cardpile
   *@param c cardpile
   */
   public void setPlayer(CardPile c){player=c;}
   /**
   *set computer cardpile
   *@param c cardpile
   */
   public void setComputer(CardPile c){computer=c;}  
   /**
   *set player discard
   *@param c cardpile
   */
   public void setPlayerDiscard(CardPile c){playerDiscard=c;}
   /**
   *set computer discard
   *@param c cardpile
   */
   public void setComputerDiscard(CardPile c){computerDiscard=c;}

}
