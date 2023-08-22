package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Movimiento;
import modelo.entidades.TipoMovimiento;

@WebServlet("/MovimientoController")
public class MovimientoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MovimientoController() {
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
		case "vizualizarTodo":
			this.vizualizarTodo(request, response);
			break;
		case "iniciarIngreso":
			this.iniciarIngreso(request, response);
			break;
		case "iniciarEgreso":
			this.iniciarEgreso(request, response);
			break;
		case "iniciarTransferencia":
			this.iniciarTransferencia(request, response);
			break;
		default:
			break;
		}
	}

	private void vizualizarTodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Movimiento> movimientos = DAOFactory.getFactory().getMovimientoDAO().getAll();

		request.setAttribute("movimientos", movimientos);

		request.getRequestDispatcher("jsp/dashboard/movimientos.jsp").forward(request, response);
	}
	
	private void iniciarIngreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Movimiento> movimientos = DAOFactory.getFactory().getMovimientoDAO().getAll();

		request.setAttribute("movimientos", movimientos);

		request.getRequestDispatcher("jsp/dashboard/ingreso.jsp").forward(request, response);
	}

	
	private void iniciarEgreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Movimiento> movimientos = DAOFactory.getFactory().getMovimientoDAO().getAll();

		request.setAttribute("movimientos", movimientos);

		request.getRequestDispatcher("jsp/dashboard/egreso.jsp").forward(request, response);
	}
	
	private void iniciarTransferencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Movimiento> movimientos = DAOFactory.getFactory().getMovimientoDAO().getAll();

		request.setAttribute("movimientos", movimientos);

		request.getRequestDispatcher("jsp/dashboard/transferencia.jsp").forward(request, response);
	}
}
