package ilike.tag;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

	public List<Item> getList() {
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
	 * @param i item 
	 */

	public void index(Item id) {
		
		for (Item pointer : list) {
			if (pointer.tags.size() < id.tags.size()) {
				list.add(list.indexOf(pointer), id);
				break;
			} else if (pointer.tags.size() == id.tags.size()) {
				List<Item> arrayTemp = new LinkedList<Item>();
				for (int j = list.indexOf(pointer); j < list.size(); j++) {
					if (pointer.tags.size() == id.tags.size()) {
						arrayTemp.add(list.get(list.indexOf(pointer) + j));
						list.remove(list.get(list.indexOf(pointer) + j));
					}
				}
				// ordenar os ids
				String idArray[] = new String[arrayTemp.size()];
				for (Item tempItem : arrayTemp)
					idArray[arrayTemp.indexOf(tempItem)] = tempItem.id;
				Arrays.sort(idArray);

				
				//volta a colocar na ordem certa ja ordenada
				for (int c = 0; c < idArray.length; c++) {
					Item toAdd = new Item();
					for (Item temp : arrayTemp) {
						if (temp.id.equals(idArray[c]))
							toAdd = temp;
						break;
					}
					list.add(list.indexOf(pointer) + c, toAdd);
				}
			}
		}
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
		//Criar nova lista de strings L
		//para cada tag no conjunto s, procurar na lista list por items 
		//que tenham essa tag no seu conjunto de tags.
		//Se o item tem, adicionar o seu ID à lista L
		
		//retorna L
		
		
		LinkedList<String> ids = new LinkedList<String>();
		
		if(list.isEmpty())
			return ids;
		
		for(Item pointer: list){
			if(s.contains(pointer.tags)){
				ids.addLast(pointer.id);
			}
		}		
		return ids;
	}
}