import java.util.*;
public class Card{
   private int rank;
   private int suit;
   String[] suitString = {"Hearts","Diamonds","Clubs","Spades"};
   String[] rankString = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
   String[] fsString = {"h","d","c","s"};
   String[] frString = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
   String imagePath;
   /**
   * Makes a new card with rank and suit
   *@param rank rank of card
   *@param suit suit of card
   */
   public Card(int rank, int suit){
      this.rank=rank;
      this.suit=suit;
   }
   /**
   *set rank card
   *@param rank rank of card
   */
   public void setRank(int rank){this.rank=rank;}
   /**
   *set suit card
   *@param suit suit of card
   */
   public void setSuit(int suit){this.suit=suit;}
   /**
   *get rank of card
   *@return returns rank
   */
   public int getRank(){return rank;}]
   /**
   *get suit of card
   *@return returns suit
   */
   public int getSuit(){return suit;}
   public String getImage(){
      return ("pics/"+frString[rank]+fsString[suit]+".jpg");
   }
   public String toString(){
      return (rankString[rank]+" of "+suitString[suit]);
   }
}