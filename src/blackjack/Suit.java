package blackjack;
/**
 * This enumeration represents the 4 suits in a playing card deck
 * @author Joe Lamb, but based off of code in a project I worked on in university
 *
 */
public enum Suit {

	DIAMONDS('d', "Diamonds"),
	CLUBS('c',"Clubs"),
	SPADES('s', "Spades"),
	HEARTS('h',"Hearts");
	
	private final char symbol;
	private final String name;
	
	/**
	 * Internal constructor to create Suit enum
	 * @param symbol char representation of the Suit
	 * @param name string representation of the Suit
	 */
	 
	private Suit(char symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}
	
	/**
	 * Returns the symbol representation of the Suit
	 * @return the symbol of the Suit
	 */
	public char getSymbol() {
		return this.symbol;
	}
	
	/**
	 * Returns the String representation of the Suit
	 * @return the String representation of the Suit
	 */
	public String getName() {
		return this.name;
	}
}
