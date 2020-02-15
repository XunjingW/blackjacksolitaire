
public class BoardBackup {
	
	String[][] gameBoard; 
	String[][] discardBoard;
	
	public BoardBackup() {
	
		this.gameBoard = new String[][]{{"1","2","3","4","5"},{"6","7","8","9","10"},{" ","11","12","13"," "},{" ","14","15","16"," "}};
		this.discardBoard = new String[][] {{"17","18","19","20"}};
		
	}
	
	public void display() {
		
		System.out.println("Game board:");
		
		//loops through the rows and columns of the gameBoard 2D array to display the game board as four rows and five columns
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.format("%10s", gameBoard[i][j]);	
			}
			System.out.println();
		}
		
		//since there is only one row in the discard board, this loops through the four columns to display the discard board
		System.out.println("Discard board:");
		for (int j = 0; j < discardBoard[0].length; j++) {
			System.out.format("%6s", discardBoard[0][j]);	
		}
		System.out.println();

	}
	
	//TODO!!! checks if the spot on the board is picked by the user already
	public boolean isTaken() {
		return true;
		
	}
	
	//TODO!!! updates the board based on user's chosen spot 
	public void updateBoard(int position, Card dealtCard) {
		
		System.out.println("Game board:");
		
		String currentCard = dealtCard.toString();
		String positionStr = Integer.toString(position);
		
		//loops through the rows and columns of the gameBoard to find the chosen spot and update the gameBoard with the dealt card
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j].equals(positionStr)) {
					gameBoard[i][j] = currentCard;
				}
				System.out.format("%10s", gameBoard[i][j]);	
			}
			System.out.println();
		}
		
		//loops through the four columns to to find the chosen spot and update the discardBoard with the dealt card
		System.out.println("Discard board:");
		for (int j = 0; j < discardBoard[0].length; j++) {
			if (discardBoard[0][j].equals(positionStr)) {
				discardBoard[0][j] = currentCard;	
			}
			System.out.format("%6s", discardBoard[0][j]);
		}
		System.out.println();

	}
	
	//to DELTE
			//System.out.println("Sr1= " + myScore.sumUp(0,0,0,4));
			//System.out.println("Sr2= " + myScore.sumUp(1,1,0,4));
			//System.out.println("Sr3= " + myScore.sumUp(2,2,1,3));
		//	System.out.println("Sr4= " + myScore.sumUp(3,3,1,3));
		//	System.out.println("Sc1= " + myScore.sumUp(0,1,0,0));
		//	System.out.println("Sc2= " + myScore.sumUp(0,3,1,1));
		//	System.out.println("Sc3= " + myScore.sumUp(0,3,2,2));
		//	System.out.println("Sc4= " + myScore.sumUp(0,3,3,3));
		//	System.out.println("Sc5= " + myScore.sumUp(0,1,4,4));
		//	
		//	System.out.println("r1= " + myScore.getHandScore(0,0,0,4));
		//	System.out.println("r2= " + myScore.getHandScore(1,1,0,4));
		//	System.out.println("r3= " + myScore.getHandScore(2,2,1,3));
		//	System.out.println("r4= " + myScore.getHandScore(3,3,1,3));
		//	System.out.println("c1= " + myScore.getHandScore(0,1,0,0));
		//	System.out.println("c2= " + myScore.getHandScore(0,3,1,1));
		//	System.out.println("c3= " + myScore.getHandScore(0,3,2,2));
		//	System.out.println("c4= " + myScore.getHandScore(0,3,3,3));
		//	System.out.println("c5= " + myScore.getHandScore(0,1,4,4));
	
}
