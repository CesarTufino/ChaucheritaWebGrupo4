package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Cuenta;
import modelo.entidades.Categoria;
import modelo.entidades.Movimiento;

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
		case "vizualizarPorMes":
			this.vizualizarPorMes(request, response);
			break;
		case "iniciarIngreso":
			this.iniciarIngreso(request, response);
			break;
		case "registrarIngreso":
			this.registrarIngreso(request, response);
			break;
		case "iniciarEgreso":
			this.iniciarEgreso(request, response);
			break;
		case "registrarEgreso":
			this.registrarEgreso(request, response);
			break;
		case "iniciarTransferencia":
			this.iniciarTransferencia(request, response);
			break;
		case "registrarTransferencia":
			this.registarTransferencia(request, response);
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

	private void vizualizarPorMes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int mes = Integer.parseInt(request.getParameter("mes"));

		List<Movimiento> movimientos = DAOFactory.getFactory().getMovimientoDAO().getAllByMes(mes);
		request.setAttribute("movimientos", movimientos);

		request.getRequestDispatcher("jsp/dashboard/movimientos.jsp").forward(request, response);
	}

	private void iniciarIngreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAll();

		List<Categoria> categoriasIngreso = DAOFactory.getFactory().getCategoriaDAO().getAllTipoIngreso();

		request.setAttribute("cuentas", cuentas);
		request.setAttribute("categoriasIngreso", categoriasIngreso);

		request.getRequestDispatcher("jsp/dashboard/ingreso.jsp").forward(request, response);
	}

	private void registrarIngreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCuenta = Integer.parseInt(request.getParameter("cuenta"));
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));
		String concepto = request.getParameter("concepto");
		String strFecha = request.getParameter("fecha");
		double valor = Double.parseDouble(request.getParameter("valor"));

		Cuenta cuenta = DAOFactory.getFactory().getCuentaDAO().getById(idCuenta);
		Categoria categoria = DAOFactory.getFactory().getCategoriaDAO().getById(idCategoria);

		//Poner dinero a la cuenta
		cuenta.setTotal(cuenta.getTotal()+valor);
		
		// Update a la cuenta
		DAOFactory.getFactory().getCuentaDAO().update(cuenta);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		try {
			fecha = dateFormat.parse(strFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Movimiento movimiento = new Movimiento(concepto, valor, fecha, categoria, cuenta);

		DAOFactory.getFactory().getMovimientoDAO().create(movimiento);

		response.sendRedirect("MovimientoController?ruta=iniciarIngreso");
	}

	private void iniciarEgreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAll();

		List<Categoria> categoriasEgreso = DAOFactory.getFactory().getCategoriaDAO().getAllTipoEgreso();

		request.setAttribute("cuentas", cuentas);
		request.setAttribute("categoriasEgreso", categoriasEgreso);

		request.getRequestDispatcher("jsp/dashboard/egreso.jsp").forward(request, response);
	}

	private void registrarEgreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCuenta = Integer.parseInt(request.getParameter("cuenta"));
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));
		String concepto = request.getParameter("concepto");
		String strFecha = request.getParameter("fecha");
		double valor = Double.parseDouble(request.getParameter("valor"));

		Cuenta cuenta = DAOFactory.getFactory().getCuentaDAO().getById(idCuenta);
		Categoria categoria = DAOFactory.getFactory().getCategoriaDAO().getById(idCategoria);
		
		// Verificar que la cuenta tenga el total suficiente
		if (valor <= cuenta.getTotal()) {
			cuenta.setTotal(cuenta.getTotal()-valor);
		}
		
		// Update a la cuenta
		DAOFactory.getFactory().getCuentaDAO().update(cuenta);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		try {
			fecha = dateFormat.parse(strFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Movimiento movimiento = new Movimiento(concepto, -valor, fecha, categoria, cuenta);

		DAOFactory.getFactory().getMovimientoDAO().create(movimiento);
		

		response.sendRedirect("MovimientoController?ruta=iniciarEgreso");
	}

	private void iniciarTransferencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		 List<Movimiento> movimientos = DAOFactory.getFactory().getMovimientoDAO().getAll();
		 List<Cuenta> cuentasOrigen = DAOFactory.getFactory().getCuentaDAO().getAll();
		 List<Cuenta> cuentasDestino = DAOFactory.getFactory().getCuentaDAO().getAll();
		 List<Categoria> listaCategorias = DAOFactory.getFactory().getCategoriaDAO().getAll();
		// DAOFactory.getFactory().getMovimientoDAO().getAll();

		request.setAttribute("cuenta_origen", cuentasOrigen);
		request.setAttribute("cuenta_destino", cuentasDestino);
		request.setAttribute("listaCategorias", listaCategorias);
		request.getRequestDispatcher("jsp/dashboard/transferencia.jsp").forward(request, response);
	}

	private void registarTransferencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCuentaOrg = Integer.parseInt(request.getParameter("cuenta_origen"));
		//Otra cuenta
		int idCuentaDest = Integer.parseInt(request.getParameter("cuenta_destino"));
		
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));
		
		String concepto = request.getParameter("concepto");
		String strFecha = request.getParameter("fecha");
		double valor = Double.parseDouble(request.getParameter("valor"));
		
		Categoria categoria = DAOFactory.getFactory().getCategoriaDAO().getById(idCategoria);
		Cuenta cuentaOrg = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaOrg);
		Cuenta cuentaDest = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaDest);
		
		// Verificar que la cuenta origen tenga el total suficiente
		if (valor <= cuentaOrg.getTotal()) {
			cuentaOrg.setTotal(cuentaOrg.getTotal()-valor);
			cuentaDest.setTotal(cuentaDest.getTotal()+valor);
		}

		// Update a las cuentas
		DAOFactory.getFactory().getCuentaDAO().update(cuentaOrg);
		DAOFactory.getFactory().getCuentaDAO().update(cuentaDest);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		try {
			fecha = dateFormat.parse(strFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Reigstrar los dos movimientos
		
		Movimiento movimientoOrg = new Movimiento(concepto, -valor, fecha, categoria, cuentaOrg);
		Movimiento movimientoDest = new Movimiento(concepto, -valor, fecha, categoria, cuentaDest);

		DAOFactory.getFactory().getMovimientoDAO().create(movimientoOrg);
		DAOFactory.getFactory().getMovimientoDAO().create(movimientoDest);
		

		response.sendRedirect("MovimientoController?ruta=iniciarEgreso");
	}
	
}
