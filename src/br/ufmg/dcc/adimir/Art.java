package br.ufmg.dcc.adimir;

/**
 * @author adimircolen
 *
 */
public class Art {
	public static final int ESCULTURA = 0;
	public static final int PINTURA = 1;
	private int nId;
	private String name;
	private String author;
	private int artType;
	
	
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getArtType() {
		return artType;
	}
	public void setArtType(int artType) {
		this.artType = artType;
	}
	public Art() {}
	public Art(String nome, String autor) {
		this(0, nome, autor, 0);
	}

	public Art(int nId, String nome, String autor, int tipo) {
		this.nId = nId;
		this.name = nome;
		this.author = autor;
		this.artType = tipo;
	}
	
	public Art(String nome, String autor, int tipo) {
		this.name = nome;
		this.author = autor;
		this.artType = tipo;
	}
	
	public String toString() {
		String result = String.format("No. Id: %1$d| Nome: %2$-30s| Autor: %3$-20s| Tipo: %4$-10s",this.nId, this.name, this.author, (this.artType == 0 ? "Escultura":"Pintura") );
		return result;
	}
	
	public boolean equals(Art obra) {
		if(obra == null)
		    return false;
		if(nId == obra.nId &&
				name.equals(obra.name) &&
				author.equals(obra.author)&&
				artType == obra.artType)
			return true;
		return false;
	}

}
