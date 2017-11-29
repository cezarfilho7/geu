package br.ucsal.geu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.geu.dao.UsuarioDAO;
import br.ucsal.geu.model.Usuario;

@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			request.getRequestDispatcher("usuarioform.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");
	Usuario usuario = new Usuario(login, senha);
	UsuarioDAO dao = new UsuarioDAO();
	dao.inserir(usuario);
	
	request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
