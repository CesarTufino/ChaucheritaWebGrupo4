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
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.dto.MovimientoDTO;
import modelo.entidades.Cuenta;
import modelo.entidades.Categoria;
import modelo.entidades.Movimiento;
import modelo.entidades.Persona;

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

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		if (persona == null) {
			response.sendRedirect("LoginController?ruta=iniciar");
			return;
		}

		String ruta = (request.getParameter("ruta") == null) ? "vizualizarTodo" : request.getParameter("ruta");
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
		case "eliminarMovimiento":
			this.eliminarMovimiento(request, response);
			break;
		default:
			break;
		}
	}

	private void vizualizarTodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		List<MovimientoDTO> movimientos = DAOFactory.getFactory().getMovimientoDAO().getAllByPersona(persona.getId());

		request.setAttribute("movimientos", movimientos);

		request.getRequestDispatcher("jsp/dashboard/movimientos.jsp").forward(request, response);
	}

	private void vizualizarPorMes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		int mes = Integer.parseInt(request.getParameter("mes"));

		List<MovimientoDTO> movimientos = DAOFactory.getFactory().getMovimientoDAO()
				.getAllByPesonaByMes(persona.getId(), mes);
		request.setAttribute("movimientos", movimientos);

		request.getRequestDispatcher("jsp/dashboard/movimientos.jsp").forward(request, response);
	}

	private void iniciarIngreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAllByPersona(persona.getId());

		List<Categoria> categoriasIngreso = DAOFactory.getFactory().getCategoriaDAO()
				.getAllTipoIngresoByPersona(persona.getId());

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

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		try {
			fecha = dateFormat.parse(strFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cuenta.setTotal(cuenta.getTotal() + valor);
		DAOFactory.getFactory().getCuentaDAO().update(cuenta);
		
		Movimiento movimiento = new Movimiento(concepto, valor, fecha, categoria, cuenta);
		DAOFactory.getFactory().getMovimientoDAO().create(movimiento);
		
		response.sendRedirect("MovimientoController?ruta=iniciarIngreso");
	}

	private void iniciarEgreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAllByPersona(persona.getId());

		List<Categoria> categoriasEgreso = DAOFactory.getFactory().getCategoriaDAO()
				.getAllTipoEgresoByPersona(persona.getId());

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

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		try {
			fecha = dateFormat.parse(strFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (valor > cuenta.getTotal()) {
			String mensaje = "El valor del egreso es mayor a la cantidad existente en la cuenta seleccionada";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("jsp/dashboard/error.jsp").forward(request, response);
			return;
		}
		
		cuenta.setTotal(cuenta.getTotal() - valor);
		
		DAOFactory.getFactory().getCuentaDAO().update(cuenta);
		
		Movimiento movimiento = new Movimiento(concepto, -valor, fecha, categoria, cuenta);
		DAOFactory.getFactory().getMovimientoDAO().create(movimiento);
		
		response.sendRedirect("MovimientoController?ruta=iniciarEgreso");
	}

	private void iniciarTransferencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");
		
		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAllByPersona(persona.getId());
		List<Categoria> categoriasTransferencia = DAOFactory.getFactory().getCategoriaDAO().getAllTipoTransferenciaByPersona(persona.getId());

		request.setAttribute("cuentas", cuentas);
		request.setAttribute("categoriasTransferencia", categoriasTransferencia);
		request.getRequestDispatcher("jsp/dashboard/transferencia.jsp").forward(request, response);
	}

	private void registarTransferencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCuentaOrg = Integer.parseInt(request.getParameter("cuenta_origen"));
		int idCuentaDest = Integer.parseInt(request.getParameter("cuenta_destino"));

		int idCategoria = Integer.parseInt(request.getParameter("categoria"));

		String concepto = request.getParameter("concepto");
		String strFecha = request.getParameter("fecha");
		double valor = Double.parseDouble(request.getParameter("valor"));

		Cuenta cuentaOrg = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaOrg);
		Cuenta cuentaDest = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaDest);
		Categoria categoria = DAOFactory.getFactory().getCategoriaDAO().getById(idCategoria);
		

		if (valor > cuentaOrg.getTotal()) {
			String mensaje = "El valor de transferencia es mayor a la cantidad existente en la cuenta de origen";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("jsp/dashboard/error.jsp").forward(request, response);
			return;
		}
		
		cuentaOrg.setTotal(cuentaOrg.getTotal() - valor);
		cuentaDest.setTotal(cuentaDest.getTotal() + valor);

		DAOFactory.getFactory().getCuentaDAO().update(cuentaOrg);
		DAOFactory.getFactory().getCuentaDAO().update(cuentaDest);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		try {
			fecha = dateFormat.parse(strFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Movimiento movimientoOrg = new Movimiento(concepto, -valor, fecha, categoria, cuentaOrg);
		Movimiento movimientoDest = new Movimiento(concepto, valor, fecha, categoria, cuentaDest, movimientoOrg);
		
		DAOFactory.getFactory().getMovimientoDAO().create(movimientoOrg);
		DAOFactory.getFactory().getMovimientoDAO().create(movimientoDest);
		movimientoOrg.setRelacion(movimientoDest);
		DAOFactory.getFactory().getMovimientoDAO().update(movimientoOrg);

		response.sendRedirect("MovimientoController?ruta=iniciarEgreso");
	}
	

	private void eliminarMovimiento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idMovimiento = Integer.parseInt(request.getParameter("idMovimiento"));
		
		Movimiento movimiento = DAOFactory.getFactory().getMovimientoDAO().getById(idMovimiento);
		
		Cuenta cuentaOrigen = movimiento.getCuenta();
		cuentaOrigen.setTotal(cuentaOrigen.getTotal() - movimiento.getValor());
		
		Movimiento movimientoRelacionado = movimiento.getRelacion();
		Cuenta cuentaDestino = null;
		if (movimientoRelacionado != null) {
			cuentaDestino = movimientoRelacionado.getCuenta();
			cuentaDestino.setTotal(cuentaDestino.getTotal() - movimientoRelacionado.getValor());
		}
		
		DAOFactory.getFactory().getCuentaDAO().update(cuentaOrigen);
		DAOFactory.getFactory().getCuentaDAO().update(cuentaDestino);
		DAOFactory.getFactory().getMovimientoDAO().deleteById(idMovimiento);
		
		response.sendRedirect("MovimientoController?ruta=vizualizarTodo");
	}

}
