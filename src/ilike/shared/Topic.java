package ilike.shared;

import java.sql.Date;

public class Topic extends Item{
	public static String id;
	
	Date date(){
		
		//data do tópico (exemplo, evento)
		return null;
	}
	
	String description(){
	
		//descrição do tópico
		return null;
	}
	
	void addReview(String id){
		//adiciona o ID de uma crítica
	}
	
	void removeReview(String id){
		//remove o ID de uma crítica
	}
	
	List<String> getReviews(String id){
		//lista de críticas associadas ao tópico
	}
	

}
