package ilike.shared;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set; 

/**
 * 
 * @author Ana Germano up201105083
 *
 */ 

public class User extends Item implements Observer{
	
	private static final long serialVersionUID = 1L;
	private static int feedSize; //numero de elementos do feed
	private LinkedList<String> feeds;
	
	public User(String id, String name, Set<String> tags) {
		super(id, name, tags);
		this.feeds = new LinkedList<String>();
	}

	/**
	 * retorna o tamanho do feed
	 * 
	 * @return
	 */
	
	public static int getFeedSize() {
		return feedSize;
	}
	
	/**
	 * altera o tamanho da feed
	 * 
	 * @param size
	 */
	
	public static void setFeedSize(int size) {
		feedSize = size;
	}

	/**
	 * actualizacoes ao utilizador
	 * 
	 * @return feeds
	 */
	
	public LinkedList<String> getFeed(){
		return feeds;
	}
	
	/**
	 * altera o feed
	 * 
	 * @param feedList
	 */
	
	public void setFeeds(LinkedList<String> feedList) {
		feeds = feedList;
	}
	
	
	/**
	 * recebe as noticicacoes
	 * 
	 */
	
	@Override
	public void update(Observable o, Object arg) {		
		feeds.addFirst((String) arg);
		
		if(feeds.size()> feedSize){
			feeds.removeLast();
		}
	}
}