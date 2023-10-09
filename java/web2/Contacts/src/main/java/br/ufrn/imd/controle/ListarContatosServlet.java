package br.ufrn.imd.controle;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.imd.dados.BancoContatos;
import br.ufrn.imd.modelo.Contato;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class ListarContatosServlet
 */
@WebServlet("/ListarContatosServlet")
public class ListarContatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BancoContatos _contatosRepository;
    
    public ListarContatosServlet() {
    	_contatosRepository = BancoContatos.getInstance();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("usuario") == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		ArrayList<Contato> contatos = _contatosRepository.getContatos();
		
		if(contatos.size() > 0) {
			response.getWriter().append("<h1>Lista de Contatos</h1>");
			
			for(Contato contato : contatos) {			
				response.getWriter().append("<p>" + contato.getNome() + " - (" + contato.getEmail() + ")" + "</p>");
			}
		} else {
			response.getWriter().append("<p>Sem contatos cadastrados</p>");
		}
	}
}
