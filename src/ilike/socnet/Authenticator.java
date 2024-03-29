package ilike.socnet;

import java.util.HashMap;

import ilike.shared.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */

public class Authenticator {

	private HashMap<String, String> users; 
	
	public Authenticator() {
		this.users = new HashMap<String, String>();
	}

	/**
	 * retorna a hashmap dos utilizadores
	 * 
	 * @return
	 */
	public HashMap<String, String> getUsers() {
		return users;
	}
	
	/**
	 * Altera a hashmap dos utilizadores
	 * @param users
	 */

	public void setUsers(HashMap<String, String> users) {
		this.users = users;
	}


	/**
	 * regista um utilizador
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	
	public boolean register(String userId,String password){
		
		if(users.containsKey(userId))
			return false;
		else 
			users.put(userId, password);
		return true;
	}
	
	/**
	 * actualizacao da password dos utilizadores
	 * 
	 * @param user
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */

	public boolean updatePassword(String user, String oldPassword, String newPassword){
		 if(users.containsKey(user)){
			 String pass = users.get(user);
			 if(pass.equals(oldPassword)){
				 //actualiza a passord
				 users.put(user, newPassword);
				 return true;
			 }
		 }
		return false;
	}
	
	/**
	 * Autenticacao do utilizador
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	
	public boolean authenticate(String userId,String password){
		if(users.containsKey(userId)){
			String pass = users.get(userId);
			if(pass.equals(password)) 
				return true;
		}
		return false;
	}
	
	/**
	 * metodo auxiliar para verificar se o utilizador existe
	 * 
	 * @param userId
	 * @return
	 */
	public boolean existUser(String userId){
		if(users.containsKey(userId))
			return true;
		return false;
	}
}