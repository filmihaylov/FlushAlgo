import java.util.ArrayList;
import java.util.List;

import BussinessLogic.Card;
import BussinessLogic.FlushAlgo;

public class Main {

	//pass Jc 6c Tc 3c Kc as arguments
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<Card>();
		
		 for (String s: args) {
	            cards.add(new Card(s));
	        }
		
		 FlushAlgo algo = new FlushAlgo(cards);
		 
		 System.out.print(algo.determineResult());
	}
	
}

