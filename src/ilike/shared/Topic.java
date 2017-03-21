package ilike.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Topic extends Item implements Serializable {
	public Date date;
	public String description;
	public List<String> reviews;
	
	Topic(String id, String name, Set<String> tags, String description, Date date) {
		super(id, name, tags);
		this.date = date;
		this.description = description;
		this.reviews = new LinkedList<String>();
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
		return reviews;
	}


	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
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
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Topic [date=" + date + ", description=" + description + ", reviews=" + reviews + "]";
	}


	void addReview(String id){
		//adiciona o ID de uma crítica
		this.reviews.add(id);
		
	}
	
	void removeReview(String id){
		//remove o ID de uma crítica
		this.reviews.remove(id);
	}
	
	public List<String> getReviews(String id){
		//lista de críticas associadas ao tópico
		return reviews;
		
	}

}
