package fr.iutinfo;

public class User {
	private String pseudo, email, mdp, mdp2;
	private int id = 0;

	public User(String pseudo, String email, String mdp, String mdp2) {
		this.setPseudo(pseudo);
		this.setEmail(email);
		this.setMdp(mdp);
	}
	
	public String getMdp2() {
		return mdp2;
	}
	
	public void setMdp2(String mdp2) {
		this.mdp2 = mdp2;
	}

	public User() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
