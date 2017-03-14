package ilike.shared;
import java.util.Observer; 

public class User {
	static int feedSize; //Número de elementos do feed
	
	List<String> getFeed(){
		//atualizações destinadas ao utilizador, que excedem feedSize
	}
	
	void update(Observervable, Object){
		//método de Observer pelo qual são recebidas as notificações
	}
}
