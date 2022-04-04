package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tecnosul.model.Cliente;

@WebServlet(urlPatterns = { "/cliente", "/clienteServlet", "/clienteController" })
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Cliente> lista = new ArrayList<>();

	public ClienteServlet() {
		System.out.println("Construindo Servlet...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Inicializando Servlet");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando Service...");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", lista);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Recebendo o e-mail
		String email = req.getParameter("email");
		
		//Colocando e-mail em um objeto cliente
		Cliente cli = new Cliente();
		cli.setEmail(email);
				
		//adicionando o objeto cliente na Lista de cliente		
		lista.add(cli);
		
		/* System.out.println("Chamou pelo m�todo POST");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo m�todo POST enviando e-mail:" + "!");*/
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// System.out.println("Chamou pelo m�todo DELETE");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo m�todo DELETE");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// System.out.println("Chamou pelo m�todo PUT");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo m�todo PUT");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet ser� destruido");		
		super.destroy();
	}
}
