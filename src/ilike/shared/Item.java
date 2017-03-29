package ilike.shared;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Ana Germano up201105083
 *
 */

public class Item implements Serializable, Comparable<Item>{
	
	private static final long serialVersionUID = 1L;
	public String id;
	public String name;
	public Set<String> tags;
	
	public Item(){
		setId("");
		setName("");
		setTags(new HashSet<String>());
		
	}
	
	public Item(String id, String name, Set<String> tags) {
		setId(id);
		setName(name);
		setTags(tags);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getTags() {
		if(tags==null) return new HashSet<String>();
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", tags=" + tags + ", hashCode()=" + hashCode()
				+ ", getRelatedItemIds()=" + getRelatedItemIds() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	Set<String> getRelatedItemIds(){
		return new HashSet<String>();
	}

	@Override
	public int compareTo(Item o) {
		
		
		return 0;
	}	
}
