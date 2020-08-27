package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Pedido;

public class PedidoDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private Pedido p;
	
	public int cadastraPedido(Pedido p) throws SQLException {
		String sql = "insert into pedidos values(default, ?, ?, curdate());";
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, p.getComanda());
		ps.setString(2, "A PAGAR");
		int nPedido;
		if(ps.executeUpdate()>0) {
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
					nPedido = rs.getInt(1);
			}else{
				nPedido = 0;
			}
			
		}else {
			nPedido = 0;
		}
		
		return nPedido;
		
	}

}
