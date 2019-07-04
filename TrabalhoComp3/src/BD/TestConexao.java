package BD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestConexao {
	
	
	public static void main(String []args) {
		Connection criaConexao = new Conexao().getConnection();
		
		String sql = "CREATE TABLE Usuario(\n" + 
				"    id INTEGER PRIMARY KEY\n" + 
				"    GENERATED ALWAYS AS IDENTITY\n" + 
				"    (START with 1, INCREMENT BY 1),\n" + 
				"\n" + 
				"    cpf VARCHAR(255) NOT NULL,\n" + 
				"    nome VARCHAR(255) NOT NULL,\n" + 
				"    senha VARCHAR(255) NOT NULL\n" + 
				")\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Visitante(\n" + 
				"    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Usuario(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Administrador(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Usuario(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Funcionario(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Usuario(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Gestor(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Funcionario(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Curador(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Funcionario(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Expositor(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Funcionario(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Obra(\n" + 
				"    id INTEGER PRIMARY KEY\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Objeto(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Obra(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Musica(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Obra(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Estatua(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Obra(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Quadro(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Obra(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Pintura(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"\n" + 
				"    FOREIGN KEY (id)\n" + 
				"    REFERENCES Obra(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Avaliacao(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"    usuarioId INTEGER NOT NULL,\n" + 
				"\n" + 
				"    FOREIGN KEY (usuarioId)\n" + 
				"    REFERENCES Usuario(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Museu(\n" + 
				"    id INTEGER PRIMARY KEY\n" + 
				"    GENERATED ALWAYS AS IDENTITY\n" + 
				"    (START with 1, INCREMENT BY 1),\n" + 
				"\n" + 
				"    nome VARCHAR(255) NOT NULL,\n" + 
				"    cidade VARCHAR(255) NOT NULL,\n" + 
				"    estado VARCHAR(255) NOT NULL,\n" + 
				"    dataCriacao DATE NOT NULL,\n" + 
				"    idGestor INTEGER NOT NULL,\n" + 
				"\n" + 
				"    FOREIGN KEY (idGestor)\n" + 
				"    REFERENCES Gestor(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE AvaliacaoMuseu(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"    avaliacaoId INTEGER NOT NULL,\n" + 
				"    museuId INTEGER NOT NULL,\n" + 
				"\n" + 
				"    FOREIGN KEY (avaliacaoId)\n" + 
				"    REFERENCES Avaliacao(id),\n" + 
				"\n" + 
				"    FOREIGN KEY (museuId)\n" + 
				"    REFERENCES Museu(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Solicitacao(\n" + 
				"    id INTEGER PRIMARY KEY\n" + 
				"    GENERATED ALWAYS AS IDENTITY\n" + 
				"    (START with 1, INCREMENT BY 1),\n" + 
				"\n" + 
				"    nome VARCHAR(255) NOT NULL,\n" + 
				"    dataCriacao VARCHAR(255) NOT NULL,\n" + 
				"    cidade VARCHAR(255) NOT NULL,\n" + 
				"    estado VARCHAR(255) NOT NULL,\n" + 
				"    cpfGestor VARCHAR(255) NOT NULL,\n" + 
				"    nomeGestor VARCHAR(255) NOT NULL,\n" + 
				"    senhaGestor VARCHAR(255) NOT NULL\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Acervo(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"    idCurador INTEGER NOT NULL,\n" + 
				"    idMuseu INTEGER,\n" + 
				"\n" + 
				"    FOREIGN KEY (idCurador)\n" + 
				"    REFERENCES Curador(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE AvaliacaoAcervo(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"    avaliacaoId INTEGER NOT NULL,\n" + 
				"    acervoId INTEGER NOT NULL,\n" + 
				"\n" + 
				"    FOREIGN KEY (avaliacaoId)\n" + 
				"    REFERENCES Avaliacao(id),\n" + 
				"\n" + 
				"    FOREIGN KEY (acervoId)\n" + 
				"    REFERENCES Acervo(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE Exposicao(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"    idExpositor INTEGER NOT NULL,\n" + 
				"\n" + 
				"    FOREIGN KEY (idExpositor)\n" + 
				"    REFERENCES Expositor(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE AlocacaoExposicao(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"    idAcervo INTEGER NOT NULL,\n" + 
				"    idExposicao INTEGER,\n" + 
				"\n" + 
				"    FOREIGN KEY (idAcervo)\n" + 
				"    REFERENCES Acervo(id),\n" + 
				"\n" + 
				"    FOREIGN KEY (idExposicao)\n" + 
				"    REFERENCES Exposicao(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE AlocacaoAcervo(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"    idAcervo INTEGER NOT NULL,\n" + 
				"    idObra INTEGER,\n" + 
				"\n" + 
				"    FOREIGN KEY (idAcervo)\n" + 
				"    REFERENCES Acervo(id),\n" + 
				"\n" + 
				"    FOREIGN KEY (idObra)\n" + 
				"    REFERENCES Obra(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE AvaliacaoExposicao(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"    avaliacaoId INTEGER NOT NULL,\n" + 
				"    exposicaoId INTEGER NOT NULL,\n" + 
				"\n" + 
				"    FOREIGN KEY (avaliacaoId)\n" + 
				"    REFERENCES Avaliacao(id),\n" + 
				"\n" + 
				"    FOREIGN KEY (exposicaoId)\n" + 
				"    REFERENCES Exposicao(id)\n" + 
				")\n" + 
				"\n" + 
				"\n" +
				";" +
				"\n" + 
				"CREATE TABLE AvaliacaoObra(\n" + 
				"    id INTEGER PRIMARY KEY,\n" + 
				"    avaliacaoId INTEGER NOT NULL,\n" + 
				"    obraId INTEGER NOT NULL,\n" + 
				"\n" + 
				"    FOREIGN KEY (avaliacaoId)\n" + 
				"    REFERENCES Avaliacao(id),\n" + 
				"\n" + 
				"    FOREIGN KEY (obraId)\n" + 
				"    REFERENCES Obra(id)\n" + 
				")";
		
		String[] tabelasSql = sql.split(";");
				
		try(Statement s = criaConexao.createStatement()) {
			int r = 0;
			for (int i = 0; i < tabelasSql.length; i++) {
				String sqlTemp = tabelasSql[i];
				r = s.executeUpdate(sqlTemp);
			}
			
			if(r == 1) {
				System.out.println("CRIADO MUDO");
			}
			
		}
		catch(SQLException s) {
			System.out.println("VAI DAR NÃO...");
			System.out.println(s.getErrorCode());
			System.out.println(s.getSQLState());
			System.out.println(s.getMessage());
		}
	}
}
