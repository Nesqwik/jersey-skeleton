package fr.mediashare.model;

import fr.mediashare.utils.UniqueIdGenerator;

public class Cookie {
	private int id;

	public Cookie() {
		id = -1;
	}
	
	public Cookie(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
