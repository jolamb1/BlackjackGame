package blackjack;
/**
 * The Dealer class is a subclass of the Player class, with the difference of the showHand() method only revealing one of the cards in the dealer's
 * hand. This was done so the game is more realistic and so I can show that I know how Inheritance and Polymorphism work
 * @author Joe Lamb
 *
 */
public class Dealer extends Player {

	/**
	 * Constructor for a Dealer object
	 * It will always have the name "Dealer", so it is easier to tell it from the human Player
	 */
	public Dealer() {
		super("Dealer");
	}
	/**
	 * This method returns only one of the cards for the dealer, so the game is more like real blackjack
	 */
	public String showHand() {
		String tempHand = super.hand.get(0).toString();
		return tempHand;
	}
	
	public String showFullHand() {
		String tempHand = super.showHand();
		return tempHand;
	}

}
