package ilike.shared;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set; 

public class User extends Item implements Observer{
	static int feedSize; //Número de elementos do feed
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


	public List<String> getFeed(){
		//atualizações destinadas ao utilizador, que excedem feedSize
		return feeds;
	}

	public void setFeeds(List<String> feeds) {
		this.feeds = feeds;
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		((LinkedList<String>) feeds).addFirst(arg.toString());
		
		if(feeds.size()>this.getFeedSize()){
			feeds.remove(feeds.size()-1);
		}
	}
}
