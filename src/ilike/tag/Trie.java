package ilike.tag;

import java.io.Serializable;
import java.util.*;
import ilike.shared.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */

public class Trie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//coloca na primeira posicao
	private final int INDEX = 0;
	//sinaliza se é palavra
	private final int DELTA_WORD = 1;
	//incrementa 
	private final int INCREMENTA = 1;
	private Node no;
	private LinkedList<String> list;
	
	
	/**
	 * class auxiliar da estrutura da arvore trie
	 *
	 */
	
	private class Node extends HashMap<Character, Node> {
		//numero de ocorrencias da palavra correspondente ao no
		private int count;
	    private boolean isLeaf;
	    
	    
	    Node(){
	    	count = 0;
	    }
	    
	    /**
	     * retorna o numero de ocorrencias
	     * 
	     * @return
	     */
	    
		public int getCount() {
			return count;
		}
		
		/**
		 * altera no numero de ocorrencias
		 * 
		 * @param count
		 */
		
		public void setCount(int count) {
			this.count = count;
		}
		
		/**
		 * Remove a tag quando o contador esta a zero
		 * 
		 * @param word
		 * @param index
		 * @return
		 */	
		
		private boolean isRemoved(String word, int index){
			boolean freed = false;
			
			if(isLeaf == true){
				count--;
				if(count == 0){
					freed = true;		
				}
			}		
			else{
				if(index < word.length()){
					char character = word.charAt(index);
					
					if(this.containsKey(character)){
						if(this.get(character).isRemoved(word, index + INCREMENTA)){
							this.remove(character);
							
							if(count > 0)
								isLeaf=true;
						}
					}
				}
			}
			return freed; 
		}
		
	
		/**
		 * coloca no nó a letra da string no índice 
		 * Quando a palavra é encontrada a contagem varia em delta.
		 * 
		 * @param word
		 * @param index
		 * @param delta
		 */
		
		public void put(String word, int index, int delta){
			
			if(index < word.length()){
				char character = word.charAt(index);
				
				if(this.containsKey(character)){
					Node no = get(character);
					no.put(word, index + INCREMENTA, delta);
				}
				else{
					Node no = new Node();
					put(character, no);
					no.put(word, index + INCREMENTA , delta);
				}
			}
			else{
				isLeaf = true; 
				count++;
				return;
			}
			
			if(index == word.length())
				delta++;
		
		}
		
		/**
		 * Desce a trie em busca de palavras com o prefixo
		 * constroi as palavras no buffer
		 * usa counter para recolher as palavras
		 * 
		 * @param word
		 * @param index
		 * @param buffer
		 * @param counter
		 */
		
		public void getWordsStartingWith(String word, int index, StringBuffer buffer, Counter counter){	
			
			if(isLeaf == true){
				counter.put(buffer.toString(), count);
				return ;
			}
			if(index < word.length()){
				char currentCharacter = word.charAt(index);
				
				if(this.containsKey(currentCharacter)){
					Node no = this.get(currentCharacter);
					no.getWordsStartingWith(word, index + INCREMENTA, buffer, counter);
				}
			}
			else{
				
				for(char c : this.keySet()){
					buffer.append(c);
					
					Node no = this.get(c);
					no.getWordsStartingWith(word, index + INCREMENTA, buffer, counter);
					buffer.deleteCharAt(buffer.length() - INCREMENTA);	
				}
			}
		}
	}
	
	
	
	public Trie(){
		no = new Node();
		list = new LinkedList<>();		
	}
	
	/**
	 * retorna o no
	 * 
	 * @return
	 */
		
	public Node getNo() {
		return no;
	}
	
	/**
	 * altera o no
	 * 
	 * @param no
	 */

	public void setNo(Node no) {
		this.no = no;
	}
	
	/**
	 * retorna a lista de palavras
	 * 
	 * @return
	 */

	public LinkedList<String> getList() {
		return list;
	}
	
	/**
	 * altera a lista de palavras
	 * 
	 * @param list
	 */
	
	public void setList(LinkedList<String> list) {
		this.list = list;
	}

	
	/**
	 * incrementa as tags do item na estrutura de nós
	 * Se uma tag existir incrementa a contagem senao é criada uma tag nova
	 * 
	 * @param item
	 */

	public void increaseTags(Item item) {
		for(String tags : item.getTags())
			no.put(tags, INDEX, DELTA_WORD);	
	}	
	
	/**
	 * decrementa as tags do item na estrutura de nos 
	 * 
	 * @param item
	 */
	
	public void decreaseTags(Item item) {
	
		for(String tags : item.getTags()){
			no.isRemoved(tags, INDEX);
		}
	}
	
	
	/**
	 * Percorre a trie em busca de palavras começadas pelo prefixo
	 * adiciona na lista ordenadamente
	 * 
	 * @param prefix
	 * @return list
	 */
	
	public List<String> getWordsStartingWith(String prefix) {
		Counter counter = new Counter();	
		
		no.getWordsStartingWith(prefix, INDEX, new StringBuffer(prefix), counter);
		return counter.getSorted();
	}
}