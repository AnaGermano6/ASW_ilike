package ilike.SocNet;

public class Manager {
	
	static Manager getInstance(){
		return null;
		//retorna única instância desta classe
	}
	
	public boolean register(String userId,String password){
		//registo de um utilizador (apenas a autenticação)
	}
	
	public boolean updatePassword(String user, String oldPassword, String newPassword){
		//atualização da passord de um utilizador
	}
	
	public boolean authenticate(String userId,String password){
		//autenticação do utilizador
	}
	
	public Item getItem(String itemId){
		//obter um item dado um ID
	}
	
	public boolean addItem(Item item){
		//adicionar um item, indicando se este foi adicionado
	}
	
	public boolean changeItem(Item item){
		//alterar um item já existente, indicando se este foi alterado
	}
	
	public boolean removeIte (Item item){
		//remover item, indicando se este foi removido
	}
	
	public void followItem(String itemId,String observerId){
		//indica que item com id dado é seguido por utilizador
	}
	
	public void followTag(String tag,String observerId){
		//indica que tag é seguida por utilizador
	}
	
	public List<String> getFeed(String userId){
		//retorna feed sdo utilizador (com IDs dos items de interesse)
	}
	
	public List<String> searchItems(Set<String> tags){
		//lista de IDs de items com as tags indicadas
	}
	
	public List<String> getTags(String prefix){
		//lista de tags com prefixo dado
	}
	
	public void reset(){
		//reverte o manager ao estado inicial (usar nos testes unitários)
	}
}