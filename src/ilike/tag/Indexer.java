package ilike.tag;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Set;

import ilike.shared.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */

public class Indexer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	LinkedList<Item> list;

	Indexer() {
		this.list = new LinkedList<Item>();
	}

	public LinkedList<Item> getList() {
		return list;
	}

	public void setList(LinkedList<Item> list) {
		this.list = list;
	}
	
	/**
	 * Regista o id do item indexado pelas suas tags
	 * No caso de ter varios com o mesmo tamanho é necessario o break
	 * vai garantir que nao repete o mesmo  id
	 * 
	 * @param id item 
	 */

	public void index(Item id) {
		list.add(id);
	}
	
	/**
	 * remove o registo do id do item associado às suas tags
	 * 
	 * @param id
	 */
	
	public void unindex(Item id) {
		list.remove(id);
	}

	/**
	 * retorna a lista IDs dos items contendo alguma das tags no conjunto dado
	 * 
	 * @param s
	 * @return
	 */
	 
	public LinkedList<String> search(Set<String> s) {
		
		Counter counter = new Counter(); 
		
		for(Item pointer: list){
			//procura por tags
			for(String tags : s){
				if(pointer.getTags().contains(tags)){
					counter.count(pointer.getId());
				}
			}
		}		
		return counter.getSorted();
	}
}