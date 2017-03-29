package ilike.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Set;

/**
 * 
 * @author Ana Germano up201105083
 *
 */

public class Topic extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public Date date;
	public String description;
	public LinkedList<String> topics;
	
	Topic(String id, String name, Set<String> tags, String description, Date date) {
		super(id, name, tags);
		this.date = date;
		this.description = description;
		this.topics = new LinkedList<String>();
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LinkedList<String> getReviews() {
		return topics;
	}


	public void setReviews(LinkedList<String> reviews) {
		this.topics = reviews;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((topics == null) ? 0 : topics.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (topics == null) {
			if (other.topics != null)
				return false;
		} else if (!topics.equals(other.topics))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Topic [date=" + date + ", description=" + description + ", reviews=" + topics + "]";
	}

	/**
	 * Adiciona o id de uma critica na lista
	 * 
	 * @param id
	 */
	
	public void addReview(String id){
		this.topics.add(id);
	}
	
	/**
	 * Remove o id da uma critica da lista
	 * 
	 * @param id
	 */
	
	public void removeReview(String id){
		this.topics.remove(id);
	}
	
	/**
	 *lista de criticas associadas ao topico
	 * 
	 * @param id
	 * @return 
	 */
	public LinkedList<String> getReviews(String id){
		return topics;
	}
}