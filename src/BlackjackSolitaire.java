import java.util.Scanner;

public class BlackjackSolitaire {
	
	private Board myBoard; 
	private Deck myDeck;
	private Card currentCard;
	private Score myScore;
	
    public BlackjackSolitaire() {
    	this.myBoard = new Board();
    	this.myDeck = new Deck();
    	this.myScore = new Score(myBoard);
    	
    }
    
    /**
     * determines the game flow	
     */
	void play() {
		
		myBoard.display(); // displays the Game board and the Discard board in the beginning of the game. 
		
		Scanner intake = new Scanner(System.in); 
		boolean lastWasTaken = false; // checks if user inputs the same spot as last time (false - last spot not taken; true - last spot taken, need to pick a new spot). 
		
		while(!myBoard.is16SpotFull()) { // exits the game when all 16 spots on the Game board are taken.  
			
			if (!lastWasTaken) { // deals the first card in the beginning of the game and then ONLY deals a new card every time the user picks a different new spot. 
				currentCard = myDeck.dealNewCard(); //deals a new card and sets it as the current card. 
				
				System.out.println("Your current card is: " + currentCard); // shows the user the current card. 
				System.out.println("Please choose a number between 1 to 20 to place the card: "); //prompts the user to pick a spot. 
			} else { // when user has picked the same spot as last time...
				System.out.println("Your current card is: " + currentCard); // shows the same card as last time. 
				System.out.println("The spot is already taken. Please choose a different number: "); // prompts the use to pick a different spot. 
				lastWasTaken = false; // sets the check back to false so it keeps checking user input until the user picks a new different spot. 
			}
			
			int userInput = intake.nextInt(); // takes in the integer representation of the spot picked by the user.
			
			if (myBoard.isSpotTaken(userInput)) { // when user picks the same spot...
				lastWasTaken = true; // returns true when the user has picked the same spot as last time. 
			} else { // when user picks a different new spot... 
				myBoard.updateBoard(userInput, currentCard); //ONLY updates the board when a different new spot is chosen. 
			}
				
			System.out.println(); 
			
		}
		
		System.out.println("You have taken all 16 spots on the Game board. We are getting your final score now.");	
		
		// tells the user game over and shows the total score. 
		int finalScore = myScore.getTotalScore();
		System.out.println("Your final score is: " + finalScore);	
		System.out.println("Game Over. Thank you for playing!");	
		intake.close(); 
			
	}
}
		
		
			
		
	
	
	


