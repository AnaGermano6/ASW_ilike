package ilike.SocNet;

import java.util.Observer;
import java.util.Observable;

public class Notifier {

	void followItem(String itemId,Observer observer){
		//Regista o item com dado ID como sendo de interesse para o observador (um User )
	}
	void followTag(String tag,String observerId){
		//Regista a tag dado como sendo de interesse para o observador (um User )
	}
	notifyObservers(Item item){
		//Notifica os observadores da criação ou de modificações ocorridas no item
	}
}