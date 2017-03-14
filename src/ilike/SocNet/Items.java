package ilike.SocNet;

public class Items {
	static int recentSize; //tamanho da lista com últimos itens adicionados
	
	Item getItem(String id){
		//obter item dado o seu ID
	}
	
	List<Item> getItem(List<String> id){
		//obter items dado o seus ID
	}
	
	boolean addItem(Item item){
		//adiciona item, apenas se não existe outro com o mesmo ID, retornando verdade se tiver sido adicionado
	}
	
	boolean changeItem(Item item){
		//altera item, apenas se já existir, retornando verdade se tiver sido alterado
	}
	
	boolean removeItem(Item item){
		//remove item, apenas se já existir, retornando verdade se tiver sido removido
	}
	
	List<Item> getRecent(){
		//Retorna últimos itens adicionados numa lista com, no máximo, recentSize elementos
	}


}
