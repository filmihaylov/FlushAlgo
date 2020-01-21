package Tests;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import BussinessLogic.Card;
import BussinessLogic.FlushAlgo;

class FlushAlgoTests {

	private static List<List<Card>> combinations = new ArrayList<>();
	private static List<String> results = new ArrayList<>();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		try(BufferedReader br = new BufferedReader(new FileReader("src/Tests/TestData"))) {
		    String line = br.readLine();

		    while (line != null) {
		    	parseTestData(line);
		        line = br.readLine();
		    }

		}
	}

	
	@Test
	void testFlushAlgo() {
		for(int i=0; i< combinations.size(); i++) {
			List<Card> cards = combinations.get(i);
			String result = results.get(i);
			
			FlushAlgo algo = new FlushAlgo(cards);			
			boolean booleanResult = Boolean.parseBoolean(result);
			
			assertTrue("Flash Algo Test Failed", (algo.determineResult() == booleanResult));
		}
	}
	
	// Method to parse test file data
	private static void parseTestData(String line) {
		
		List<String> splittedString = Arrays.asList(line.split("\\s+"));
		int splittedStringSize = splittedString.size()-1;
		results.add(splittedString.get(splittedStringSize));
		List<Card> cards = new ArrayList<>();
		
		List<String> cardValues = splittedString.subList(0, splittedStringSize);
		
		for (String s: cardValues) {
			cards.add(new Card(s));
        }
		
		combinations.add(cards);
		
	}
	

}
