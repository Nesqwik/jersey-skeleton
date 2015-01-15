package fr.mediashare.model;

public class Fichier {
	
	private int taille, idPost;
	private String nom, chemin, date;
	
	public Fichier(){
		
	}
	
	public Fichier(String chemin, String date, int taille, int idPost){
		this.chemin=chemin;
		this.date=date;
		this.idPost=idPost;
	}
	
	public int getTaille(){
		return this.taille;
	}
	public void setTaille(int taille){
		this.taille=taille;
	}
	
	public int getIdPost(){
		return idPost;
	}
	public void setIdPost(int id){
		this.idPost=id;
	}
	public String getChemin(){
		return this.chemin;
	}
	public void setChemin(String chemin){
		this.chemin=chemin;
	}
	public String getDate(){
		return this.date;
	}
	public void setDate(String date){
		this.date=date;
	}

}
