package ilike.socnet;

import java.util.Observer;
import java.util.LinkedList;
import java.util.Observable;

import ilike.shared.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */ 

public class Notifier extends Observable{
	private LinkedList<Follow> list;
	
	/**
	 * class auxiliar para guardar os items de cada seguidor
	 *
	 */
	
	private class Follow{
		private String id;
		private Observer observer;
		
		public Follow(Observer observer,String id) {
			this.id = id;
			this.observer = observer;
		}

		/**
		 * retorna o id do item
		 * 
		 * @return
		 */
		public String getId() {
			return id;
		}

		/**
		 * retorna o utilizador
		 * 
		 * @return
		 */
		public Observer getObserver() {
			return observer;
		}	
	}
	

	public Notifier() {
		this.list = new LinkedList<Follow>();
	}
	
	/**
	 * retorna a lista de seguidores
	 * @return
	 */
	public LinkedList<Follow> getList() {
		return list;
	}

	/**
	 * altera a lista de seguidores 
	 * @param list
	 */
	
	public void setList(LinkedList<Follow> list) {
		this.list = list;
	}
	

	/**
	 * regista o item que o utilizador tem interesse
	 * 
	 * @param itemId
	 * @param observer
	 */
	

	public void followItem(String itemId,Observer observer){
		list.add(new Follow(observer, itemId));
	}
	

	/**
	 * regista a tag que o utilizador tem interesse
	 * 
	 * @param tag
	 * @param observer
	 */
	
	public void followTag(String tag,Observer observer){
		list.add(new Follow(observer,tag));
	}
	
	/**
	 * utilizador recebem as notificacoes do item do topic, quando alterado
	 * 
	 * @param topic
	 */
	
	public void notifyObservers(Topic topic){
		
		for(Follow f : list){
			if(f.getId().equals(topic.getId()) || topic.getTags().contains(f.getId()))
				super.addObserver(f.getObserver());
		}
		super.setChanged();
		super.notifyObservers(topic.getId());
		super.deleteObservers();
	}
	
	/**
	 * utilizador recebem as notificacoes do item do review, quando alterado
	 * 
	 * @param review
	 */
	
	public void notifyObservers(Review review){
		
		for(Follow f : list){
			if(f.getId().equals(review.getTopicId()))
				super.addObserver(f.getObserver());
		}
		super.setChanged();
		super.notifyObservers(review.getId());
		super.deleteObservers();
	}
}
