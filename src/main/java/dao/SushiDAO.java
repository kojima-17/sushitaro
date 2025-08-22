package dao;

import java.util.List;
import java.util.Optional;

import model.Menu;
import model.Sushi;

public class SushiDAO {
	private Menu menu;
	
	public SushiDAO(Menu menu) {
		this.menu = menu;
	}
	
	public List<Sushi> findAll() {
		return menu.getSushiList();
	}
	
	public Optional<Sushi> findByName(String name){
		List<Sushi> sushiList = findAll();
		for(Sushi sushi : sushiList) {
			if(sushi.getName().equals(name)) {
				return Optional.of(sushi);
			}
		}
		return Optional.empty();
	}
}
