package ilike.SocNet;

import java.util.LinkedList;

import ilike.shared.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */ 

public class Items {
	static int recentSize; //tamanho da lista com últimos itens adicionados
	LinkedList<Item> ids;
	
	
	public Items(int recentSize) {
		super();
		this.recentSize = recentSize;
		this.ids = new LinkedList<Item>();
	}
	
	
	public static int getRecentSize() {
		return recentSize;
	}

	public static void setRecentSize(int recentSize) {
		Items.recentSize = recentSize;
	}


	Item getItem(String id){
		return null;
		//obter item dado o seu ID
	}
	
	
	LinkedList<Item> getItem(LinkedList<String> id){
		return ids;
		//obter items dado o seus ID
	}
	
	boolean addItem(Item item){
		return false;
		//adiciona item, apenas se não existe outro com o mesmo ID, retornando verdade se tiver sido adicionado
	}

	
	boolean changeItem(Item item){
		return false;
		//altera item, apenas se já existir, retornando verdade se tiver sido alterado
	}
	
	boolean removeItem(Item item){
		return false;
		//remove item, apenas se já existir, retornando verdade se tiver sido removido
	}
	
	
	LinkedList<Item> getRecent(){
		return ids;
		//Retorna últimos itens adicionados numa lista com, no máximo, recentSize elementos
	}


}
