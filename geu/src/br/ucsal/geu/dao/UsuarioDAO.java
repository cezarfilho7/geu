package br.ucsal.geu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.ucsal.geu.model.Usuario;
import br.ucsal.util.Conexao;

public class UsuarioDAO {
	
	public Conexao conexao;

	public UsuarioDAO() {
		this.conexao = Conexao.getConexao();
	}
	
	public void inserir(Usuario usuario) {
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("insert into usuarios(login, senha) values(?,?)");
			ps.setString(1,  usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.execute();
			ps.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Usuario getByID(int id) {
		Usuario u = null;
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("select id, login, senha from usuarios where id=?");
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	public void close() {
		conexao.closeConnection();
	}

}
