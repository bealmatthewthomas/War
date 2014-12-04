
//YOU MUST CHANGE IT SO THERE IS ONE DECK THAT IS DIVIDED BETWEEN THE PLAYERS
import java.util.*;
/**
*Creates deck with 52 cards
*/
public class Deck{
   private ArrayList<Card> deck= new ArrayList<Card>();
   public Deck(){
      for(int i=0;i<13;i++){
         for(int j=0;j<4;j++){
            Card newCard= new Card(i,j);
            deck.add(newCard);
         }
      } 
   }
   /**
   *randomizes the deck
   */
   public void shuffleDeck(){
      ArrayList<Card> sDeck=new ArrayList<Card>();
      long seed = System.nanoTime();
      Collections.shuffle(deck, new Random(seed));
   }
   /**
   *Prints the deck to the console
   */
   public void printDeck(){
      for(int i=0;i<deck.size();i++){
         System.out.println((i+1)+" "+deck.get(i).toString());
      }
   }
   /**
   *sets the deck equal to teh array list
   @param cards card array list
   */
   public void setDeck(ArrayList<Card> cards){
      deck=cards;
   }
   /**
   *adds a card to the deck
   *@param card card to be added
   */
   public void addCard(Card card){
      deck.add(card);
   }
   /**
   *gets the next card
   *@return returnsthe next card in the deck
   */
   public Card getNextCard(){
      return (deck.get(deck.size()-1));
   }
   /**
   *pops the next card off the deck and returns it
   *@return returnsthe card
   */
   public Card takeNextCard(){
      Card tempCard=(deck.get(deck.size()-1));
      deck.remove(deck.size()-1);
      return (tempCard);
   }
   /**
   *returns deck size
   *@return deck size
   */
   public int getDeckSize(){
      return deck.size();
   }
   /**
   *clears deck
   */
   public void dumpDeck(){
      deck=new ArrayList<Card>();
   }

}