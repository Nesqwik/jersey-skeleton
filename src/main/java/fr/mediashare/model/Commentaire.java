package fr.mediashare.model;

public class Commentaire {
	
	private int idCom=0;
	private int idPost;
	private String commentaire, mail;
	
	public Commentaire(){
		
	}
	
	public Commentaire(String commentaire, String mail, int idPost){
		this.commentaire=commentaire;
		this.mail=mail;
		this.idPost=idPost;
	}
	
	public int getIdCom(){
		return this.idCom;
	}
	
	public void setIdCom(int id){
		this.idCom=id;
	}
	
	public int getIdPost(){
		return this.idPost;
	}
	
	public void setIdPost(int id){
		this.idPost=id;
	}
	
	public String getCommentaire(){
		return this.commentaire;
	}
	
	public void setCommentaire(String com){
		this.commentaire=com;
	}
	
	public String getMail(){
		return this.mail;
	}
	
	public void setMail(String mail){
		this.mail=mail;
	}

}
