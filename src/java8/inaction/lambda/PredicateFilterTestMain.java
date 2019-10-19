package java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;

public class PredicateFilterTestMain {

	public static void main(String[] args) {
		List<String> godFatherCast = Arrays.asList("Marlon Brando", 
				"Al Pacino", 
				"James Caan", 
				"Richard S. Castellano", 
				"Robert Duvall", 
				"Sterling Hayden", 
				"John Marley", 
				"Richard Conte", 
				"Al Lettieri", 
				"Diane Keaton", 
				"Abe Vigoda", 
				"Talia Shire", 
				"Gianni Russo", 
				"John Cazale", 
				"Rudy Bond");
		@SuppressWarnings("unused")
		Movie godFarther = new Movie("Godfather", "Francis Ford Coppola", godFatherCast);
		List<String> dogDayAfternoonCast = Arrays.asList("Penelope Allen", 
				"Sully Boyar", 
				"John Cazale", 
				"Beulah Garrick", 
				"Carol Kane", 
				"Sandra Kazan", 
				"Marcia Jean Kurtz", 
				"Amy Levitt", 
				"John Marriott", 
				"Estelle Omens", 
				"Al Pacino", 
				"Gary Springer", 
				"James Broderick", 
				"Charles Durning", 
				"Carmine Foresta");
		@SuppressWarnings("unused")
		Movie dogDayAfternoon = new Movie("Dog Day Afternoon", "Sidney Lumet", dogDayAfternoonCast);
		
		
	}

}
