package ilike.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Topic extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public Date date;
	public String description;
	public List<String> topics;
	
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


	public List<String> getReviews() {
		return topics;
	}


	public void setReviews(List<String> reviews) {
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


	void addReview(String id){
		//adiciona o ID de uma crítica
		this.topics.add(id);
		
	}
	
	void removeReview(String id){
		//remove o ID de uma crítica
		this.topics.remove(id);
	}
	
	public List<String> getReviews(String id){
		//lista de críticas associadas ao tópico
		return topics;
		
	}

}
