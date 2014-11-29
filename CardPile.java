import java.util.*;
public class CardPile extends Deck{
   private ArrayList<Card> cardPile;
   public CardPile(){
      cardPile=new ArrayList<Card>();
      setDeck(cardPile);
   }
}