
public class Card {

	String [] suit = {"Hearts", "Diamonds", "Spades", "Clubs"};
	String [] rank = {"Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	int [] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	String cardSuit;
	String cardRank;
	int cardValue;
	
	public Card (String suit, String rank, int value){
		this.cardSuit = suit;
		this.cardRank = rank;
		this.cardValue = value;
		}
	
	public Card() {
				
		int randSuit = (int) (Math.random() * suit.length);
		cardSuit = this.suit [randSuit];
		
		int randRank = (int) (Math.random() * rank.length);
		 cardRank = this.rank [randRank];
		
		int randValue = (int) (Math.random() * value.length);
		cardValue = this.value [randValue];
		
	}

	public static void main(String[] args) {
		Card drawRandom1 = new Card();
		Card drawCard1 = new Card ("Clubs", "Queen", 10);
		System.out.println(drawRandom1);
		System.out.println(drawCard1);
	}
	
	public String toString () {
		String s = "This card suit is " + cardSuit + ", its rank is " + cardRank + ", and its value is " + cardValue +".";
		return s;
	}
	
	//a.compareTo(b)
	//a > b -> +
	//a ==  b -> 0
	//a < b -> -
	public int compareTo(Card other) {
		if (this.getCardSuit().equals(other.getCardSuit())) {
			return (this.getCardValue() - other.getCardValue());
		} else {
			if (this.getCardSuit().equals("Hearts")) {
				return 1;
			} else if (this.getCardSuit().equals("Clubs") && !other.getCardSuit().equals("Hearts")){
				return 2;
			} else if (this.getCardSuit().equals("Diamonds") 
					&&  !other.getCardSuit().equals("Hearts")  
							&& !other.getCardSuit().equals("Clubs")) {
				return 3;
			} else if (this.getCardSuit().equals("Spades")) {
				return -1;
			}
		}
		return 0;  //placeholder for other suits
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public String getCardRank() {
		return cardRank;
	}

	public int getCardValue() {
		return cardValue;
	}

}
