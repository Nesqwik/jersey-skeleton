package fr.mediashare.model;

public class User {
	private String pseudo, email, mdp, mdp2;

	public User(String pseudo, String email, String mdp) {
		this.setPseudo(pseudo);
		this.setEmail(email);
		this.setMdp(mdp);
	}

	public User() {
		
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

	public String getMdp2() {
		return mdp2;
	}

	public void setMdp2(String mdp2) {
		this.mdp2 = mdp2;
	}
}
