package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.dto.CategoriaTotalDTO;
import modelo.dto.CuentaTotalDTO;

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
		default:
			break;
		}
	}

	private void iniciar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LocalDate fecha = LocalDate.now();
        int mesActual = fecha.getMonthValue();
        int mes = (request.getParameter("mes") == null) ? mesActual : Integer.parseInt(request.getParameter("mes"));
       
        
		List<CategoriaTotalDTO> categoriasTotalDTO = DAOFactory.getFactory().getMovimientoDAO().getTotalPorCategorias(mes);
		List<CuentaTotalDTO> cuentasTotalDTO = DAOFactory.getFactory().getMovimientoDAO().getTotalPorCuentas();

		request.setAttribute("categoriasTotalDTO", categoriasTotalDTO);
		request.setAttribute("cuentasTotalDTO", cuentasTotalDTO);
		request.getRequestDispatcher("jsp/dashboard/dashboard.jsp").forward(request, response);
	}

}
