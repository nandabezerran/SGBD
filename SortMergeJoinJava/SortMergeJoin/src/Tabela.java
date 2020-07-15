//Alunas: Arina Sanches - 392476 e Fernanda Bezerra Nascimento - 388834
import java.util.ArrayList;
import java.util.Iterator;

public class Tabela {
	
	private int quantidadePaginas;
	ArrayList<Pagina> paginas = new ArrayList<Pagina>();

	public Tabela(int quantidadePaginas, ArrayList<Pagina> paginas) {
		this.quantidadePaginas = quantidadePaginas;
		this.paginas           = paginas;
	}

	public Tabela() {
		this.quantidadePaginas = 0;
		this.paginas           = null;
	}
	
	public int getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(int quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	public void setPaginas(ArrayList<Pagina> paginas){
		Pagina pagina;
		for (Iterator iterator = paginas.iterator(); iterator.hasNext();){
			pagina = (Pagina)iterator.next();
			this.paginas.add(pagina);
		}
	}

	public void setPagina(Pagina pagina){
		this.paginas.add(pagina);
	}
	
	public ArrayList<Pagina> getPaginas(){
		return this.paginas;
	}
	

}