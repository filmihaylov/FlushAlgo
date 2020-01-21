package BussinessLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlushAlgo {
	
	private List<Card> imputCardsList;
	private String[] cardOrder =new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"}; 
	
	public FlushAlgo(List<Card> cardsList) {
		
		this.imputCardsList = cardsList;
		
	}
	
	// method to be called to check if combination is flush
	public boolean determineResult() {
		if(this.checkForStreights(this.imputCardsList)) {
			return false;
		}
		
		return this.checkFlush(this.imputCardsList);
	}
	
	private boolean checkFlush(List<Card> cardsList) {
		
		Set<String> distinctSet = new HashSet<>();
		
		for (Card card : cardsList) 
		{ 
			distinctSet.add(card.CardSuit);
		}
		
		if(distinctSet.size() > 1) {
			return false;
		}
		
		return true;
	}
	
	// first checker for streight 
	private boolean checkForStreights(List<Card> cardsList) {
		
		ArrayList<Integer> indexies = new ArrayList<Integer>();
		
		for (Card card : cardsList) 
		{ 
			indexies.add(Arrays.asList(this.cardOrder).indexOf(card.CardType));
		}	
		
		Collections.sort(indexies);
		
		for (int i=0; i<indexies.size()-1; i++) {
			  if (indexies.get(i) +1 != indexies.get(i + 1)) {
				  return false;
			  }
			 }
		return true;		
	}
	
}
