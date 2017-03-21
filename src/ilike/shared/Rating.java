package ilike.shared;
/*
import java.util.Set;

public class Rating extends Item {
	
	public Rating(String id, String name, Set<String> tags) {
		super(id, name, tags);
		// TODO Auto-generated constructor stub
	}

	enum Critica {ZERO, ONE, TWO, THREE, FOUR, FIVE};
	
	public String ratingCritica(Critica critica){
		
		String descCritica;
		
		switch(critica){
		
			case ZERO: descCritica= "muito mau" ;
						break;
			case ONE: descCritica = "fraquinho";
						break;
			case TWO: descCritica = "medio";
						break;
			case THREE: descCritica = "Bom";
						break;
			case FOUR: descCritica ="muito bom";
						break;
			case FIVE: descCritica = "Exelente";
						break;
			default: descCritica = "ja nao ah mais";
						break;
		
		}
		
		return descCritica;
		
	}
	
	String nome;

	public Rating(String nome) {
		super();
		this.nome = nome;
	}

}*/


public enum Rating { 
	ZERO("muito mau"), 
	ONE("fraquinho"), 
	TWO("media"),
	THREE("bom"), 
	FOUR("muito bom"), 
	FIVE("Exelente");
	
	String disc;

	private Rating(String disc) {
		this.disc = disc;
	}
	
}
