package br.ucsal.geu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.geu.model.Bloco;
import br.ucsal.geu.model.Espaco;
import br.ucsal.util.Conexao;
import br.ucsal.geu.model.Tipo;

public class EspacoDAO {

	private Conexao conexao;

	public EspacoDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Espaco> listarLazy() {
		Statement stmt;
		List<Espaco> espacos = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select id,identificacao,andar,funcao,bloco_id, tipo_id from espacos");
			while (rs.next()) {
				Espaco e = new Espaco();
				e.setId(rs.getInt("id"));
				e.setIdentificacao(rs.getString("identificacao"));
				e.setAndar(rs.getString("andar"));
				
				Tipo tipo = new Tipo();
				tipo.setId(rs.getInt("tipo_id"));
				e.setTipo(tipo);
				
				Bloco bloco = new Bloco();
				bloco.setId(rs.getInt("bloco_id"));
				e.setBloco(bloco);
				
				espacos.add(e);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return espacos;
	}

	public List<Espaco> listar() {
		Statement stmt;
		List<Espaco> espacos = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"select espacos.id,identificacao,andar,funcao,bloco_id,nome,letra,latitude,longitude from espacos,blocos where espacos.bloco_id = blocos.id and espacos.tipo_id = tipo.id;");
			while (rs.next()) {
				Espaco e = new Espaco();
				e.setId(rs.getInt("id"));
				e.setIdentificacao(rs.getString("identificacao"));
				e.setAndar(rs.getString("andar"));
				
				Tipo tipo = new Tipo();
				tipo.setId(rs.getInt("id"));
				tipo.setNome(rs.getString("nome"));
				tipo.setDescricao(rs.getString("descricao"));
				
				Bloco bloco = new Bloco();
				bloco.setId(rs.getInt("bloco_id"));
				bloco.setNome(rs.getString("nome"));
				bloco.setLetra(rs.getString("letra"));
				bloco.setLatitude(rs.getString("latitude"));
				bloco.setLongitude(rs.getString("longitude"));

				e.setBloco(bloco);
				espacos.add(e);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return espacos;
	}

	public void inserir(Espaco espaco) {
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("insert into espacos (identificacao,andar,funcao,bloco_id, tipo_id) values (?,?,?,?,?);");
			ps.setString(1, espaco.getIdentificacao());
			ps.setString(2, espaco.getAndar());
			ps.setInt(4, espaco.getBloco().getId());
			ps.setInt(3, espaco.getTipo().getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
