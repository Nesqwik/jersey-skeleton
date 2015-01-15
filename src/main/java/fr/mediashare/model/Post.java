package fr.mediashare.model;

public class Post {
	private int idPost=0;
	private String description, mail;
	
	public Post(){
		
	}
	
	public Post(String description, String mail){
		this.description=description;
		this.mail=mail;
	}
	
	public int getIdPost(){
		return this.idPost;
	}
	
	public void setIdPost(int id){
		this.idPost=id;
	}
	
	public String getDescritption(){
		return this.description;
	}
	
	public void setDescription(String desciption){
		this.description=desciption;
	}
	
	public String getMail(){
		return this.mail;
	}
	
	public void setMail(String mail){
		this.mail=mail;
	}

}
