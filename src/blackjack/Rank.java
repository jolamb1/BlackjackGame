package blackjack;
/**
 * This enum represents the 13 ranks of a standard deck of playing cards
 * This allows the rank to be represented as a char symbol for ease of comparison
 *  as well as a string representation for ease of human reading 
 * @author Joe Lamb, but based off of code in a project I worked on in university
 *
 */
public enum Rank {
	ACE('a',"Ace"),
	TWO('2',"Two"),
	THREE('3',"Three"),
	FOUR('4',"Four"),
	FIVE('5',"Five"),
	SIX('6',"Six"),
	SEVEN('7',"Seven"),
	EIGHT('8',"Eight"),
	NINE('9', "Nine"),
	TEN('t',"Ten"),
	JACK('j',"Jack"),
	QUEEN('q',"Queen"),
	KING('k',"King");
	

	private final char symbol;
	private final String name;
	
	/**
	 * Internal constructor to create Rank enums
	 * @param symbol - Single character to represent the rank 
	 * @param name - The Rank represented as a String
	 */
	 private Rank(char symbol, String name) {
		 this.symbol = symbol;
		 this.name = name;
	 }
	 
	 /**
	  * Returns the symbol representation of the Rank
	  * @return the char value of the rank
	  */
	 public char getSymbol() {
		 return this.symbol;
	 }
	 
	 /**
	  * Returns the String representation of the Rank
	  * @return the String value of the rank
	  */
	 public String getName() {
		 return this.name;
	 }
}