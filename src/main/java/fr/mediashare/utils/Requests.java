package fr.mediashare.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.mediashare.model.Post;
import fr.mediashare.model.ResultatRecherche;
import fr.mediashare.model.User;

public class Requests {
	private Connection c;

	public Requests(Connection c) {
		this.c = SQLiteConnection.getConnection();
	}
	
	public Requests() {
		this.c = SQLiteConnection.getConnection();
	}

	public void insertUser(User u) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO utilisateur(pseudo, mail, mdp, admin) VALUES(?, ?, ?, ?)";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, u.getPseudo());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getMdp());
			stmt.setInt(4, u.getUserType());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> select(String table) {
		List<String> tmp = new LinkedList<String>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + table);
			while (rs.next()){
				if(table.equals("post"))
					tmp.add(rs.getString("idPost")+", " + rs.getString("description") + ", " + rs.getString("mail"));
				else if(table.equals("utilisateur"))
					tmp.add(rs.getString("pseudo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tmp;
	}
	
	
	
	public List<Post> selectAllPosts() {
		List<Post> posts = new ArrayList<Post>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM post;");
			while (rs.next()){
				Post p = new Post(rs.getString("description"), 
									rs.getString("pseudo"), 
									rs.getString("path"), 
									FileFormatUtils.getFormatOf(rs.getString("path")));
				posts.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return posts;
	}

	public boolean emailExist(String email) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = c.prepareStatement("SELECT mail from utilisateur where mail = ?");
			stmt.setString(1, email);

			rs = stmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean idExist(User user) {
		PreparedStatement stmt = null;
		try {
			stmt = c.prepareStatement("select * from utilisateur where pseudo = ? and mdp = ?");
			stmt.setString(1, user.getPseudo());
			stmt.setString(2, user.getMdp());
			return stmt.executeQuery().next();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<ResultatRecherche> search(String table, String champ, String recherche) {
		List<ResultatRecherche> list = new ArrayList<ResultatRecherche>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE " + champ + " LIKE '%"+recherche+"%'");
			while(rs.next()){
				ResultatRecherche res = new ResultatRecherche();
				res.setNom(rs.getString("nom"));
				res.setChemin(rs.getString("chemin"));
				res.setDate(rs.getString("date"));
				res.setTaille(rs.getInt("taille"));
				res.setIdPost(rs.getInt("idPost"));
				list.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean supprimerCompte(User user) {
		Statement stmt = null;
		ResultSet rs = null;
		boolean tmp = false;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM utilisateur WHERE pseudo='"+user.getPseudo()+"'");
			if(rs.next()) {
				tmp = true;
				stmt.executeUpdate("DELETE FROM utilisateur WHERE pseudo='" + user.getPseudo()+"'");
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tmp;
	}
	
	public void modifierEmail(User user) {
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			stmt.executeUpdate("UPDATE utilisateur SET email='"+user.getEmail()+"' WHERE pseudo='toto'"/*+user.getPseudo()+"*/);
		} catch(Exception e) {
		e.printStackTrace();
		System.exit(0);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void modifierMdp(User user) {
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			stmt.executeUpdate("UPDATE utilisateur SET mdp='"+user.getMdp()+"' WHERE pseudo='toto'"/*+user.getPseudo()+"*/);
		} catch(Exception e) {
		e.printStackTrace();
		System.exit(0);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertPost(String description, String path, String pseudo) {
		PreparedStatement stmt = null;
		try {
			stmt = c.prepareStatement("INSERT INTO post(description, path, pseudo) VALUES(?, ?, ?)");
			stmt.setString(1, description);
			stmt.setString(2, path);
			stmt.setString(3, pseudo);
			
			stmt.executeUpdate();
		} catch(Exception e) {
		e.printStackTrace();
		System.exit(0);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkSuppression(User user, Post post) {
		Statement stmt = null;
		ResultSet rs = null;
		boolean tmp = false;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT p.pseudo, u.pseudo FROM utilisateur AS u, post AS p WHERE u.pseudo='"+user.getPseudo()+"' AND p.pseudo='"+post.getPseudo()+"'");
			if(rs.next())
				tmp = true;
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tmp;
	}
	
	public void supprimerPost(Post post) {
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			stmt.executeUpdate("DELETE FROM post WHERE idPost='"+post.getIdPost()+"'");
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public User getUser(String pseudo) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = c.prepareStatement("select * from utilisateur where pseudo = ?;");
			stmt.setString(1, pseudo);
			rs = stmt.executeQuery();
			if(rs.next())
				return new User(rs.getString("pseudo"), rs.getString("mail"), rs.getString("mdp"), 0);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}