package br.ufmg.dcc;

/**
 * @author adimircolen
 *
 */
public class Acervo {
	public Obra[] obras = new Obra[1];
	
	public void adicionar(Obra obra) {
		int length = this.obras.length;
		if (obras[length-1] == null) {
			obras[length-1] = obra;
		}else{
			Obra[] novoArray = new Obra[length + 1];
			System.arraycopy(obras, 0, novoArray, 0, obras.length);
			novoArray[novoArray.length-1] = obra;
			this.obras = novoArray;
		}
	}
	
	public Obra remover(String name, String autor, int tipo) {
		return new Obra();
	}
	
	public static void listar(Obra[] obras) {
		for(int i=0;i<obras.length;i++){
			System.out.println(obras[i]);
		}
	}
	
	public void listar() {
		System.out.println("Listagem do Acervo");
		for(int i=0;i<this.obras.length;i++){
			System.out.println(this.obras[i]);
		}
	}
	
	public void listarPorAutor(String autor) {
		Acervo porAutor = new Acervo();
		for(int i=0;i<this.obras.length;i++){
			if (this.obras[i] != null && this.obras[i].getAutor().equals(autor)) {
				porAutor.adicionar(this.obras[i]);
			}
		}
		Acervo.listar(porAutor.obras);
	}
	
	public void listarPorEsculturas() {
		Acervo esculturas = new Acervo();
		for(int i=0;i<this.obras.length;i++){
			if (this.obras[i] != null && this.obras[i].getTipo() == Obra.ESCULTURA) {
				esculturas.adicionar(this.obras[i]);
			}
		}
		Acervo.listar(esculturas.obras);
	}
	
	public void listarPorPinturas() {
		Acervo pinturas = new Acervo();
		for(int i=0;i<this.obras.length;i++){
			if (this.obras[i] != null && this.obras[i].getTipo() == Obra.PINTURA) {
				pinturas.adicionar(this.obras[i]);
			}
		}
		Acervo.listar(pinturas.obras);
	}

	public void remover(Obra[] obras) {
		for(int i=0;i<obras.length;i++){
			System.out.println("Remover "+ i + " Obra " + obras[i]);
			remover(obras[i]);
		}
	}
	
	public void remover(Obra obra) {
		for(int i=0;i<this.obras.length;i++){
			
			if (obra != null && obra.equals(this.obras[i])){
				System.out.println("SPLIT -> "+ i);
				if (i>0){
					Obra[] primeiraParte = new Obra[i];
					System.out.println("NOVO TAMANHO -> "+ primeiraParte.length);
					System.arraycopy(this.obras, 0, primeiraParte, 0, primeiraParte.length);
					Acervo.listar(primeiraParte);
					Obra[] segundaParte = new Obra[i];
					int init = (this.obras.length - 1) - i;
					System.out.println("SEGUNDA PARTE init -> "+ init);
					System.arraycopy(this.obras, init, primeiraParte, 0, primeiraParte.length);
					
				}else{
					Obra[] novoArray = new Obra[this.obras.length -1];
					System.arraycopy(this.obras, 1, novoArray, 0, novoArray.length);
					this.obras = novoArray;
				}
				break;
			}
		}
	}
	
	public Obra[] procurarPor(String nome, String autor) {
		return procurar(new Obra(nome, autor));
	}
	
	public Obra[] procurar(Obra obra) {
		Acervo result = new Acervo();
		for(int i=0;i<this.obras.length;i++){
			if ( obra.getNome() != null && this.obras[i].getNome().equals( obra.getNome() ) ){
				result.adicionar(this.obras[i]);
				continue;
			}
			if ( obra.getAutor() != null && this.obras[i].getAutor().equals( obra.getAutor() ) ){
				result.adicionar(this.obras[i]);
				continue;
			}
		}
		return result.obras;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Obra[] initObras = {
			new Obra(1, "Moisés", "Michelangelo", Obra.ESCULTURA),
			new Obra(2, "Os Girassóis", "Van Gogh", Obra.PINTURA),
			new Obra(3, "Guernica", "Picasso", Obra.PINTURA),
			new Obra(4, "A última ceia", "Leonardo da Vince", Obra.PINTURA),
			new Obra(5, "The Creation of Man", "Michelangelo", Obra.PINTURA),
			new Obra(6, "Monalisa", "Leonardo da Vince", Obra.PINTURA),
			new Obra(7, "O Pensador", "Rodin", Obra.ESCULTURA),
			new Obra(8, "Creation of the Sun and Moon", "Michelangelo", Obra.PINTURA),
			new Obra(9, "David", "Michelangelo", Obra.ESCULTURA),
		};
		
		Acervo acervo = new Acervo();
		
		for(int i=0;i<initObras.length;i++) {
			acervo.adicionar(initObras[i]);
		}
		
		System.out.println("Listagem de Todas as Obras");
		acervo.listar();
		
//		System.out.println("Listagem das Obras de Michelangelo");
		Obra[] michelangelo = acervo.procurarPor(null, "Michelangelo");
		Acervo.listar(michelangelo);
		
//		System.out.println("Listagem das Esculturas");
//		acervo.listarPorEsculturas();
		
//		System.out.println("Listagem das Pinturas");
//		acervo.listarPorPinturas();
		
		acervo.remover(michelangelo);
		System.out.println("Procurar e remover obras de Michelangelo");
		acervo.listar();
		

//		acervo.listar();
		
		
	}

}
