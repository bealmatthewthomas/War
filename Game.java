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
         //try to take a card, if that doesnt work go to discard, if that doesnt work that player loses!
         try{
            playerCard=player.takeNextCard();
         }catch(ArrayIndexOutOfBoundsException e){
            player.cloneCardPile(playerDiscard.getCardPile());
            player.shuffleDeck();
            playerDiscard=new CardPile();
            playerCard=player.takeNextCard();
         }
         try{
            computerCard=computer.takeNextCard();
         }catch(ArrayIndexOutOfBoundsException e){
            computer.cloneCardPile(computerDiscard.getCardPile());
            computer.shuffleDeck();
            computerDiscard=new CardPile();
            computerCard=computer.takeNextCard();
         }
         if (playerCard.getRank()<computerCard.getRank()){
            computerDiscard.addCard(playerCard);
            computerDiscard.addCard(computerCard);
            System.out.println("Computer card "+computerCard.toString()+" is larger than "+playerCard.toString());
         }else if(computerCard.getRank()<playerCard.getRank()){
            playerDiscard.addCard(computerCard);
            playerDiscard.addCard(playerCard);
            System.out.println("Player card "+playerCard.toString()+" is larger than "+computerCard.toString());
         }else if(computerCard.getRank()==playerCard.getRank()){
            CardPile playerWar= new CardPile();
            CardPile computerWar=new CardPile();
            int warCount=1;
            playerWar.addCard(playerCard);
            computerWar.addCard(computerCard);
            war(playerWar,computerWar,warCount);
         }else{System.out.println("ERROR");}
         System.out.println("P: "+player.getDeckSize()+" C: "+ computer.getDeckSize());  
         System.out.println("PD: "+playerDiscard.getDeckSize()+" C: "+computerDiscard.getDeckSize());

      } 
      
   }
   public void war(CardPile p, CardPile c,int w){
      //collect all cards in war pile
      int warCount=w;
      CardPile playerWar=p;
      CardPile computerWar=c;
      int exceptionCount;
      System.out.println("WAR!");
      //check if either player will run out of cards since they cant happen at the same time if else is fine
      
      if((player.getDeckSize()+playerDiscard.getDeckSize())<2){
         System.out.println("Player is out of cards and loses!");
         System.exit(0);
      }else if((computer.getDeckSize()+computerDiscard.getDeckSize())<2){
         System.out.println("Computer is out of cards and loses!");
         System.exit(0);
         //if not add cards from either the main deck or the discard
      }else{
         for(int i=0;i<2;i++){
            try{
               playerWar.addCard(player.takeNextCard());
               
            }catch(IndexOutOfBoundsException e){
               player.cloneCardPile(playerDiscard.getCardPile());
               player.shuffleDeck();
               playerDiscard=new CardPile();
               playerWar.addCard(player.takeNextCard());           
            }
         }
         for(int i=0;i<2;i++){
            try{
               computerWar.addCard(computer.takeNextCard());
               
            }catch(IndexOutOfBoundsException e){
               computer.cloneCardPile(computerDiscard.getCardPile());
               computer.shuffleDeck();
               computerDiscard=new CardPile();
               computerWar.addCard(computer.takeNextCard());           
            }
         }
         //now compare the latest war card;
         int warMult=((warCount*2)+1);
         if(((computerWar.getNextCard()).getRank())>((playerWar.getNextCard()).getRank())){
            System.out.println("Computer card "+(computerWar.getNextCard().toString())+" is bigger than "+ playerWar.getNextCard().toString());
            for(int i=0;i<warMult;i++){
               computerDiscard.addCard(playerWar.takeNextCard());
               computerDiscard.addCard(computerWar.takeNextCard());
            }
         }else if(((playerWar.getNextCard()).getRank())>((playerWar.getNextCard()).getRank())){
            System.out.println("Player card "+(playerWar.getNextCard().toString())+" is bigger than "+ computerWar.getNextCard().toString());
            for(int i=0;i<warMult;i++){
               playerDiscard.addCard(playerWar.takeNextCard());
               playerDiscard.addCard(computerWar.takeNextCard());
            }
         }else if(((playerWar.getNextCard()).getRank())==((playerWar.getNextCard()).getRank())){
            warCount++;
            war(playerWar,computerWar,warCount);
            System.out.println("Second war declared! press enter to continue");
            keyboard.nextLine();
         }
      }
   }  
}
