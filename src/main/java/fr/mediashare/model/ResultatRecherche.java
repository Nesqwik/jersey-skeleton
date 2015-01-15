package fr.mediashare.model;

public class ResultatRecherche {

	private String nom;
	private String chemin;
	private String date;
	private int taille;
	private int idPost;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getRes() {
		return nom;
	}

	public void setRes(String res) {
		this.nom = res;
	}

	public ResultatRecherche(){
		
	}
}
