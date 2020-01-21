package BussinessLogic;

public class Card {
	
	public String CardType;
	public String CardSuit;
	
	public Card(String cardData) {
		this.parseCard(cardData);
	}
	
	private void parseCard(String cardData) {
		this.CardType = String.valueOf(cardData.toCharArray()[0]);
		this.CardSuit = String.valueOf(cardData.toCharArray()[1]);
		
	}
}
