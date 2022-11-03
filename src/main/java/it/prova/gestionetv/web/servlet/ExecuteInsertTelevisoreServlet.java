package it.prova.gestionetv.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.model.Televisore;
import it.prova.gestionetv.service.MyServiceFactory;

@WebServlet("/ExecuteInsertTelevisoreServlet")
public class ExecuteInsertTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteInsertTelevisoreServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marcaInput = request.getParameter("marcaInput");
		String modelloInput = request.getParameter("modelloInput");
		String prezzo = request.getParameter("prezzoInput");
		String numeroPollici = request.getParameter("numeroPolliciInput");
		String codice = request.getParameter("codiceInput");
		
		if(marcaInput.isBlank() || modelloInput.isBlank() || prezzo.isBlank() || numeroPollici.isBlank() || codice.isBlank()) {
			String messaggioDiErrore = "Devi riempire tutti i campi per poter inserire correttamente un televisore";
			request.setAttribute("messaggioDiErrore", messaggioDiErrore);
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}
		
		Televisore nuovoTelevisore = new Televisore();
		nuovoTelevisore.setMarca(marcaInput);
		nuovoTelevisore.setModello(modelloInput);
		nuovoTelevisore.setPrezzo(Integer.parseInt(prezzo));
		nuovoTelevisore.setNumeroPollici(Integer.parseInt(numeroPollici));
		nuovoTelevisore.setCodice(codice);
		
		try {
			MyServiceFactory.getTelevisoreServiceInstance().inserisciAbitante(nuovoTelevisore);
			
			request.setAttribute("listMarcaEModello_attr", MyServiceFactory.getTelevisoreServiceInstance().caricaTuttaLaLista());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
		
	}

}
