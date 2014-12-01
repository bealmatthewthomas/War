
//YOU MUST CHANGE IT SO THERE IS ONE DECK THAT IS DIVIDED BETWEEN THE PLAYERS
import java.util.*;
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
   public void shuffleDeck(){
      ArrayList<Card> sDeck=new ArrayList<Card>();
      long seed = System.nanoTime();
      Collections.shuffle(deck, new Random(seed));
   }
   public void printDeck(){
      for(int i=0;i<deck.size();i++){
         System.out.println((i+1)+" "+deck.get(i).toString());
      }
   }
   public void setDeck(ArrayList<Card> cards){
      deck=cards;
   }
   public void addCard(Card card){
      deck.add(card);
   }
   public Card getNextCard(){
      return (deck.get(deck.size()-1));
   }
   public Card takeNextCard(){
      Card tempCard=(deck.get(deck.size()-1));
      deck.remove(deck.size()-1);
      return (tempCard);
   }
   public int getDeckSize(){
      return deck.size();
   }
   public void dumpDeck(){
      deck=new ArrayList<Card>();
   }
  
}