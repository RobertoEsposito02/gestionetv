package it.prova.gestionetv.model;

public class Televisore {
	private Long id;
	private String marca;
	private String modello;
	private int prezzo;
	private int numeroPollici;
	private String codice;
	
	public Televisore() {
	}

	public Televisore(Long id, String marca, String modello, int prezzo, int numeroPollici, String codice) {
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.numeroPollici = numeroPollici;
		this.codice = codice;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public int getNumeroPollici() {
		return numeroPollici;
	}

	public void setNumeroPollici(int numeroPollici) {
		this.numeroPollici = numeroPollici;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
}
