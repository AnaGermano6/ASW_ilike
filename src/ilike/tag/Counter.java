package ilike.tag;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

import ilike.shared.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */

public class Counter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private LinkedList<String> words; 
	private LinkedList<CountWords> counterWords;
	
	/**
	 * class auxiliar para a contagem de palavras
	 *
	 */
	
	public class CountWords implements Comparable<CountWords>{
		private String word;
		private int count;
		
		CountWords(String word, int count) {
			this.word = word;
			this.count = count;
		}

		/**
		 * retorna a palavra
		 * 
		 * @return
		 */
		
		public String getWord() {
			return word;
		}

		/**
		 * altera a palavra
		 * 
		 * @param word
		 */
		
		public void setWord(String word) {
			this.word = word;
		}

				
		/**
		 * altera o numero de palavras
		 * 
		 * @param count
		 */

		public void setCount(int count) {
			this.count = count;
		}
		
		/**
		 * retorna o numero de palavras
		 * 
		 * @return
		 */
		public int intValue() {
			
			return count;
		}
		
		/**
		 * compara e ordena lexicograficamente 
		 * 
		 */

		@Override
		public int compareTo(CountWords w) {
			if(this.count < w.count)
				return 1;
			if(this.count > w.count)
				return -1;
			return this.word.compareTo(w.word);
		}
	}
	
		
	public Counter() {
		this.words = new LinkedList<String>();
		this.counterWords = new LinkedList<CountWords>();
	}
	
	/**
	 * retorna a lista de palavras
	 * 
	 * @return
	 */

	public LinkedList<String> getWords() {
		return words;
	}
	
	/**
	 * altera as palavras 
	 * 
	 * @param words
	 */

	public void setWords(LinkedList<String> words) {
		this.words = words;
	}
	
	/**
	 * retorna a lista de contador de palavras
	 * 
	 * @return
	 */

	public LinkedList<CountWords> getCounterWords() {
		return counterWords;
	}

	/**
	 * altera a lista de contador de palavras
	 * 
	 * @param counterWords
	 */
	
	public void setCounterWords(LinkedList<CountWords> counterWords) {
		this.counterWords = counterWords;
	}
	
	/**
	 * retorna a palavra caso exista na lista
	 * 
	 * @param stringWords
	 * @return
	 */
	
	public CountWords get(String stringWords) {
		
		for(CountWords w : counterWords){
			if(w.getWord().equals(stringWords))
				return w;
		}
		
		return null;
	}

	/**
	 * conta cada palavra
	 * @param word
	 */
	
	public void count(String word){
		int countWords=0;
		words.add(word);
		
		for(String searchWords: words){
			if(searchWords.equals(word))
				countWords++;
		}	
		
		put(word, countWords);
	}
	
	/**
	 * Atribui uma contagem a palavra
	 * 
	 * @param word
	 * @param count
	 */
	
	public void put(String word,int count){
		
		boolean check=false; 
		
		for(CountWords w: counterWords){
			if(w.word.equals(word)){
				w.setCount(count);
				check=true;
			}
		}
		//verificacao se a palavra esta na lista
		if(check!=true)
			getCounterWords().add(new CountWords(word, count));	
	}
	
	/**
	 * lista de palavras contadas ordenada
	 * 
	 * @return words
	 */
	
	public LinkedList<String> getSorted(){
		LinkedList<String> list = new LinkedList<String>();
		
		Collections.sort(counterWords);
		
		for(CountWords w : counterWords){
			list.add(w.word);
		}	
		return list;
	}
}