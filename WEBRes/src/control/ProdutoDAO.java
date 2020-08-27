package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private Produto p;
	
	public boolean cadastraProduto(Produto p) throws SQLException {
		String sql = "insert into itens values(default, ?, ?, ?, ?);";
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		ps.setString(1, p.getTipo());
		ps.setString(2, p.getNome());
		ps.setString(3, p.getDescricao());
		ps.setDouble(4, p.getPreco());
		
		if(ps.executeUpdate()>0){
			return true;
		}else {
			return false;
		}
	}
	
	public List<Produto> listaProdutos() throws SQLException {
		List<Produto> pr;
		String sql = "select * from itens";
		con = ConnectionDB.getConnection();
		PreparedStatement prep = con.prepareStatement(sql);
		ResultSet rs = prep.executeQuery();
		pr = new ArrayList<Produto>();
		
		while(rs.next()) {
			p = new Produto();
			p.setCodigo(rs.getInt("codigoProd"));
			p.setTipo(rs.getString("tipo"));
			p.setNome(rs.getString("nome"));
			p.setDescricao(rs.getString("descricao"));
			p.setPreco(rs.getDouble("pre�o"));
			
			pr.add(p);
		}
		return pr;		
	}

	
	public Produto getProduto(int capturei) throws SQLException {
		Produto p = new Produto();
		String sql = "select * from itens where codigoProd = ?";
		con = ConnectionDB.getConnection();
		PreparedStatement prepa = con.prepareStatement(sql);
		prepa.setInt(1, capturei);
		ResultSet res = prepa.executeQuery();
		while(res.next()) {
			p.setCodigo(res.getInt("codigoProd"));
			p.setTipo(res.getString("tipo"));
			p.setNome(res.getString("nome"));
			p.setDescricao(res.getString("descricao"));
			p.setPreco(res.getDouble("pre�o"));
		}
		
		return p;
	}
	
	public boolean prodExiste(int cod) throws SQLException {
		String sql = "select * from itens where codigoProd = ?;";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, cod);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getInt(1) == cod) {
				return true;
			}
		}
		return false;
	}
	
	public boolean editar(Produto p, int cod) {
		boolean editado = false;
		
		try {
			if(prodExiste(cod)) {
				String sql = "update itens set nome = ?, descricao = ?, pre�o = ? where codigoProd = " + cod + ";";
				con = ConnectionDB.getConnection();
				PreparedStatement prs = con.prepareStatement(sql);
				
				prs.setString(1, p.getNome());
				prs.setString(2, p.getDescricao());
				prs.setDouble(3, p.getPreco());
				
				prs.execute();
				editado = true;	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("erro" + e);
			e.printStackTrace();
		}
		return editado;
	}
	
	public void excluir(int cod) {
		String sql = "delete from itens where codigoProd = ?";
		con = ConnectionDB.getConnection();
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.setInt(1, cod);
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
