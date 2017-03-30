package ilike.tag;

import java.util.*;

import ilike.shared.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */

public class Trie {
	LinkedList<String> list = new LinkedList<String>();
	
	
	
	//nó da estrutura trie
	class Node extends HashMap<Character,Node>{
		int count; //numero de ocorrências da palavra correspondente a este nó
		char charact; //caracter
		boolean finalWord; //se é uma palavra
		
		HashMap<Character, Node> charNode;
		
		public Node() {
			this.count = 0;
			this.charact=charact;
		}
		
		public char getCharact() {
			return charact;
		}

		public void setCharact(char charact) {
			this.charact = charact;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		void put(String word, int index, int delta){
			//coloca neste nó a letra da string no índice dado. (recursivamente coloca as restantes letras em nós descendentes). Quando a palavra é encontrada a contagem varia em delta.
			
			for(Node no: ){
				
			}
			
		}
		getWordsStartingWith(String word, int index, StringBuffer buffer, Counter counter){
			//Desce a trie em busca de palavras com um dado prefixo, construindo as palavras no buffer e usando counter para recolher as palavras
			
		}
		
	}
	
	void increaseTags(Item item){
		//incrementa as tags do item na estrutura de nós (iniciando na raiz). Se uma tag não existe cria-a; senão incrementa a contagem
		
	}
	void decreaseTags(Item item){
		//decrementa as tags do item na estrutura de nos (iniciando na raiz).
		
	}
	LinkedList<String> getWordsStarting(String prefix){
		//Percorre a trie em busca de palavras começadas pelo prefixo dado e retorna-as como uma lista ordenada.
		
	}
	
}
