import java.util.*;
public class CardPile extends Deck{
   private ArrayList<Card> cardPile;
   /**
   *Create generic card pile
   */
   public CardPile(){
      cardPile=new ArrayList<Card>();
      setDeck(cardPile);
   }
   /**
   *Clones the pile
   *@param c arraylist of cards
   */
   public void cloneCardPile(ArrayList<Card> c){
      for(int i=0; i< c.size();i++){
         addCard(c.get(i));
      }
   }
   /**
   *return the cardpile
   *@return returns the card pile
   */
   public ArrayList<Card> getCardPile(){
      return cardPile;
   }
     

   
}