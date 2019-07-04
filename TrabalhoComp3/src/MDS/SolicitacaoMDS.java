package MDS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Gateway.GatewaySolicitacaoMuseu;
/**
 * Servlet implementation class SolicitacaoMDS
 */
@WebServlet("/SolicitacaoMDS")
public class SolicitacaoMDS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GatewaySolicitacaoMuseu gatewayConexao;
    
	private String nomeMuseu;
	private String dataCriacao;
	private String cidade;
	private String estado;
	private String nomeGestor;
	private String cpfGestor;
	private String senhaGestor;
	/**
     * Default constructor. 
     */
	public SolicitacaoMDS(){
		super();
	}
	
    public SolicitacaoMDS(String nomeMuseu, String dataCriacao, String cidade, String estado, String nomeGestor, String cpfGestor, String senhaGestor) {
    	this.nomeMuseu = nomeMuseu;
    	this.dataCriacao = dataCriacao;
    	this.cidade = cidade;
    	this.estado = estado;
    	this.nomeGestor = nomeGestor;
    	this.cpfGestor = cpfGestor;
    	this.senhaGestor = senhaGestor;
    	this.gatewayConexao = new GatewaySolicitacaoMuseu();
    }
    
    public void salvarInformacoes(){
    	gatewayConexao.salvarNoBancoSolicitacao(String nomeMuseu, String dataCriacao, String cidade, String estado, String nomeGestor, String cpfGestor, String senhaGestor);
    }

}
