
public class Card {
	
	String rank; 
	String suit; 

	
	public Card(String rank, String suit) {
		this.rank = rank; 
		this.suit = suit; 	
	}
	
	public String toString() { // returns a string representation of the Card object. 
		return this.rank + this.suit;
	}
		

}
