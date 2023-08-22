package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.Usuario;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.ruteador(request, response);
	}
	
	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = (request.getParameter("ruta") == null) ? "inicio" : request.getParameter("ruta");
		switch (ruta) {
		case "iniciar":
			this.iniciar(request, response);
			break;
		case "ingresar":
			this.ingresar(request, response);
			break;
		case "salir":
			//this.salir(request, response);
			break;
		case "error":
			break;
		default:
			break;
		}
	}
	
	private void iniciar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.- Obtener datos que me envían en la solicitud

		// 2.- Llamo al Modelo para obtener datos

		// 3.- Llamo a la vista
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	}
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String clave = request.getParameter("pswd");
		
		System.out.println(username + clave);

		Usuario usuarioAtenticado = DAOFactory.getFactory().getUsuarioDAO().autorizar(username, clave);

		if (usuarioAtenticado != null) {
			// Crear la sesion
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", usuarioAtenticado);
			
			response.sendRedirect("DashboardController?ruta=iniciar");
		} else {
			String mensaje = "Ingresaste mal tu usuario y clave";
			// Enviar datos a la vista
			// request.setAttribute("mensaje", mensaje);
			// Redireccionar a la vista
			// request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
	}
	

}
