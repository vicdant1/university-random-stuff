package br.ufrn.imd.controle;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import br.ufrn.imd.dados.BancoContatos;
import br.ufrn.imd.modelo.Contato;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class VerDetalhesServlet
 */
@WebServlet("/VerDetalhesServlet")
public class VerDetalhesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BancoContatos _contatosRepository;
    public VerDetalhesServlet() {
    	_contatosRepository = BancoContatos.getInstance();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("usuario") == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		String nome = request.getParameter("nome");
		
		Contato contatoPesquisado = _contatosRepository.getContatoByNome(nome);
		
		if(contatoPesquisado == null) {
			response.getWriter().append("<p>Contato nao localizado</p>");
		} else {
			response.getWriter().append("<p> Nome: " + contatoPesquisado.getNome() + "</p>")
								.append("<p> Celular: " + contatoPesquisado.getTelefoneCelular() + "</p>")
								.append("<p> Telefone: " + contatoPesquisado.getTelefoneResidencial() + "</p>")
								.append("<p> Email: " + contatoPesquisado.getEmail() + "</p>")
								.append("<p> Data de Nascimento: " + contatoPesquisado.getDataNascimento() + "</p>");								
		}
		
	}

}
