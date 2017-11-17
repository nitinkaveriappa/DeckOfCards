package play.test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import play.DeckOfCards;

public class DeckOfCardsTest {

	DeckOfCards doc;
	@Before
	public void initializeDeckOfCards() {
		doc = new DeckOfCards();
	}

	//Test that dealCard returns the top card in an unshuffled deck
	@Test
	public void testDealCard() {
		assertEquals("Card[face=Ace,suit=Hearts]", doc.dealOneCard());
	}

	/* Cannot test Shuffle method because it is truely random */
	// //Checks if shuffle works
	// @Test
	// public void testShuffle() {
	// 	doc.shuffle();
	// 	assertNotEquals("Card[face=Ace,suit=Hearts]", doc.dealCard());
	// }

	//Checks if 53rd call to dealCard returns null
	@Test
	public void testDealCardNull() {
		for(int i=0;i<52;i++) {
			doc.dealOneCard();
		}
		assertEquals(null, doc.dealOneCard());
	}

	//Checks if 53rd call to dealCard returns null after shuffle() call
	@Test
	public void testDealCardNullAfterShuffle() {
		doc.shuffle();
		for(int i=0;i<52;i++) {
			doc.dealOneCard();
		}
		assertEquals(null, doc.dealOneCard());
	}

	//Checks if all cards on deck initialized are unique
	@Test
	public void testDeckOfCardsUnique() {
		Set<String> deck = new HashSet<String>();
		for(int i=0;i<52;i++) {
			deck.add(doc.dealOneCard());
		}
		assertEquals(52, deck.size());
	}

	//Checks if dealt card is not still in deck range
	@Test
	public void testDealCardAndShuffle() {
		doc.dealOneCard();
		doc.shuffle();
		Set<String> deck = new HashSet<String>();
		for(int i=0;i<51;i++) {
			deck.add(doc.dealOneCard());
		}
		assertEquals(null, doc.dealOneCard());
	}

	//Checks if dealt card is not in the deck after a shuffle() call
	@Test
	public void testDealCardAndShuffle2() {
		doc.dealOneCard();
		doc.shuffle();
		Set<String> deck = new HashSet<String>();
		for(int i=0;i<51;i++) {
			deck.add(doc.dealOneCard());
		}
		assertFalse(deck.contains("Card[face=Ace,suit=Hearts]"));
	}
}
