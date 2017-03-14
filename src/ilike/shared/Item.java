package ilike.shared;

import java.util.Set;

public class Item {

	String id(){
		
		//id do item
		return null;
		
	}
	
	String name(){
		
		//nome do item
		return null;
		
	}
	
	Set<String> tags(){
		
		//conjunto de tags classificando o item
		return null;
		
	}
	
	
	boolean equals(Item){
		//verifica se 2 items são iguais
	}
	
	public int hashCode(Item){
		//função de partição
	}
	
	public String toString(){
		//representar como string
	}
	
	
	Set<String> getRelatedItemIds(){
		
	/*conjunto de IDs relacionados com item, de modo que se este for criado ou alterado, 
	 * estes também devem ser notificados. Este método destina-se a ser redefinido por algumas classe, 
	 * e na versão genérica retorna o conjunto vazio.
	 */
		return null;
		
	}
	
	
}
