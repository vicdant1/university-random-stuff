package br.ufrn.imd.controle;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class TelaLoginServlet
 */
@WebServlet("/TelaLoginServlet")
public class TelaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TelaLoginServlet() {
        // TODO Auto-generated constructor stub
    }
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		
		if(usuario.equals("admin") && senha.equals("admin")) {
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", usuario);
			session.setAttribute("senha", senha);
			
			session.setMaxInactiveInterval(60);
			
			
			response.sendRedirect("telaMenu.jsp");
			
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
