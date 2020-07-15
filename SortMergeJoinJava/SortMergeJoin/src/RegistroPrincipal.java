//Alunas: Arina Sanches - 392476 e Fernanda Bezerra Nascimento - 388834
public class RegistroPrincipal extends Registro implements Comparable<RegistroPrincipal>{
	
	private String NomeFuncionario, Sobrenome;
	
	private int IdadeFuncionario;
	public RegistroPrincipal() {
		super(-1);
		NomeFuncionario  = null;
		Sobrenome        = null;
		IdadeFuncionario = -1;
	}

	public RegistroPrincipal(int idFuncionario, String nomeFuncionario, String sobrenome, int idadeFuncionario) {
		super(idFuncionario);
		NomeFuncionario  = nomeFuncionario;
		Sobrenome        = sobrenome;
		IdadeFuncionario = idadeFuncionario;
	}
	
	public String getNomeFuncionario() {
		return NomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		NomeFuncionario = nomeFuncionario;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}
	public int getIdadeFuncionario() {
		return IdadeFuncionario;
	}
	public void setIdadeFuncionario(int idadeFuncionario) {
		IdadeFuncionario = idadeFuncionario;
	}
	
	public int compareTo(RegistroPrincipal outro) {
		if(this.getIdFuncionario() < outro.getIdFuncionario()){
			return -1;
		}
		
		if(this.getIdFuncionario() > outro.getIdFuncionario()){
			return 1;
		}		
		return 0;
	}
		
}