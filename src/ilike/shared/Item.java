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
	private String id;
	private String name;
	private Set<String> tags;
	
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
	
	/**
	 * retorna valor id
	 * 
	 * @return
	 */

	public String getId() {
		return id;
	}
	
	/**
	 * altera o valor do id
	 * 
	 * @param id
	 */

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * retorna o nome
	 * 
	 * @return
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * altera no nome
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * retorna as tags
	 * 
	 * @return
	 */

	public Set<String> getTags() {
		if(tags==null) 
			return new HashSet<String>();
		return tags;
	}

	/**
	 * altera as tags
	 * 
	 * @param tags
	 */
	
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	/**
	 * cria hashcode
	 * 
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}
	
	/**
	 * compara dois objectos 
	 * 
	 */
	
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

	/**
	 * retorna uma string discritiva do objecto 
	 */
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", tags=" + tags + "]";
	}
	
	
	/**
	 * retorna o conjunto de ids relacionados com o item
	 * 
	 * @return hashset
	 */
	
	
	Set<String> getRelatedItemIds(){
		return new HashSet<String>();
	}
	
	/**
	 * compara por ids lexicograficamente
	 * 
	 */

	@Override
	public int compareTo(Item item) {
		if(this.getId().compareTo(item.getId()) < 0)
			return 1;
		if(this.getId().compareTo(item.getId()) > 0)
			return -1;
		return (this.getId().compareTo(item.getId()));
	}	
}
