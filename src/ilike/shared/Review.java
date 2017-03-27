package ilike.shared;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Review extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String authorId;
	public String topicId;
	public Rating rating;
	public String description;
	
	public Review(String id, String name, Set<String> tags, String autorId, String topicId, Rating rating,
			String description) {
		super(id, name, tags);
		this.authorId = autorId;
		this.topicId = topicId;
		this.rating = rating;
		this.description = description;
	}
	
	
	public String getAuthorId() {
		return authorId;
	}


	public void setAuthorId(String autorId) {
		this.authorId = autorId;
	}


	public String getTopicId() {
		return topicId;
	}


	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}


	public Rating getRating() {
		return rating;
	}


	public void setRating(Rating rating) {
		this.rating = rating;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String descrição) {
		this.description = descrição;
	}
	
	Set<String> getRelatedItemIds(){
		// adicionar os Ids do item
		HashSet<String> hs = new HashSet<String>();
		hs.add(authorId);
		hs.add(topicId);
		return hs; 
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (rating != other.rating)
			return false;
		if (topicId == null) {
			if (other.topicId != null)
				return false;
		} else if (!topicId.equals(other.topicId))
			return false;
		return true;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((topicId == null) ? 0 : topicId.hashCode());
		return result;
	}
	
	
	@Override
	public String toString() {
		return "Review [authorId=" + authorId + ", topicId=" + topicId + ", rating=" + rating + ", description="
				+ description + "]";
	}
}
