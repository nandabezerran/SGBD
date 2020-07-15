//Alunas: Arina Sanches - 392476 e Fernanda Bezerra Nascimento - 388834
public class RegistroAuxiliar extends Registro implements Comparable<RegistroAuxiliar>{
	
	private int IdVenda, QuantidadeProduto;
	private String NomeProduto;


	public RegistroAuxiliar() {
		super(-1);
		IdVenda           = -1;
		QuantidadeProduto = -1;
		NomeProduto       = null;
	}

    public RegistroAuxiliar(int idVenda, int idFuncionario, String nomeProduto, int quantidadeProduto) {
		super(idFuncionario);
		IdVenda           = idVenda;
		QuantidadeProduto = quantidadeProduto;
		NomeProduto       = nomeProduto;
	}
    
	public int getIdVenda() {
		return IdVenda;
	}
	public void setIdVenda(int idVenda) {
		IdVenda = idVenda;
	}
	public int getQuantidadeProduto() {
		return QuantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		QuantidadeProduto = quantidadeProduto;
	}
	public String getNomeProduto() {
		return NomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		NomeProduto = nomeProduto;
	}

	@Override
	public int compareTo(RegistroAuxiliar outro) {
		if(this.getIdFuncionario() < outro.getIdFuncionario()){
			return -1;
		}
		
		if(this.getIdFuncionario() > outro.getIdFuncionario()){
			return 1;
		}		
		return 0;
	}

}