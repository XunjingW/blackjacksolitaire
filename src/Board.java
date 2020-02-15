
public class Board {
	
	String[][] gameBoard; 
	int positionsTaken;
	
	public Board() {
		this.gameBoard = new String[][]{
			{"1","2","3","4","5"},
			{"6","7","8","9","10"},
			{" ","11","12","13"," "},
			{" ","14","15","16"," "},
			{"17","18","19","20"}};
			
		this.positionsTaken = 0; // counter for the 16 spots on the Game board; it increments by 1 every time a spot is taken on the Game board. 
	}
	
	
	public String[][] getGameBoard() {
		return gameBoard;
	}

	/**
	 * displays the initial Game board and Discard board in the beginning of the game. 
	 */
	public void display() {
		
		System.out.println("Game board:");
		
		// loops through the first four rows and the total five columns of the gameBoard 2D array to display the game board part. 
		for (int i = 0; i < (gameBoard.length-1); i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.format("%10s", gameBoard[i][j]);	
			}
			System.out.println();
		}
		
		System.out.println("Discard board:");
		
		// loops through four columns in the last row of the gameBoard 2D array to display the discard board part. 
		for (int j = 0; j < gameBoard[4].length; j++) {
			System.out.format("%6s", gameBoard[4][j]);	
		}
		System.out.println();
	}
	
	/**
	 * checks if all 16 spots on the Game board are taken; if all taken, game over.  
	 * @return
	 */
	public boolean is16SpotFull() {
		return positionsTaken == 16;
	}
	
	/**
	 * checks if the spot in the Game board and the Discard board is picked by the user already; 
	 * true - spot taken; false - spot not taken. 
	 * @param position
	 * @return
	 */
	public boolean isSpotTaken(int position) {
		
		String positionStr = Integer.toString(position); // converts the integer representation of the chosen spot to its string format. 
		
		// loops through the Game board and the Discard board to check if the spot is taken previously.
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j].equals(positionStr)) { //finds the chosen spot on the Game board or Discard board. 
					return false; // if the current number on the spot matches the number chosen by the user, that means the spot is not taken; therefore returns false.
				}
			}
		}
		return true;
	}
	
	/**
	 * updates the board with the current card based on user's chosen spot. 
	 * @param position
	 * @param dealtCard
	 */
	public void updateBoard(int position, Card dealtCard) {
		
		System.out.println("Game board:");
		
		String currentCard = dealtCard.toString();
		String positionStr = Integer.toString(position);
		
		// loops through the first four rows and total five columns of the gameBoard 2D array to find the chosen spot and update the gameBoard with the current card. 
		for (int i = 0; i < (gameBoard.length-1); i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j].equals(positionStr)) { // finds the chosen spot on the Game board. 
					gameBoard[i][j] = currentCard; // updates the Game board with the current card. 
					positionsTaken++; // counts how many spots are taken on the Game board. 
				}
				System.out.format("%10s", gameBoard[i][j]);	// print out the Game board with the desired format.
			}
			System.out.println();
		}
		
		System.out.println("Discard board:");
		
		// loops through four columns in the last row of the gameBoard 2D array to find the chosen spot and update the discardBoard with the current card. 
		for (int j = 0; j < gameBoard[4].length; j++) {
			if (gameBoard[4][j].equals(positionStr)) { // finds the chosen spot on the Discard board. 
				gameBoard[4][j] = currentCard; // updates the Discard board with the current card. 
			}
			System.out.format("%6s", gameBoard[4][j]); // prints out the Discard board with the desired format. 
		}
		System.out.println(); 

	}
	
}
