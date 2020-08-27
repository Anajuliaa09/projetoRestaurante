package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemPedido;
public class ItemPedidoDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ItemPedido ip;
	
	public boolean cadastraItemPedido(ItemPedido ip) throws SQLException {
		String sql = "insert into itemPedido values(default,?, ?, ?);";
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, ip.getPedido());
		ps.setInt(2, ip.getCodProd());
		ps.setInt(3, ip.getQuantidade());
		
		if(ps.executeUpdate()>0) {
			//updatePreco();
			return true;	
		}else {
			return false;
		}
	}
	
	/*public void updatePreco() throws SQLException {
		String sql = "call pr_atualiza();";
		con = ConnectionDB.getConnection();
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}*/
	
	
	public String nomeProd(int cod) throws SQLException{
		String recebeRS = null;
		
			String sql = "select * from itens WHERE codigoProd = " + cod + ";";
			con = ConnectionDB.getConnection();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				recebeRS = rs.getString("nome");
				return recebeRS;
			}	
		return recebeRS;
	}
	
	public double precoProd(int cod) throws SQLException {
		double recebeP = 0;
		String sql = "select * from itens where codigoProd = " + cod +";";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			recebeP = rs.getDouble("pre�o");
			return recebeP;
		}
		return recebeP; 
	}
	
	public List<ItemPedido> listaPedidos(int pedido) throws SQLException {
		List<ItemPedido> ipList;
		String sql = "select * from itemPedido where pedido =  " + pedido + ";";
		con = ConnectionDB.getConnection();
		PreparedStatement prep = con.prepareStatement(sql);
		ResultSet rs = prep.executeQuery();
		ipList = new ArrayList<ItemPedido>();
		
		while(rs.next()) {
			ip = new ItemPedido();
			ip.setId_iPedido(rs.getInt("id_iPedido"));
			ip.setPedido(rs.getInt("pedido"));
			ip.setCodProd(rs.getInt("codigoProd"));
			ip.setQuantidade(rs.getInt("quantidade"));
			//ip.setTotal(rs.getDouble("total"));
			ipList.add(ip);
		}
		return ipList;		
	}
	
	public void excluir(int cod) {
		String sql = "delete from itemPedido where id_iPedido = ?";
		con = ConnectionDB.getConnection();
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.setInt(1, cod);
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
