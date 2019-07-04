package Gateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import BD.Conexao;

public class GatewaySolicitacaoMuseu {
	
	private Connection conexao;
	
	public GatewaySolicitacaoMuseu() {
		conexao = Conexao.getConnection();
	}
	
	public void salvarNoBancoSolicitacao(String nomeMuseu, String dataCriacao, String cidade, String estado, String nomeGestor, String cpfGestor, String senhaGestor)
	{
		String sql = "INSERT INTO Solicitacao\n" +
					 "	VALUE ('"+nomeMuseu+"','"+dataCriacao+"','"+cidade+"','"+estado+"','"+cpfGestor+"','"+nomeGestor+"','"+senhaGestor+"')";
		
		try {
			Statement s = conexao.createStatement();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
