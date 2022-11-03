package it.prova.gestionetv.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.service.MyServiceFactory;

@WebServlet("/PrepareUpdateTelevisoreServlet")
public class PrepareUpdateTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareUpdateTelevisoreServlet() {
        super();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idTelevisore = request.getParameter("idTelevisoreParametro");
		
		try {
			request.setAttribute("idTelevisore", idTelevisore);
			request.setAttribute("elementoDaAggiornare", MyServiceFactory.getTelevisoreServiceInstance().caricaSingolo(Long.parseLong(idTelevisore)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("modificaTelevisore.jsp");
		rd.forward(request, response);
	}

}
