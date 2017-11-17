package play;
// DeckOfCards class represents a deck of playing cards.
import java.util.Random;

public class DeckOfCards
{
   private Card deck[]; // array of Card objects
   private int currentCard; // index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of Cards
   private Random randomNumbers; // random number generator

   // constructor initializes deck of Cards
   public DeckOfCards()
   {
      String faces[] = { "Ace", "Two", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
      String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

      deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
      currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
      randomNumbers = new Random(); // create random number generator

      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ )
         deck[ count ] =
            new Card( faces[ count % 13 ], suits[ count / 13 ] );
   }

   // shuffle deck of Cards
   public void shuffle()
   {
      //if currentCard greater than deck size reinitialize currentCard
      if( currentCard >= 52) {
        currentCard = 0;
      }
      // for each Card, pick another random Card and swap them
      for ( int first = currentCard; first < deck.length; first++ )
      {
    	 int second;
         // select a random number between currentCard and 51
         do{
            second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
          }while(second < currentCard);
         // swap current Card with randomly selected Card
         Card temp = deck[ first ];
         deck[ first ] = deck[ second ];
         deck[ second ] = temp;
      }
   }

   // deal one Card
   public String dealOneCard()
   {
      // determine whether Cards remain to be dealt
      if ( currentCard < deck.length )
         return deck[ currentCard++ ].toString(); // return current Card in array
      else
         return null; // return null to indicate that all Cards were dealt
   }
   
   public static void main(String[] args) {
	   DeckOfCards doc = new DeckOfCards();
	   System.out.println("Initial Deck:");
	   for(int i=0;i<52;i++) {
		   System.out.print(doc.dealOneCard() + "; ");
	   }
	   doc.shuffle();
	   System.out.println("\nShuffled Deck:");
	   for(int i=0;i<52;i++) {
		   System.out.print(doc.dealOneCard() + "; ");
	   }
   }
}
