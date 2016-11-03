package blackjack;
import java.util.ArrayList;
/**
 * This class represents a blackjack player. It contains the player's and, the hand's score value, and the number of wins the player has
 * @author Joe Lamb
 *
 */

public class Player {
	private String name;
	protected ArrayList<Card> hand;
	private int score;
	private int numWins;
	private boolean isBusted;
	private boolean hasAceAsEleven;
	
	public Player(String name) {
		this.name = name;
		this.numWins = 0;
		this.isBusted = false;
		this.hasAceAsEleven = false;
		this.hand = new ArrayList<Card>();
	}
	
	/**
	 * Accessor method for score variable
	 * @return the player's score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Accessor method for number of wins variable
	 * @return the number of wins the player has
	 */
	public int getNumWins() {
		return numWins;
	}
	/**
	 * Accessor method for the player's name
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Accessor method for the busted flag
	 * @return the value of the busted flag
	 */
	public boolean isBusted(){
		return isBusted;
	}
	/**
	 * This method adds a card to the player's hand and increments the player's score count
	 * @param card The card to be added to the player's hand
	 */
	public void addCardtoHand(Card card) {
		hand.add(card);
		//Add new card's value to the score
		if (card.getRank().getSymbol() == 't' || card.getRank().getSymbol() == 'j' || card.getRank().getSymbol() == 'q' || card.getRank().getSymbol() == 'k') {
			score += 10;
		} else if (card.getRank().getSymbol() == 'a') {
			if (score + 11 > 21) {
				score += 1;
			} else {
				score += 11;
				hasAceAsEleven = true;
			}
		} else {
			score += Character.getNumericValue(card.getRank().getSymbol());
		}
		
		//Check new score to see if player has busted
		if (score > 21 && hasAceAsEleven) {
			score -= 10; //Switching the Ace's value to 1 if player busts with it as 11
			hasAceAsEleven = false; //Need to deactivate the flag so it doesn't subtract 10 again
		}
		
		if (score > 21) {
			isBusted = true;
		}

	}
	
	/**
	 * Method to increment the number of wins for the player
	 */
	public void incrementWins() {
		numWins++;
	}
	
	/**
	 * This method returns a string representation of the player's hand
	 * @return A string representation of each card in the player's hand
	 */
	public String showHand() {
		String tempHand = "";
		for (Card c: hand) {
			tempHand += c.toString()+"    ";
		}
		return tempHand;
	}
	
	/**
	 * This method empties the player's hand, so a new game can begin
	 */
	public void resetPlayer() {
		hand.clear();
		score = 0;
		isBusted = false;
		hasAceAsEleven = false;
	}
	/**
	 * This main method contains unit testing for the player class, to show that this class's methods work
	 * @param args
	 */
	public static void main(String[] args) {
		
		Player testPlayer = new Player("TestPlayer");
		
		
		Card testCard1 = new Card(Rank.EIGHT, Suit.DIAMONDS);
		System.out.println("Card to add to "+testPlayer.getName()+"'s hand: "+testCard1.toString());
		testPlayer.addCardtoHand(testCard1);
		System.out.println("After card is added to testPlayer's hand, its score should equal 8");
		System.out.println("testPlayer's score: "+testPlayer.getScore());
		Card testCard2 = new Card(Rank.JACK, Suit.HEARTS);
		testPlayer.addCardtoHand(testCard2);
		System.out.println("Added "+testCard2+" to hand, score should equal 18");
		System.out.println("testPlayer's score: "+testPlayer.getScore());
		System.out.println("resetting testPlayer...");
		testPlayer.resetPlayer();
		System.out.println("Test case involving two Aces");
		testPlayer.addCardtoHand(new Card(Rank.ACE, Suit.SPADES));
		testPlayer.addCardtoHand(new Card(Rank.ACE, Suit.DIAMONDS));
		System.out.println("Hand contains: "+testPlayer.showHand());
		System.out.println("Score should be 12, actual score: "+testPlayer.getScore());
		testPlayer.addCardtoHand(new Card(Rank.TEN,Suit.CLUBS));
		System.out.println("Added a Ten to the hand, score should still be 12, actual score: "+testPlayer.getScore());
		
		
	}
	
}
	
