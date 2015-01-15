package fr.mediashare.model;

public class Post {
	private int idPost;
	private String description, pseudo, path, type;
	
	public Post() {
		
	}
	
	public Post(String description, String pseudo, String path, String type){
		this.description = description;
		this.pseudo = pseudo;
		this.path = path;
		this.type = type;
	}
	
	public int getIdPost(){
		return this.idPost;
	}
	
	public void setIdPost(int id){
		this.idPost = id;
	}
	
	public String getDescritption(){
		return this.description;
	}
	
	public void setDescription(String desciption){
		this.description = desciption;
	}
	
	public String getPseudo() {
		return this.pseudo;
	}
	
	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
