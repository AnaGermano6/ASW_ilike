package ilike.SocNet;

import java.util.LinkedList;
import java.util.Set;

import ilike.shared.*;

/**
 * 
 * @author Ana Germano up201105083
 *
 */ 

public class Manager {
	
	public static Manager getInstance(){
		return null;
		//retorna única instância desta classe
	}
	
	public boolean register(String userId,String password){
		return false;
		//registo de um utilizador (apenas a autenticação)
	}
	
	public boolean updatePassword(String user, String oldPassword, String newPassword){
		return false;
		//atualização da passord de um utilizador
	}
	
	public boolean authenticate(String userId,String password){
		return false;
		//autenticação do utilizador
	}
	
	public Item getItem(String itemId){
		return null;
		//obter um item dado um ID
	}
	
	public boolean addItem(Item item){
		return false;
		//adicionar um item, indicando se este foi adicionado
	}
	
	public boolean changeItem(Item item){
		return false;
		//alterar um item já existente, indicando se este foi alterado
	}
	
	public boolean removeIte (Item item){
		return false;
		//remover item, indicando se este foi removido
	}
	
	public void followItem(String itemId,String observerId){
		//indica que item com id dado é seguido por utilizador
	}
	
	public void followTag(String tag,String observerId){
		//indica que tag é seguida por utilizador
	}
	
	public LinkedList<String> getFeed(String userId){
		return null;
		//retorna feed sdo utilizador (com IDs dos items de interesse)
	}
	
	public LinkedList<String> searchItems(Set<String> tags){
		return null;
		//lista de IDs de items com as tags indicadas
	}
	
	public LinkedList<String> getTags(String prefix){
		return null;
		//lista de tags com prefixo dado
	}
	
	public void reset(){
		//reverte o manager ao estado inicial (usar nos testes unitários)
	}
}