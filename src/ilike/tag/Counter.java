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
	public LinkedList<String> words; 
	public LinkedList<CountWords> counterWords;
	
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

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
		
		public int intValue() {
			return count;
		}

		@Override
		public int compareTo(CountWords w) {
			if(this.count < w.count)
				return 1;
			if(this.count > w.count)
				return -1;
			return 0;
		}
	}
	
		
	public Counter() {
		this.words = new LinkedList<String>();
		this.counterWords = new LinkedList<CountWords>();
	}

	public LinkedList<String> getWords() {
		return words;
	}

	public void setWords(LinkedList<String> words) {
		this.words = words;
	}

	public LinkedList<CountWords> getCounterWords() {
		return counterWords;
	}


	public void setCounterWords(LinkedList<CountWords> counterWords) {
		this.counterWords = counterWords;
	}
	
	public CountWords get(String stringWords) {
		
		for(CountWords w : counterWords){
			if(w.word.equals(stringWords))
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
	 * Atribui uma contagem à palavra
	 * 
	 * @param word
	 * @param count
	 */
	
	public void put(String word,int count){
		
		for(CountWords w: counterWords){
			if(w.word.equals(word))
				w.setCount(count);
			counterWords.add(new CountWords(word, count));
		}
		
	}
	
	/**
	 * lista de palavras contadas ordenada
	 * 
	 * @return words
	 */
	
	public LinkedList<String> getSorted(){
		
		Collections.sort(counterWords);
		
		for(CountWords w : counterWords){
			words.add(w.word);
		}	
		
		return words;
	}
}