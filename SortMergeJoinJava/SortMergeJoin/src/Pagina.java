//Alunas: Arina Sanches - 392476 e Fernanda Bezerra Nascimento - 388834
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Pagina {
	
	public Registro registros[];
	
	public int qtdRegistros;
	
	int ponteiro = 0;
	int tamanho = 0;
	int numElementos = 0;
			

	public Pagina(RegistroPrincipal[] reg) {
		this.registros = new RegistroPrincipal[16];
		this.registros = reg;
		this.tamanho   = 16;
	}
	
	public Pagina(RegistroAuxiliar[] reg) {
		this.registros = new RegistroAuxiliar[16];
		this.registros = reg;
		this.tamanho   = 16;
	}

	public Pagina(RegistroFinal[] reg) {
		this.registros = new RegistroFinal[16];
		this.registros = reg;
		this.tamanho   = 16;
	}

	public int getPonteiro() {
		return ponteiro;
	}

	public void setPonteiro(int ponteiro) {
		this.ponteiro = ponteiro;
	}

	public void IncrementarPonteiro() {
		this.ponteiro++;
	}
	
	public int getQtdRegistros() {
		return qtdRegistros;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public void setNumElementos(int numElementos) {
		this.numElementos = numElementos;
	}

	public void IncrementarNumElementos() {
		this.numElementos++;
	}

	public void setQtdRegistros(int qtdRegistros) {
		this.qtdRegistros = qtdRegistros;
	}
	
	public Registro[] getRegistros(){
		return registros;		
	}
	
	public void setRegistro(RegistroPrincipal[] reg){
		this.registros = reg;
	}

	public void setRegistro(RegistroAuxiliar[] reg){
		this.registros = reg;
	}

	public void setRegistro(RegistroFinal[] reg){
		this.registros = reg;
	}
	
	public void setRegistro(RegistroPrincipal reg){
		if(numElementos < qtdRegistros){
			this.registros[numElementos] = reg;
			numElementos ++;
		}
	}

	public void setRegistro(RegistroAuxiliar reg){
		if(numElementos < qtdRegistros){
			this.registros[numElementos] = reg;
			numElementos ++;
		}
	}

	public void setRegistro(RegistroFinal reg){
		if(numElementos < qtdRegistros){
			this.registros[numElementos] = reg;
			numElementos ++;
		}
	}

	// Função para ordenar os registros da pagina, usa o sort da classe Collections
	public void ordenarRegistros(){
		if(this.numElementos > 1) {
			Arrays.sort(registros);
		}

	}	
	
}