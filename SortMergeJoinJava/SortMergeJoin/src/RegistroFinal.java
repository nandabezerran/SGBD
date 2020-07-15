//Alunas: Arina Sanches - 392476 e Fernanda Bezerra Nascimento - 388834
public class RegistroFinal extends Registro implements Comparable<RegistroFinal>{

    private String NomeFuncionario, Sobrenome;
    private int IdVenda, QuantidadeProduto;
    private String NomeProduto;
    private int IdadeFuncionario;

    public RegistroFinal() {
        super(-1);
        NomeFuncionario   = null;
        Sobrenome         = null;
        IdadeFuncionario  = -1;
        IdVenda           = -1;
        QuantidadeProduto = -1;
        NomeProduto       = null;
    }
    public RegistroFinal(int idFuncionario, String nomeFuncionario, String sobrenome, int idadeFuncionario, int idVenda,
                         String nomeProduto, int quantidadeProduto) {
        super(idFuncionario);
        NomeFuncionario   = nomeFuncionario;
        Sobrenome         = sobrenome;
        IdadeFuncionario  = idadeFuncionario;
        IdVenda           = idVenda;
        QuantidadeProduto = quantidadeProduto;
        NomeProduto       = nomeProduto;
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


    public int compareTo(RegistroFinal outro) {
        if(this.getIdFuncionario() < outro.getIdFuncionario()){
            return -1;
        }

        if(this.getIdFuncionario() > outro.getIdFuncionario()){
            return 1;
        }
        return 0;
    }

}


