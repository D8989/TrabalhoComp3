package SERVLET;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SolicitacaoMuseuServlet
 */
@WebServlet("/SolicitacaoMuseuServlet")
public class SolicitacaoMuseuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SolicitacaoMDS solicitacao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitacaoMuseuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getRequestDispatcher("WebContent/CriarSolicitacaoMuseu.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		solicitacao = new SolicitacaoMDS(request.getParameter("nomeMuseu"),request.getParameter("dataCriacao"),request.getParameter("cidade"),
				request.getParameter("estado"),request.getParameter("nomeGestor"),request.getParameter("cpfGestor"),request.getParameter("senhaGestor"));
		try{
			solicitacao.salvarInformacoes();
		}
		catch(Exception e){
			throw new ServletException(e);
		}
	}

}
