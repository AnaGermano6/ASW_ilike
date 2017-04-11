package ilike.socnet;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import ilike.shared.*;
import ilike.tag.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */ 

public class Manager implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static File file = new File("manager.ser");
	private static Manager manager = null;
	private Authenticator authenticator;
	private Notifier notifier;
	private Items items;
	private Trie trie;
	private Indexer indexer;
	
	
	public Manager() {
		this.authenticator = new Authenticator();
		this.notifier = new Notifier();
		this.items = new Items();
		this.trie = new Trie();
		this.indexer  = new Indexer();
	}

	/**
	 * @return authenticator
	 */
	
	public Authenticator getAuthenticator() {
		return authenticator;
	}

	/**
	 * altera o authenticator
	 * 
	 * @param authenticator
	 */
	
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}


	/**
	 * @return the notifier
	 */
	
	public Notifier getNotifier() {
		return notifier;
	}

	/**
	 * altera o notifier
	 * 
	 * @param notifier
	 */
	
	public void setNotifier(Notifier notifier) {
		this.notifier = notifier;
	}

	/**
	 * @return the items
	 */
	
	public Items getItems() {
		return items;
	}

	/**
	 * altera o items
	 * 
	 * @param items
	 */
	
	public void setItems(Items items) {
		this.items = items;
	}

	/**
	 * @return the trie
	 */
	
	public Trie getTrie() {
		return trie;
	}

	/**
	 * altera a trie
	 * 
	 * @param trie
	 */
	
	public void setTrie(Trie trie) {
		this.trie = trie;
	}

	/**
	 * @return the indexer
	 */
	public Indexer getIndexer() {
		return indexer;
	}

	/**
	 * altera o indexer
	 * 
	 * @param indexer
	 */
	public void setIndexer(Indexer indexer) {
		this.indexer = indexer;
	}

	/**
	 * retorna uma unica instancia da class
	 * 
	 * @return
	 * @throws Exception
	 */

	private static Manager getInstance() throws Exception {
		if(manager == null)
			manager = restore();
		return manager;
	}
	
	/**
	 * registo de um utilizador
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	
	public boolean register(String userId,String password){
		if(authenticator.register(userId, password)){
			return true;
		}
		return false;
	}
	
	/**
	 * actualizacao da passord de um utilizador
	 * 
	 * @param user
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	
	public boolean updatePassword(String user, String oldPassword, String newPassword){
		if(authenticator.updatePassword(user, oldPassword, newPassword))
			return true;
		return false;
	}
	
	/**
	 * autenticacao do utilizador
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	
	public boolean authenticate(String userId,String password){
		if(authenticator.authenticate(userId, password))
			return true;
		return false;
	}
	
	/**
	 * obtem o item correspondente ao id
	 * 
	 * @param itemId
	 * @return item
	 */
	
	public Item getItem(String itemId){
		return items.getItem(itemId);
	}
	
	/**
	 * Adiciona um item
	 * 
	 * @param item
	 * @return
	 * @throws IlikeException
	 */
	
	public boolean addItem(Item item) throws ILikeException{
		if(!items.addItem(item))
			return false;
		else{
			indexer.index(item);
			try{
				backup();
			}
			catch (IOException exception) {
				throw new ILikeException("Erro", exception);
			}
		}
		return false;
	}
	
	/**
	 * altera um item ja existente
	 * 
	 * @param item
	 * @return
	 * @throws ILikeException 
	 */
	
	public boolean changeItem(Item item) throws ILikeException{
		if(!items.changeItem(item))
			throw new ILikeException("Nao existe");
		else{			
			try{
				backup();
			}
			catch(IOException exception) {
				throw new ILikeException("Erro", exception);
			}
		}
		return true;
	}
	
	/**
	 * remove o item
	 * 
	 * @param item
	 * @return
	 */
	public boolean removeItem(Item item){
		if(items.removeItem(item))
			return true;
		return false;
		
	}
	
	/**
	 * indica qual o item que o utilizador segue
	 * 
	 * @param itemId
	 * @param observerId
	 */
	
	public void followItem(String itemId,String observerId) throws ILikeException{
				
		if((authenticator.existUser(observerId)==false) ||((User) items.getItem(observerId)) == null)
			throw new ILikeException("Utilizador nao esta resgistado");
		else
			notifier.followTag(itemId, (User) items.getItem(observerId));
	}
	
	/**
	 * indica qual a tag que o utilizador segue
	 * 
	 * @param tag
	 * @param observerId
	 */
	
	public void followTag(String tag,String observerId) throws ILikeException{
		
		if(!authenticator.existUser(observerId))
			throw new ILikeException("Utilizador nao esta resgistado");
		else
			notifier.followTag(tag, (User) items.getItem(observerId));
	}
	
	/**
	 * lista o feed do utilizador
	 * 
	 * @param userId
	 * @return list
	 */
	
	public List<Item> getFeed(String userId) throws ILikeException{
		
		if(!authenticator.existUser(userId))
			throw new ILikeException("Utilizador nao esta resgistado");
		else{
			User user = (User) items.getItem(userId);
			return items.getItems(user.getFeed());
		}
	}
	
	/**
	 * lista os item com as tags indicadas
	 * 
	 * @param tags
	 * @return list
	 */
	
	public List<String> searchItems(Set<String> tags){
		return indexer.search(tags);	
	}
	
	/**
	 * lista das tags com o prefixo 
	 * 
	 * @param prefix
	 * @return list
	 */
	
	public List<String> getTags(String prefix){
		return trie.getWordsStartingWith(prefix);	
	}
	
	/**
	 * reverte o manager ao estado inicial
	 * 
	 */
	
	public void reset(){
		if(manager!=null){
			this.authenticator = new Authenticator();
			this.notifier = new Notifier();
			this.items = new Items();
			this.trie = new Trie();
			this.indexer  = new Indexer();	
		}
		
	}
	
	/**
	 * restauro do manager
	 * metodo auxliar criado para implementacao do padrao singleton
	 * 
	 * @return
	 * @throws Exception
	 */
	
	private static Manager restore() throws Exception{
		Manager manager = null;
		
		//se conseguir ler
		if (file.canRead()) {
    	  
			try{
    		   FileInputStream fileStream = new FileInputStream(file);
    		   ObjectInputStream objectStream = new ObjectInputStream(fileStream);
    		   manager = (Manager) objectStream.readObject();
    		   objectStream.close();
    	   } 
		   catch(Exception exception) {
              exception.printStackTrace();
           }
       } 
       else 
    	   manager = new Manager();
	   return manager;
	}

	/**
	 * backup do manager
	 * metodo auxliar criado para implementacao do padrao singleton
	 * 
	 * @throws IOException
	 */
	
	private static void backup() throws IOException{
		try{
			FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(manager);
            objectStream.close();
            
        } 
		catch(IOException exception){
        }
	}
}