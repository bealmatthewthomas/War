import java.util.*;
public class CardPile extends Deck{
   private ArrayList<Card> cardPile;
   public CardPile(){
      cardPile=new ArrayList<Card>();
      setDeck(cardPile);
   }
   public void cloneCardPile(ArrayList<Card> c){
      for(int i=0; i< c.size();i++){
         addCard(c.get(i));
      }
   }
   public ArrayList<Card> getCardPile(){
      return cardPile;
   }
     

   
}