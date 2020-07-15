//Alunas: Arina Sanches - 392476 e Fernanda Bezerra Nascimento - 388834
public abstract class Registro {

	private int IdFuncionario;

	public Registro(int idFuncionario) {
		this.IdFuncionario = idFuncionario;
	}

	public int getIdFuncionario() {
		return IdFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		IdFuncionario = idFuncionario;
	}

	public String getNomeFuncionario() {
		return null;
	}

	public void setNomeFuncionario(String nomeFuncionario){}

	public String getSobrenome() {
		return null;
	}

	public void setSobrenome(String sobrenome){}

	public int getIdadeFuncionario() {
		return 0;
	}

	public void setIdadeFuncionario(int idadeFuncionario) {}

	public int getIdVenda() {
		return 0;
	}
	public void setIdVenda(int idVenda) {}

	public int getQuantidadeProduto() {
		return 0;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {}

	public String getNomeProduto() {
		return null;
	}

	public void setNomeProduto(String nomeProduto) {
	}

	public int compareTo(RegistroAuxiliar outro) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareTo(RegistroPrincipal outro, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareTo(RegistroFinal outro, int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}