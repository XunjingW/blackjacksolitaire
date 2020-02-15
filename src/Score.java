
public class Score {
	
	Board myBoard;
	
	public Score(Board myBoard) {
		
		this.myBoard = myBoard;	
		
	}
	
	/**
	 * takes in the char representation of the card rank and converts the value into an integer. 
	 * @param card
	 * @return
	 */
	public int getCardValue(String card) {
		
		char rankValue = card.charAt(0);
	
		if (rankValue == 'K' || rankValue == 'J' || rankValue == 'Q') {
			return 10;
		} else if (rankValue == 'A') {
			return 11;
		} else if (rankValue >= '2' && rankValue <= '9') {
			return Character.getNumericValue(rankValue);
		} else {
			return 10;
		}
		
	}
	
	
	/**
	 * counts the number of aces in each hand. 
	 * @param rowStart
	 * @param rowEnd
	 * @param colStart
	 * @param colEnd
	 * @return
	 */
	public int aceCounter(int rowStart, int rowEnd, int colStart, int colEnd) {
		int numOfAces = 0;
		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				if (myBoard.getGameBoard()[i][j].charAt(0) == 'A') {
					numOfAces++;
				}
			}
		}	
		return numOfAces;
	}
	
	
	/**
	 * sums up the value of each hand to be as close to 21 as possible.
	 * @param rowStart
	 * @param rowEnd
	 * @param colStart
	 * @param colEnd
	 * @return
	 */
	public int sumUp(int rowStart, int rowEnd, int colStart, int colEnd) {
		
		int sum = 0;
		int numOfAces = aceCounter(rowStart, rowEnd, colStart, colEnd);
		
		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				sum = sum + getCardValue(myBoard.getGameBoard()[i][j]);
			}
		}	
		
		for (int i = numOfAces; i > 0 && sum > 21; i--) { // when hand sum is over 21, keeps adjusting the sum by 10 until we run of ace to adjust in that hand.
			sum = sum - 10; 
		}
		
		return sum;
	}
	
	
	/**
	 * takes in the sum of each hand and produces the score for each hand. 
	 * @param rowStart
	 * @param rowEnd
	 * @param colStart
	 * @param colEnd
	 * @return
	 */
	public int getHandScore(int rowStart, int rowEnd, int colStart, int colEnd) {
		
		int handSum = sumUp(rowStart, rowEnd, colStart, colEnd);
		int handScore = 0; 
		
		if ((handSum == 21 && rowStart == 0 && rowEnd == 1 && colStart == 0 && colEnd == 0) 
		     || (handSum == 21 && rowStart == 0 && rowEnd == 1 && colStart == 4 && colEnd == 4)) {
			handScore = 21; 
		} else if (handSum == 20 ) {
			handScore = 5;	
		} else if (handSum == 19) {
			handScore = 4;
		} else if (handSum == 18) {
			handScore = 3;
		} else if (handSum == 17) {
			handScore = 2;
		} else if (handSum <= 16) {
			handScore = 1;
		} else if (handSum > 21) {
			handScore = 0;
		} else {
			handScore = 7;
		}
		return handScore;
	}

	
	/**
	 * takes in the score of each hand and sums them up.
	 * @return
	 */
	public int getTotalScore() {
		int scoreRow1 = getHandScore(0,0,0,4);
		int scoreRow2 = getHandScore(1,1,0,4);
		int scoreRow3 = getHandScore(2,2,1,3);
		int scoreRow4 = getHandScore(3,3,1,3);
		int scoreCol1 = getHandScore(0,1,0,0);
		int scoreCol2 = getHandScore(0,3,1,1);
		int scoreCol3 = getHandScore(0,3,2,2);
		int scoreCol4 = getHandScore(0,3,3,3);
		int scoreCol5 = getHandScore(0,1,4,4);

		int totalScore = scoreRow1 + scoreRow2 + scoreRow3 + scoreRow4 
				         + scoreCol1 + scoreCol2+ scoreCol3+ scoreCol4+ scoreCol5; 
		
		return totalScore;
	}	

}
