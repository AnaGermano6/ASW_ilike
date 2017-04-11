package ilike.socnet;

import java.util.LinkedList;
import java.util.List;

import ilike.shared.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */ 

public class Items {
	//tamanho da lista com últimos itens adicionados
	private static int recentSize; 
	private LinkedList<Item> list;
	
	
	public Items() {
		Items.recentSize = 0;
		this.list = new LinkedList<Item>();
	}
	
	/**
	 * retorna a lista de items
	 * 
	 * @return
	 */
	public LinkedList<Item> getList() {
		return list;
	}

	/**
	 * altera a lista de items
	 * 
	 * @param list
	 */

	public void setList(LinkedList<Item> list) {
		this.list = list;
	}

	/**
	 * retorna o tamanho dos items recentes
	 * 
	 * @return
	 */
	
	public static int getRecentSize() {
		return recentSize;
	}
	
	/**
	 * altera o tamanho dos feeds recentes
	 * @param size
	 */

	public static void setRecentSize(int size) {
		recentSize = size;
	}

	/**
	 * obtem o item atraves do seu id
	 * 
	 * @param id
	 * @return item
	 */

	public Item getItem(String id){
				
		for(Item pointer : list) {
			if(pointer.getId().equals(id))
				return pointer;
			else 
				continue;
		}
		return null;
	}
	
	/**
	 * obtem uma lista de items atraves dos seus ids
	 * @param id
	 * @return listaItems
	 */
	
	
	public List<Item> getItems(List<String> id){
		List<Item> listItems = new LinkedList<Item>();
		
		for(String pointer : id){
			listItems.add(getItem(id.get(id.indexOf(pointer))));
		}
		return listItems;
	}
	
	/**
	 * adiciona o item se nao existir na lista
	 * @param item
	 * @return
	 */
	
	synchronized boolean addItem(Item item){
		if(list.contains(item))
			return false;
		else
			list.add(item);
		return true;
	}

	/**
	 * altera o item se existir na lista
	 * 
	 * @param item
	 * @return
	 */
	
	synchronized boolean changeItem(Item item){
		
		for(Item pointer : list){
			if(list.get(list.indexOf(pointer)).getId().equals(item.getId())){
				list.set(list.indexOf(pointer), item);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * remove o item 
	 * 
	 * @param item
	 * @return
	 */
	
	synchronized boolean removeItem(Item item){
		for(Item pointer : list)
		if(pointer.getId().contains(item.getId())){
			list.remove(item);
			return true;
		}
		return false;
	}
	
	/**
	 * adiciona a lista os items adicionados recentemente 
	 * utilizando um contador para percorrer a lista desde a ultima posicao
	 * 
	 * @return newItems 
	 */
	
	public LinkedList<Item> getRecent(){
		LinkedList<Item> newItems = new LinkedList<Item>();
	
		int count = 1; 
		
		if(recentSize == 0)
			return null;
		
		for(int i = 0; i < list.size(); i++) {
			if(newItems.size()<getRecentSize()){
				newItems.add(list.get(list.size()-count));
			}
			count++;
		}
		
		return newItems;
	}
}