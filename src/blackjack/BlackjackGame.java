package blackjack;
/**
 * This is the driver class for the Blackjack game, it uses a Deck, two Players, a human player and a dealer 
 */
import java.util.Scanner;



public class BlackjackGame {
	
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		String playerName;
		String playAgain = "Yes";
		String playerCommand;
		final int STARTING_HAND_SIZE = 2;
		int numTies = 0;
		boolean skipDealer = false; //the dealer skips their turn if the player has blackjack
		
		System.out.println("Welcome to my Blackjack game");
		System.out.print("Please enter your name: ");
		 playerName = input.nextLine();
		
		// Instantiating the player, dealer, and deck
		Player humanPlayer = new Player(playerName);
		Dealer dealer = new Dealer();
		Deck blackJackDeck = new Deck();
		
		
		do {
			blackJackDeck.shuffleDeck();
			skipDealer = false;
			playerCommand = "";
			
			//deal cards to player and dealer
			for (int i= 0; i < STARTING_HAND_SIZE; i++) {
				Card playerCard = blackJackDeck.getTopCardOfDeck();
				Card dealerCard = blackJackDeck.getTopCardOfDeck();
				humanPlayer.addCardtoHand(playerCard);
				dealer.addCardtoHand(dealerCard);
			}
			
			//show player and dealer's hands
			String playerHand = humanPlayer.showHand();
			String dealerHand = dealer.showHand();
			System.out.println("Your hand contains: "+playerHand);
			System.out.println("Your score is: "+humanPlayer.getScore());
			//run check for a blackjack for each player
			if (humanPlayer.getScore() == 21) {
				System.out.println(humanPlayer.getName()+" has Blackjack!");
				playerCommand = "Stand";
				skipDealer = true;
			}
			//We want to see the dealer's full hand if they have blackjack, otherwise we only want to see a single card initially
			if (dealer.getScore() == 21) {
				System.out.println("Dealer's Hand contains: "+dealer.showFullHand());
				System.out.println("Dealer has Blackjack");
				playerCommand = "Stand";
				skipDealer = true;
			} else {
				System.out.println("Dealer's visible card is: "+dealerHand);
			}
			
			
			
			
			//run the player's turn
				while (!humanPlayer.isBusted() && !playerCommand.equalsIgnoreCase("Stand")){
				
				if (humanPlayer.getScore() == 21) {
					playerCommand = "Stand";// player should automatically break out of the loop if they have 21
				} else {
					System.out.print("Do you want to \"Hit\" or \"Stand\"?: ");
					playerCommand = input.nextLine();
					System.out.println(playerCommand);

				}
			
				if (playerCommand.equalsIgnoreCase("Hit")) {
					Card dealtCard = blackJackDeck.getTopCardOfDeck();
					humanPlayer.addCardtoHand(dealtCard);
					System.out.println("Your hand now contains: "+humanPlayer.showHand());
					System.out.println("Your score is now: "+humanPlayer.getScore());
				} else if (playerCommand.equalsIgnoreCase("Stand")) {
					break;
				} else {
					System.out.println("Error: Command not recognized, please enter \"Hit\" or \"Stand\"");
				}
				
				if (humanPlayer.isBusted()) {
					System.out.println("Sorry, you busted, better luck next time");
				}
				
				
			} 
			//end player's turn
			
			//start dealer's turn

			//no need to play out the dealer's turn if the player busts, or there is one or more blackjacks
			if (!humanPlayer.isBusted() && !skipDealer) {
				System.out.println("Dealer's hand contains: "+dealer.showFullHand());
				System.out.println("Dealer's score: "+dealer.getScore());
				//dealer hits as long as its score is below 17
				while(dealer.getScore() < 17) {
					System.out.println("Dealer hits");
					Card dealtCard = blackJackDeck.getTopCardOfDeck();
					dealer.addCardtoHand(dealtCard);
					System.out.println("Dealer's hand contains: "+dealer.showFullHand());
					System.out.println("Dealer's score: "+dealer.getScore());
					
					if (dealer.isBusted()) {
						System.out.println("Dealer busts!");
					}
				}
			}
			//end dealer's turn
			
			//determine who won the game
			if (humanPlayer.isBusted() && !dealer.isBusted() || humanPlayer.isBusted() && dealer.isBusted() || (dealer.getScore() > humanPlayer.getScore() && !dealer.isBusted())) { // case where the dealer wins
				dealer.incrementWins();
				System.out.println(dealer.getName()+" wins");
			} else if (dealer.isBusted() && !humanPlayer.isBusted() || (humanPlayer.getScore() > dealer.getScore() && !humanPlayer.isBusted())) { // case where the player wins
				humanPlayer.incrementWins();
				System.out.println(humanPlayer.getName()+" wins!");
			} else { // case where there is a tie
				System.out.println("The dealer and "+humanPlayer.getName()+" tied!");
				numTies++;
			}
			
			//display the game records
			System.out.println("Game record: ");
			System.out.println(humanPlayer.getName()+" wins: "+humanPlayer.getNumWins());
			System.out.println(dealer.getName()+" wins: "+dealer.getNumWins());
			System.out.println("Number of tie games: "+numTies);
			
			do {
			System.out.print("Do you want to play again?(Yes/No): ");
			playAgain = input.nextLine();
			
				if (playAgain.equalsIgnoreCase("Yes")) {
					//need to reset the deck and the players' hands for the next game if there is one
					blackJackDeck.resetDeck();
					humanPlayer.resetPlayer();
					dealer.resetPlayer();
				} else if (playAgain.equalsIgnoreCase("No")){
					//do nothing
				} else {
					System.out.println("Command not recognized, please enter \"Yes\" or \"No\"");
				}
			} while ((!playAgain.equalsIgnoreCase("Yes")) && (!playAgain.equalsIgnoreCase("No")));
			
			
		} while (playAgain.equalsIgnoreCase("Yes"));
		input.close();
		
		
	}
	
	
	
	
	
}
