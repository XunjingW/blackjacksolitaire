import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	ArrayList<Card> cards;
	String[] suits;
	String[] ranks;

	
	public Deck() {
		
		// initiates the suits and ranks arrays and the cards arraylist. 
		this.suits = new String[] {"C","D","H","S"};
		this.ranks = new String[] {"A","Q","J","K","2","3","4","5","6","7","8","9","10"};
		this.cards = new ArrayList<Card>();
		
		// loops through suits and ranks arrays to build the deck of cards. 
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				cards.add(new Card(ranks[i],suits[j]));
			}	
		}
		
        /**
         * shuffles the deck and gives a deck of randomly ordered cards. 
         */
        Collections.shuffle(cards); 

	}
	
	int counter = 0; 
	
	/**
	 * deals a new card
	 * @return
	 */
	public Card dealNewCard() {
		Card currentCard = cards.get(counter);
	    counter++; // counter would not get out of bounds because max of 20 cards would be dealt
		return currentCard;	
	}
	}
	
	

	
        
	

	
