package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.dto.CategoriaTotalDTO;
import modelo.dto.CuentaTotalDTO;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;

@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistroController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ruta = (request.getParameter("ruta") == null) ? "inicio" : request.getParameter("ruta");
		switch (ruta) {
		case "registrar":
			this.registrar(request, response);
			break;
		default:
			break;
		}
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// int mes = 1;
		// List<CategoriaTotalDTO> categoriasTotalDTO =
		// DAOFactory.getFactory().getMovimientoDAO().getTotalByCategoria(mes);
		// List<Cuenta> cuentaTotalDTO =
		// DAOFactory.getFactory().getCuentaDAO().getAll();

		// request.setAttribute("movimientos", movimientos);
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	}


}
