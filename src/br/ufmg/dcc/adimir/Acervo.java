package br.ufmg.dcc.adimir;

/**
 * @author adimircolen
 *
 */
public class Acervo {
	public Art[] obras = new Art[1];
	
	public void add(Art obra) {
		int length = this.obras.length;
		if (obras[length-1] == null) {
			obras[length-1] = obra;
		}else{
			Art[] novoArray = new Art[length + 1];
			System.arraycopy(obras, 0, novoArray, 0, obras.length);
			novoArray[novoArray.length-1] = obra;
			this.obras = novoArray;
		}
	}
	
	public static String parseString(Art[] obras) {
		String result = new String();
		for(int i=0;i<obras.length;i++){
			result += obras[i] + "\n";
		}
		return result;
	}
	
	public String toString() {
		String result = new String();
		for(int i=0;i<this.obras.length;i++){
			result += this.obras[i] + "\n";
		}
		return result;
	}

	public void remover(Art[] obras) {
		for(int i=0;i<obras.length;i++){
			int index = indexOf(obras[i]);
			remover(index);
		}
	}
	

	public void remover(int index) {
		if ( index >= 0 ){
			Art[] final_array = new Art[this.obras.length-1];
			if (index > 0 && index < this.obras.length){
				System.arraycopy(this.obras, 0, final_array, 0, index);
				System.arraycopy(this.obras, index+1, final_array, index, final_array.length - index);
				this.obras = final_array;
			}else{
				int startIndex = (index == 0) ? 1 : 0;
				int endIndex = this.obras.length - 1;

				System.arraycopy(this.obras, startIndex, final_array, 0, endIndex);
				this.obras = final_array;
			}
		}
	}
	

	public int indexOf(Art obra) {
		for(int i=0;i<this.obras.length;i++) {
			if (obra != null && obra.equals(this.obras[i])) {
				return i;
			}
		}
		return -1;
	}
	

	public Art[] searchBy(String name, String author, Integer type) {
		Acervo result = new Acervo();
		for(int i=0;i<this.obras.length;i++){
			if ( name != null && this.obras[i].getName().equals( name ) ){
				result.add(this.obras[i]);
				continue;
			}
			if ( author != null && this.obras[i].getAuthor().equals( author ) ){
				result.add(this.obras[i]);
				continue;
			}
			if (type != null && this.obras[i].getArtType() == type) {
				result.add(this.obras[i]);
				continue;				
			}
		}
		return result.obras;
	}


	public static void main(String[] args) {
		Art[] initObras = {
			new Art(1, "Moisés", "Michelangelo", Art.ESCULTURA),
			new Art(2, "Os Girassóis", "Van Gogh", Art.PINTURA),
			new Art(3, "Guernica", "Picasso", Art.PINTURA),
			new Art(4, "A última ceia", "Leonardo da Vince", Art.PINTURA),
			new Art(5, "The Creation of Man", "Michelangelo", Art.PINTURA),
			new Art(6, "Monalisa", "Leonardo da Vince", Art.PINTURA),
			new Art(7, "O Pensador", "Rodin", Art.ESCULTURA),
			new Art(8, "Creation of the Sun and Moon", "Michelangelo", Art.PINTURA),
			new Art(9, "David", "Michelangelo", Art.ESCULTURA),
		};
		
		Acervo acervo = new Acervo();
		
		for(int i=0;i<initObras.length;i++) {
			acervo.add(initObras[i]);
		}
		
		System.out.println("Listagem de Todas as Obras\n" + acervo);
		
		Art[] michelangelo = acervo.searchBy(null, "Michelangelo", null);
		System.out.println("Listagem das Obras de Michelangelo");
		
		Art[] sculpt = acervo.searchBy(null, null, Art.ESCULTURA);
		System.out.println("Listagem das Esculturas");
		System.out.println(Acervo.parseString(sculpt));

		Art[] paint = acervo.searchBy(null, null, Art.PINTURA);
		System.out.println("Listagem das Pinturas");
		System.out.println(Acervo.parseString(paint));
		
		acervo.remover(michelangelo);
		System.out.println("Listagem de todas Todas as Obras\n" + acervo);
	}
}
