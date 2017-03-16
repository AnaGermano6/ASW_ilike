package ilike.shared;

public class Review {
	
	String autorId(){
		return null;
		//id do autor da critica
	}
	
	String topicId(){
		return null;
		//id do tópico criticado
	}
	
	Rating rating(){
		return null;
		//pontuação do tópico
	}
	
	String descrição(){
		return null;
		//descrição da crítica
	}
	
	
	boolean equals(Item){
		//verificar se 2 items são iguais
	}
	
	int hashCode(Item){
		//função de partição
	}
	
	@Override
	public String toString() {
		return "Review [autorId()=" + autorId() + ", topicId()=" + topicId() + ", rating()=" + rating()
				+ ", descrição()=" + descrição() + ", equals()=" + equals() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	

}
