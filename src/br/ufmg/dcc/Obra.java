package br.ufmg.dcc;

/**
 * @author adimircolen
 *
 */
public class Obra {
	public static final int ESCULTURA = 0;
	public static final int PINTURA = 1;
	private int nId;
	private String nome;
	private String autor;
	private int tipo;
	
	
	public Obra() {}
	public Obra(String nome, String autor) {
		this(0, nome, autor, 0);
	}

	public Obra(int nId, String nome, String autor, int tipo) {
		this.nId = nId;
		this.nome = nome;
		this.autor = autor;
		this.tipo = tipo;
	}
	
	public Obra(String nome, String autor, int tipo) {
		this.nome = nome;
		this.autor = autor;
		this.tipo = tipo;
	}
	
	public String toString() {
		String result = String.format("No. Id: %1$d| Nome: %2$-30s| Autor: %3$-20s| Tipo: %4$-10s",this.nId, this.nome, this.autor, (this.tipo == 0 ? "Escultura":"Pintura") );
		return result;
	}
	
	public boolean equals(Obra obra) {
		if(obra == null)
		    return false;
		if(nId == obra.nId &&
				nome.equals(obra.nome) &&
				autor.equals(obra.autor)&&
				tipo == obra.tipo)
			return true;
		return false;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public static void main(String[] args) {}

}
