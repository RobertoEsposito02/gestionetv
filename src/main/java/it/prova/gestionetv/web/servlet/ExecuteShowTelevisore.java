package it.prova.gestionetv.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.service.MyServiceFactory;

@WebServlet("/ExecuteShowAllTelevisore")
public class ExecuteShowTelevisore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteShowTelevisore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marca = request.getParameter("marcaInput");
		String modello = request.getParameter("modelloInput");
		
		if(marca.equals("") && modello.equals("")) {
			String messaggioDiErrore = "Inserire almeno le iniziali di marca o modello";
			request.setAttribute("messaggioDiErrore_attr", messaggioDiErrore);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			return;
		}
		
		try {
			request.setAttribute("listMarcaEModello_attr", MyServiceFactory.getTelevisoreServiceInstance().caricaPerMarcaEModello(marca,modello));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}
}
