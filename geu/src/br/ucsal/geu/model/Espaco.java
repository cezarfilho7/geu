package br.ucsal.geu.model;

public class Espaco {
	
	private Integer id;
	
	private String identificacao;
	
	private String andar;
	
	private Bloco bloco;
	
	private Tipo Tipo;

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}


	public Tipo getTipo() {
		return Tipo;
	}

	public void setTipo(Tipo tipo) {
		Tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
	
}
