package ilike.shared;

import java.util.Set;

public class Item {
	Item item =new Item();
	public static String id;
	public static String name;
	

	String id(){
		return this.id;	
	}
	
	String name(){
		return this.name;
	}
	
	Set<String> tags(){
		
		//conjunto de tags classificando o item
		return null;
		
	}
	
	//funcaoo de particao
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	//verifica se 2 items são iguais
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	//representa como string
	@Override
	public String toString() {
		return "Item [id()=" + id() + ", name()=" + name() + ", tags()=" + tags() + ", equals()=" + equals(item)
				+ ", hashCode()=" + hashCode() + ", getRelatedItemIds()=" + getRelatedItemIds() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	
	
	Set<String> getRelatedItemIds(){
		
	/*conjunto de IDs relacionados com item, de modo que se este for criado ou alterado, 
	 * estes também devem ser notificados. Este método destina-se a ser redefinido por algumas classe, 
	 * e na versão genérica retorna o conjunto vazio.
	 */
		return null;
		
	}
	
	
}
