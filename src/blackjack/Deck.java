package blackjack;

import java.util.Random;
/**
 * This class represents a standard deck of 52 playing cards
 * A Deck Object has methods to shuffle, deal cards, and be reset
 * @author Joe Lamb
 *
 */
public class Deck {
	
	private Card[] deck;
	private int numCards;
	private final int MAX_DECK_SIZE = 52;
	
	/**
	 * Constructor for a Deck object. When the Deck is created, the cards are in order, so it needs to be shuffled before you do
	 * annything with it
	 */
	public Deck() {
		deck = new Card[MAX_DECK_SIZE];
		numCards = MAX_DECK_SIZE;
		//loop generating the cards in the deck
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 0; j < Rank.values().length; j++){
				deck[13 * i + j] = new Card(Rank.values()[j], Suit.values()[i]);
			}
		}
	}
	
	/**
	 * This method shuffles the deck with the Fisher-Yates algorithm
	 */
	public void shuffleDeck() {
		Random r = new Random();
		int swapPosition;
		Card temp;
		
		for (int i = deck.length - 1; i > 0; i--) {
			swapPosition = r.nextInt(i+1);
			temp = deck[swapPosition];
			deck[swapPosition] = deck[i];
			deck[i] = temp;
		}
	}
	
	/**
	 * Accessor for the numCards variable
	 * @return the value of the numCards variable
	 */
	public int getNumCards() {
		return numCards;
	}
	
	/**
	 * Calculates the index of the top card of the deck, then takes it from the deck, and decrements the number of cards in the deck and returns it
	 * @return the Card object that was on the top of the deck
	 */
	public Card getTopCardOfDeck() {
		int topCardIndex = MAX_DECK_SIZE - numCards;
		Card tempCard = deck[topCardIndex];
		deck[topCardIndex] = null;
		numCards--;
		return tempCard;
	}
	
	/**
	 * This method resets the Deck back to its starting state, like when the Deck is created
	 */
	public void resetDeck() {
		numCards = MAX_DECK_SIZE;
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 0; j < Rank.values().length; j++){
				deck[13 * i + j] = new Card(Rank.values()[j], Suit.values()[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		Deck testDeck = new Deck();
		//printing out entire deck to show that it generated properly
		for (Card c: testDeck.deck) {
			System.out.println(c);
		}
		System.out.println("Printing out first card of deck, should be Ace of Diamonds. First Card: "+testDeck.getTopCardOfDeck());
		System.out.println("Resetting the deck and then shuffling, will print out the deck to show it is in a different order");
		testDeck.resetDeck();
		testDeck.shuffleDeck();
		System.out.println("Shuffled deck:");
		for (Card c: testDeck.deck) {
			System.out.println(c);
		}
		
	}

}
