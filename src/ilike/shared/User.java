package ilike.shared;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set; 

public class User extends Item implements Observer{
	
	private static final long serialVersionUID = 1L;
	public static int feedSize; //Número de elementos do feed
	public List<String> feeds;
	
	User(String id, String name, Set<String> tags) {
		super(id, name, tags);
		this.feeds = new LinkedList<String>();
	}

	public static int getFeedSize() {
		return feedSize;
	}

	public static void setFeedSize(int feedSize) {
		User.feedSize = feedSize;
	}

	/**
	 * actualizacoes ao utilizador
	 * @return
	 */
	public List<String> getFeed(){
		return feeds;
	}

	public void setFeeds(List<String> feeds) {
		this.feeds = feeds;
	}
	
	
	/**
	 * recebe as noticicacoes
	 */
	
	@Override
	public void update(Observable o, Object arg) {		
		((LinkedList<String>) feeds).addFirst(arg.toString());
		
		if(feeds.size()>User.getFeedSize()){
			feeds.remove(feeds.size()-1);
		}
	}
}
