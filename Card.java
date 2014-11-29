import java.util.*;
public class Card{
   private int rank;
   private int suit;
   String[] suitString = {"Hearts","Diamonds","Clubs","Spades"};
   String[] rankString = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
   public Card(int rank, int suit){
      this.rank=rank;
      this.suit=suit;
   }
   public void setRank(int rank){this.rank=rank;}
   public void setSuit(int suit){this.suit=suit;}
   public int getRank(){return rank;}
   public int getSuit(){return suit;}
   public String toString(){
      return (rankString[rank]+" of "+suitString[suit]);
   }
}