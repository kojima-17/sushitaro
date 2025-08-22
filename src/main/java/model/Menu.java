package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Sushi> sushiList;
	
	public Menu() {
		sushiList = new ArrayList<Sushi>();
		createSushiList();
	}
	
	private void createSushiList() {
		sushiList.add(new Sushi("salmon", "salmon.png", 250));
		sushiList.add(new Sushi("maguro", "maguro.png", 200));
		sushiList.add(new Sushi("ika", "ika.png", 150));
		sushiList.add(new Sushi("ebi", "ebi.png", 180));
		sushiList.add(new Sushi("tako", "tako.png", 200));
		sushiList.add(new Sushi("ikura", "ikura.png", 280));
		sushiList.add(new Sushi("salmon-set", "salmon-set.png", 1200));
	}

	public List<Sushi> getSushiList() {
		return sushiList;
	}

	public void setSushiList(List<Sushi> sushiList) {
		this.sushiList = sushiList;
	}	
}
