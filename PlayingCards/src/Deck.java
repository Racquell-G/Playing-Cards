
public class Deck  {

	Card [] collection;
	int size;
	int tracker = 0;
	
	public Deck(Card [] cards) {
		this.collection = cards;
	}
	
	public static void main(String[] args) {
		
		Card[] myCards = {new Card ("Clubs", "2", 5), new Card ("Hearts", "3", 5), new Card ("Diamonds", "Ace", 1)};
		
		Deck myDeck = new Deck (myCards);
		System.out.println(myDeck);
		myDeck.shuffle();
		System.out.println(myDeck);
		System.out.println(myDeck.deal());
		System.out.println(myDeck.deal());
		System.out.println(myDeck.deal());
		System.out.println(myDeck.deal());
		System.out.println(myDeck.deal());
		System.out.println("**********");
		System.out.println(myDeck);
	}	
	
	public void shuffle () {
		for (int k = this.collection.length-1; k > 0 ; k--) {
			int r = (int) Math.random() * k ;
			Card placeholder;
			placeholder = collection [k];
			collection [k] = collection [r];
			collection [r] = placeholder;
			
		}
	}
	
	public void tangShuffle() {
		Card temp;
		for (int i = collection.length-1; i > 0; i--) {
			temp = collection [i];
			int rand = (int) (Math.random() * i);
			collection [i] = collection [rand];
			collection [rand] = temp;
		}
	}
	
	public Card  deal () {
		Card topCard;
		if (tracker >= collection.length) {
			System.out.println("No cards left. Deck is shuffled:");
			shuffle();
			tracker = 0;
			topCard = collection [tracker];
		}
		topCard = collection [tracker];
		tracker++;
		return topCard;
	}
	
//	public void newShuffle() {
//		for (int i = collection.length - 1; i > 0; i--) {
//			int rand = (int) (Math.random() * (i-1) + 1);
//			i = rand;
//		}
//	}
	
	//Sorts our deck 
	//Smallest to largest
	public void sort() {
		
		for(int spot = 0; spot < collection.length; spot++) {
			Card smallest = collection [spot];
			int smallIndex = spot;
			for(int i = spot+1; i < collection.length; i++) {
				if(smallest.compareTo( collection [i]) > 0) {
					smallest = collection [i];
					smallIndex = i;
				}
			}
			Card temp = smallest;
			collection [smallIndex] = collection [spot];
			collection [spot] = temp;			
			
		}
	}
	
	public String toString () {
		int suitCounter = 0;
		int rankCounter = 0;
		String s = "A deck created with: ";
		s += "\nSuits: ";
		for (int i = 0; i < collection.length; i++) {
			s += collection [i].cardSuit + ", ";
			suitCounter++;
		}
		s += "\nRanks: ";
		for (int i = 0; i < collection.length; i++) {
			s += collection [i].cardRank + ", ";
			rankCounter++;
		}
		s += "\nValues: ";
		for (int i = 0; i < collection.length; i++) {
			s += collection [i].cardValue + ", ";
		}
		s += "\n";
		s += "\nCreates a " + suitCounter * rankCounter + " card deck.";
		s += "\n";
		return s;
	}
	
}
