package br.edu.insper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private Connection connection = null;

	public DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/projeto_1", "root",
					"0t0rr1n0l4r1ng0l0g1st4"); // TROCAR
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean cadastro(String nome, String senha) throws SQLException {

		try {
			PreparedStatement stmt;
			String sql = "SELECT * FROM user WHERE nome=?";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				sql = "INSERT INTO user" + "(nome,senha) values(?,?)";

				stmt = connection.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setString(2, senha);
				stmt.execute();
				stmt.close();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void review(String id, String materia, String professor, String mensagem) throws SQLException {
		
		try {

			System.out.println("cumw");
			System.out.println(id);
			System.out.println(materia);
			System.out.println(professor);
			System.out.println(mensagem);
			
			PreparedStatement stmt;
			String sql = "INSERT INTO postagem (user_id,materia,professor,review) VALUES(?,?,?,?)";
			
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, materia);
			stmt.setString(3, professor);
			stmt.setString(4, mensagem);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public user login(String nome, String senha) throws SQLException {
		user usuario = new user();
		try {
			
			PreparedStatement stmt;
			String sql = "SELECT * FROM user WHERE nome = ? AND senha = ?";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			/* System.out.println(rs.getInt("id")); */
			
			
			if(rs.next()) {
				usuario.setId(Integer.toString(rs.getInt("id")));
				
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				
			}
			else {
				usuario = null;
			}
			rs.close();
			stmt.close();


			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
		
	}
	

public void deletar(String id) throws SQLException {
		
	try {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM postagem WHERE id=?");
		stmt.setString(1, id);
		stmt.execute();
		stmt.close();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public List<postagem> getLista() {
		List<postagem> postagens = new ArrayList<postagem>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM postagem");

			ResultSet rs;

			rs = stmt.executeQuery();

			while (rs.next()) {
			postagem post = new postagem();
			post.setId( Integer.toString(rs.getInt("id")));
			post.setUser_id(Integer.toString(rs.getInt("user_id")));
			post.setMateria(rs.getString("materia"));
			post.setProfessor(rs.getString("professor"));
			post.setReview(rs.getString("review"));
			postagens.add(post);
			
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return postagens;
	}
	

		

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
