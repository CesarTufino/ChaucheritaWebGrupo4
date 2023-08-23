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
import modelo.dto.CuentaDTO;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;

@WebServlet("/DashboardController")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DashboardController() {
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
		case "iniciar":
			this.iniciar(request, response);
			break;
		case "ajustar":
			this.ajustar(request, response);
			break;
		default:
			break;
		}
	}

	private void iniciar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// int mes = 1;
		// List<CategoriaTotalDTO> categoriasTotalDTO =
		// DAOFactory.getFactory().getMovimientoDAO().getTotalByCategoria(mes);
		// List<Cuenta> cuentaTotalDTO =
		// DAOFactory.getFactory().getCuentaDAO().getAll();

		// request.setAttribute("movimientos", movimientos);
		request.getRequestDispatcher("jsp/dashboard/dashboard.jsp").forward(request, response);
	}

	private void ajustar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setAttribute("movimientos", movimientos);
		request.getRequestDispatcher("jsp/dashboard/ajustar-saldo.jsp").forward(request, response);
	}

}
