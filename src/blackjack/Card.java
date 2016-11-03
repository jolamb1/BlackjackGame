package blackjack;
/**
 * This class represents a single playing card, with a rank and suit
 * invariant: All Cards have a rank and suit from the respective enums
 * @author Joe Lamb
 *
 */

public class Card {

	private Suit suit;
	private Rank rank;
	
	/**
	 * Constructor for a Card Object
	 * If null is passed in for both parameters, the card created is the
	 * "Ace of Spades"
	 * @param suit - one of the Suit enum that the card will have
	 * @param rank -  one of the Rank enum that the card will have
	 */
	public Card(Rank rank, Suit suit) {
		if (rank == null) {
			this.rank = Rank.ACE;
		} else {
			this.rank = rank;
		}
		
		if (suit == null) {
			this.suit = Suit.SPADES;
		} else {
			this.suit = suit;
		}
		
	}
	/**
	 * Accessor for the card's rank
	 * @return the card's rank
	 */
	public Rank getRank() {
		return rank;
	}
	/**
	 * Accessor for the card's suit
	 * @return the card's suit
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * Returns a string representation of the card
	 */
	public String toString() {
		return this.rank.getName()+" of "+this.suit.getName();
	}
	/**
	 * This main method contains unit testing for this class
	 * @param args
	 */
	public static void main(String[] args) {
		
		Card twoOfClubs = new Card(Rank.TWO, Suit.CLUBS);
		Card sixOfHearts = new Card(Rank.SIX, Suit.HEARTS);
		Card defaultCard = new Card(null,null);
		
		System.out.println("Testing the getter methods of the Card class...");
		System.out.println("Printing out the rank and suit of Card twoOfClubs");
		System.out.println("Should display Two for the rank and Clubs for the Suit, along with their symbols");
		System.out.println("twoOfClubs Rank: "+twoOfClubs.getRank().getName()+" "+twoOfClubs.getRank().getSymbol());
		System.out.println("twoOfClubs Suit: "+twoOfClubs.getSuit().getName()+" "+twoOfClubs.getSuit().getSymbol());
		System.out.println("Printing out the String representation for sixOfHearts and defaultCard");
		System.out.println("defaultCard should display Ace of Spades");
		System.out.println(sixOfHearts);
		System.out.println("defaultCard: "+defaultCard);
	}
	
	

}
