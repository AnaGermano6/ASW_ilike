package ilike.tag;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ilike.shared.*;

public class Trie {
	List<String> l = new LinkedList<String>();

	
	//nó da estrutura trie
	class Node extends HashMap<Character,Node>{
		int count; //numero de ocorrências da palavra correspondente a este nó
		
		
		void put(String word, int index, int delta){
			//coloca neste nó a letra da string no índice dado. (recursivamente coloca as restantes letras em nós descendentes). Quando a palavra é encontrada a contagem varia em delta.
			
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
	List<String> getWordsStarting(String prefix){
		//Percorre a trie em busca de palavras começadas pelo prefixo dado e retorna-as como uma lista ordenada.
		
	}
	
}
