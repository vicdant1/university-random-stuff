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
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BancoContatos _contatosRepository;
	
    public CadastroServlet() {
    	_contatosRepository = BancoContatos.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("usuario") == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		String nome = request.getParameter("nome");
		String telefoneCelular = request.getParameter("telefoneCelular");
		String telefoneResidencial = request.getParameter("telefoneResidencial");
		String email = request.getParameter("email");
		String dataNascimento = request.getParameter("dataNascimento");
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setTelefoneCelular(telefoneCelular);
		contato.setTelefoneResidencial(telefoneResidencial);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		_contatosRepository.addContato(contato);
		
		
		response.sendRedirect("telaMenu.jsp");
		
		
	}

}
