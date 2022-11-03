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

@WebServlet("/ExecuteUpdateTelevisoreServlet")
public class ExecuteUpdateTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteUpdateTelevisoreServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marcaInput = request.getParameter("marcaInput");
		String modelloInput = request.getParameter("modelloInput");
		String prezzo = request.getParameter("prezzoInput");
		String numeroPollici = request.getParameter("numeroPolliciInput");
		String codice = request.getParameter("codiceInput");
		Long idTel = Long.parseLong(request.getParameter("idTelevisore"));
		
		
		if(marcaInput.isBlank() || modelloInput.isBlank() || prezzo.isBlank() || numeroPollici.isBlank() || codice.isBlank()) {
			String messaggioDiErrore = "Devi riempire tutti i campi per poter inserire correttamente un televisore";
			try {
				request.setAttribute("messaggioDiErrore", messaggioDiErrore);
				request.setAttribute("idTel", idTel);
				request.setAttribute("elementoDaAggiornare", MyServiceFactory.getTelevisoreServiceInstance().caricaSingolo(idTel));
				request.getRequestDispatcher("modificaTelevisore.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		
		Televisore televisoreAggiornato = new Televisore();
		televisoreAggiornato.setMarca(marcaInput);
		televisoreAggiornato.setModello(modelloInput);
		televisoreAggiornato.setPrezzo(Integer.parseInt(prezzo));
		televisoreAggiornato.setNumeroPollici(Integer.parseInt(numeroPollici));
		televisoreAggiornato.setCodice(codice);
		televisoreAggiornato.setId(idTel);
		
		try {
			MyServiceFactory.getTelevisoreServiceInstance().aggiorna(televisoreAggiornato);
			request.setAttribute("listMarcaEModello_attr", MyServiceFactory.getTelevisoreServiceInstance().caricaTuttaLaLista());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}

}
