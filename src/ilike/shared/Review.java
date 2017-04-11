package ilike.shared;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Ana Germano up201105083
 *
 */

public class Review extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String authorId;
	private String topicId;
	private Rating rating;
	private String description;
	
	public Review(String id, String name, Set<String> tags, String autorId, String topicId, Rating rating,
			String description) {
		super(id, name, tags);
		this.authorId = autorId;
		this.topicId = topicId;
		this.rating = rating;
		this.description = description;
	}
	
	/**
	 * retorna valor authorid
	 * 
	 * @return
	 */
	
	public String getAuthorId() {
		return authorId;
	}

	/**
	 * altera o authorid
	 * 
	 * @param autorId
	 */

	public void setAuthorId(String autorId) {
		this.authorId = autorId;
	}

	/**
	 * retorna valor topicid
	 * 
	 * @return
	 */

	public String getTopicId() {
		return topicId;
	}

	/**
	 * altera o topicid
	 * 
	 * @param topicId
	 */
	
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	/**
	 * retorna valor o rating
	 * 
	 * @return
	 */

	public Rating getRating() {
		return rating;
	}

	/**
	 * altera o rating 
	 * 
	 * @param rating
	 */

	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	/**
	 * retorna valor da descricao
	 * 
	 * @return
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * altera o rating 
	 * 
	 * @param descrição
	 */
	
	public void setDescription(String descrição) {
		this.description = descrição;
	}
	
	
	/**
	 * adiciona os Ids do item
	 * 
	 */
	public Set<String> getRelatedItemIds(){ 
		HashSet<String> hs = new HashSet<String>();
		hs.add(authorId);
		hs.add(topicId);
		return hs; 
	}

	/**
	 * compara dois objectos 
	 * 
	 */
	
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

	/**
	 * cria hashcode
	 * 
	 */
	
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
	
	/**
	 * retorna uma string discritiva do obejecto 
	 */
	
	@Override
	public String toString() {
		return "Review [authorId=" + authorId + ", topicId=" + topicId + ", rating=" + rating + ", description="
				+ description + "]";
	}
}
