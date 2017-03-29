package ilike.shared;

/**
 * 
 * classificacao de uma critica
 * 
 * @author Ana Germano up201105083
 *
 */

public enum Rating { 
	ZERO("very bad"), 
	ONE("weak"), 
	TWO("average"),
	THREE("good"), 
	FOUR("very good"), 
	FIVE("excellent");
	
	String disc;

	private Rating(String disc) {
		this.disc = disc;
	}
	
}
