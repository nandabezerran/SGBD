//Alunas: Arina Sanches - 392476 e Fernanda Bezerra Nascimento - 388834
import java.io.*;
import java.util.ArrayList;

public class main {

	//Função para ler um arquivo com registros do tipo registro final, funcao como teste para ler um arquivo cuja
	//ultima pagina não tem exatos 16 registros
	// \retorna uma Tabela preenchida com os dados do arquivo
	public static Tabela LerArquivoSortMergeJoin() throws IOException {

		String linha;
		String[] partes;
		int qtdRegistros = 16;

		BufferedReader br = new BufferedReader(new FileReader("src/SortMergeJoin.txt"));
		ArrayList<Pagina> paginasVetor = new ArrayList<Pagina>();
		linha = br.readLine();


		while (linha != null) {
			int numRegistros = 0; //quantidade de registros adicionados

			RegistroFinal[] registro = new RegistroFinal[qtdRegistros];
			for (int j = 0; j < qtdRegistros && linha!=null; j++) {

				partes = linha.split(",");
				RegistroFinal registroFinal = new RegistroFinal(Integer.parseInt(partes[0]),
						partes[1], partes[2], Integer.parseInt(partes[3]),Integer.parseInt(partes[4]),
						partes[5],Integer.parseInt(partes[6]));
				registro[j] = registroFinal;
				linha = br.readLine();
				numRegistros++;

			}

			Pagina pagina = new Pagina(registro);
			pagina.setNumElementos(numRegistros);
			paginasVetor.add(pagina);

		}
		Tabela tabelaFinal = new Tabela(paginasVetor.size(), paginasVetor);
		br.close();
		return tabelaFinal;
	}
	//Função para ler um arquivo com registros do tipo registro principal
	// \retorna uma Tabela preenchida com os dados do arquivo
	public static Tabela LerArquivoFuncionario() throws IOException {

		String linha;
		String[] partes;
		int qtdRegistros = 16;

		BufferedReader br = new BufferedReader(new FileReader("src/data_Funcionario.txt"));
		ArrayList<Pagina> paginasVetor = new ArrayList<Pagina>();
		linha = br.readLine();


		while (linha != null) {
			int numRegistros = 0; //quantidade de registros adicionados

			RegistroPrincipal[] registro = new RegistroPrincipal[qtdRegistros];
			for (int j = 0; j < qtdRegistros && linha!=null; j++) {

				partes = linha.split(",");
				RegistroPrincipal registroPrincipal = new RegistroPrincipal(Integer.parseInt(partes[0]),
						partes[1], partes[2], Integer.parseInt(partes[3]));
				registro[j] = registroPrincipal;
				linha = br.readLine();
				numRegistros++;

			}

			Pagina pagina = new Pagina(registro);
			pagina.setNumElementos(numRegistros);
			paginasVetor.add(pagina);

		}
		Tabela tabelaFuncionario = new Tabela(paginasVetor.size(), paginasVetor);
		br.close();
		return tabelaFuncionario;
	}

	//Função para ler um arquivo com registros do tipo registro principal
	// \retorna uma Tabela preenchida com os dados do arquivo
	public static Tabela LerArquivoVendas() throws IOException {

		String linha;
		String[] partes;
		int qtdRegistros = 16;
		BufferedReader br = new BufferedReader(new FileReader("src/data_Venda.txt"));
		ArrayList<Pagina> paginasVetor = new ArrayList<Pagina>();
		linha = br.readLine();

		while (linha != null) {
			RegistroAuxiliar[] registro = new RegistroAuxiliar[qtdRegistros];
			int numRegistros = 0; //quantidade de registros adicionados

			for (int j = 0; j < qtdRegistros && linha!=null ; j++) {

				partes = linha.split(",");
				RegistroAuxiliar registroAuxiliar = new RegistroAuxiliar(Integer.parseInt(partes[0]),
						Integer.parseInt(partes[1]), partes[2],
						Integer.parseInt(partes[3]));

				registro[j] = registroAuxiliar;
				linha       = br.readLine();
				numRegistros++;

			}
			Pagina pagina = new Pagina(registro);
			pagina.setNumElementos(numRegistros);
			paginasVetor.add(pagina);


		}
		Tabela tabelaVendas = new Tabela(paginasVetor.size(), paginasVetor);
		br.close();
		return tabelaVendas;
	}

	//Função para interclar os registros de vendas
	// \parametro pags =  ArrayList contendo as paginas ordenadas a serem intercaladas
	// \returna um arrayList com as os registros ordenados em funcao do idFuncionario
	public static ArrayList<Pagina> IntercalaVendas(ArrayList<Pagina> pags) {

		ArrayList<Pagina> paginas = new ArrayList<Pagina>();
		int indPag = 0, indRegistro = 0;
		int qtdRegistros = 16;
		int candidato = 100000, ponteiro;
		int qtdPaginas = pags.size();
		int tamanho = 0;
		RegistroAuxiliar[] registros = new RegistroAuxiliar[qtdRegistros];
		while (paginas.size() != pags.size()) {
			int control = 0;
			for (int i = 0; i < pags.size(); i++) {
				ponteiro = pags.get(i).getPonteiro();
				if (ponteiro < pags.get(i).numElementos) {
					if (pags.get(i).getRegistros()[ponteiro].getIdFuncionario() <= candidato) {
						candidato   = pags.get(i).getRegistros()[ponteiro].getIdFuncionario();
						indPag      = i;
						indRegistro = ponteiro;
						control     = 1;
					}
				}
			}
			candidato = 1000000;
			if(control == 1) {
				registros[tamanho] = (RegistroAuxiliar) pags.get(indPag).getRegistros()[indRegistro];
				pags.get(indPag).IncrementarPonteiro();
			}
			tamanho++;

			if (tamanho == 16) {
				Pagina pagAux = new Pagina(registros);
				paginas.add(pagAux);
				registros    = new RegistroAuxiliar[qtdRegistros];
				tamanho      = 0;
			}
		}
		return paginas;
	}

	//Função para interclar os registros de Funcionario
	// \parametro pags =  ArrayList contendo as paginas ordenadas a serem intercaladas
	// \returna um arrayList com as os registros ordenados em funcao do idFuncionario
	public static ArrayList<Pagina> IntercalaFuncionario(ArrayList<Pagina> pags) {

		ArrayList<Pagina> paginas = new ArrayList<Pagina>();
		int indPag = 0, indRegistro = 0;
		int qtdRegistros = 16;
		int candidato = 100000, ponteiro;
		int qtdPaginas = pags.size();
		int tamanho = 0;
		RegistroPrincipal[] registros = new RegistroPrincipal[qtdRegistros];

		while (paginas.size() != pags.size()) {
			int control = 0;
			for (int i = 0; i < pags.size(); i++) {
				ponteiro = pags.get(i).getPonteiro();
				if (ponteiro < pags.get(i).numElementos) {
					if (pags.get(i).getRegistros()[ponteiro].getIdFuncionario() <= candidato) {
						candidato   = pags.get(i).getRegistros()[ponteiro].getIdFuncionario();
						indPag      = i;
						indRegistro = ponteiro;
						control     = 1;
					}
				}
			}
			candidato = 1000000;
			if(control == 1) {
				registros[tamanho] = (RegistroPrincipal) pags.get(indPag).getRegistros()[indRegistro];
				pags.get(indPag).IncrementarPonteiro();
			}
			tamanho++;

			if (tamanho == 16) {
				Pagina pagAux = new Pagina(registros);
				paginas.add(pagAux);
				registros = new RegistroPrincipal[qtdRegistros];
				tamanho = 0;
			}
		}
		return paginas;
	}

	//Funçãp para realizar a junção de duas tabelas pelo idFuncionario
	// \parametro Funcionarios = tabela com os registros do tipo Principal
	// \parametro Vendas       = tabela com os registros do tipo Auxiliar
	// \retorna uma tabela com o resultado da junção
	public static Tabela Juncao(Tabela Funcionarios, Tabela Vendas) {
		RegistroPrincipal tf ;
		RegistroAuxiliar  tv ;
		RegistroAuxiliar  gv ;

		int     posicaoRegVendas       =  0,
				posicaoRegFuncionarios =  0,
				posicaoPagVendas       =  0,
				posicaoPagFuncionarios =  0,
				qtdRegistros           = 16,
				ocupacaoRegistro       =  0;

		ArrayList<Pagina> paginas  = new ArrayList<>();
		RegistroFinal[]  registros = new RegistroFinal[qtdRegistros];


		tf = (RegistroPrincipal) Funcionarios.getPaginas().get(posicaoPagFuncionarios).
				getRegistros()
				[posicaoRegFuncionarios];

		tv = (RegistroAuxiliar) Vendas.getPaginas().get(posicaoPagVendas).
				getRegistros()
				[posicaoRegVendas];
		gv = (RegistroAuxiliar) Vendas.getPaginas().get(posicaoPagVendas).
				getRegistros()
				[posicaoRegVendas];

		while (posicaoPagFuncionarios < Funcionarios.getPaginas().size() ||  posicaoPagVendas
				< Vendas.getPaginas().size()){
			while (tf.getIdFuncionario() < gv.getIdFuncionario() && posicaoPagFuncionarios <
					Funcionarios.getPaginas().size()){
				posicaoRegFuncionarios++;

				if (posicaoRegFuncionarios == Funcionarios.getPaginas().get(posicaoPagFuncionarios).tamanho){
					posicaoPagFuncionarios++;
					posicaoRegFuncionarios = 0;

				}

				if (posicaoPagFuncionarios >= Funcionarios.getPaginas().size()){
					break;
				}

				tf = (RegistroPrincipal) Funcionarios.getPaginas().get(posicaoPagFuncionarios)
						.getRegistros()[posicaoRegFuncionarios];

			}

			while (tf.getIdFuncionario() > gv.getIdFuncionario() && posicaoPagVendas
					< Vendas.getPaginas().size()){

				posicaoRegVendas++;
				if (posicaoRegVendas == Vendas.getPaginas().get(posicaoPagVendas).tamanho){
					posicaoPagVendas++;
					posicaoRegVendas = 0;
				}
				gv = (RegistroAuxiliar) Vendas.getPaginas().get(posicaoPagVendas).getRegistros()[posicaoRegVendas];
			}
			tv = gv;

			while (tf.getIdFuncionario() == gv.getIdFuncionario() && posicaoPagFuncionarios
					< Funcionarios.getPaginas().size()){

				tf = (RegistroPrincipal) Funcionarios.getPaginas().get(posicaoPagFuncionarios)
						.getRegistros()[posicaoRegFuncionarios];

				while (tf.getIdFuncionario() == tv.getIdFuncionario() && posicaoPagVendas
						< Vendas.getPaginas().size()){

					Registro funcionarioAtual = Funcionarios.getPaginas().get(posicaoPagFuncionarios).
							getRegistros()
							[posicaoRegFuncionarios];

					Registro vendaAtual = Vendas.getPaginas().get(posicaoPagVendas).
							getRegistros()
							[posicaoRegVendas];

					RegistroFinal registro = new RegistroFinal(
							funcionarioAtual.getIdFuncionario(),
							funcionarioAtual.getNomeFuncionario(),
							funcionarioAtual.getSobrenome(),
							funcionarioAtual.getIdadeFuncionario(),
							vendaAtual.getIdVenda(),
							vendaAtual.getNomeProduto(),
							vendaAtual.getQuantidadeProduto());

					registros[ocupacaoRegistro] = registro;
					ocupacaoRegistro++;
					posicaoRegVendas++;

					if (posicaoRegVendas == Vendas.getPaginas().get(posicaoPagVendas).tamanho){
						posicaoPagVendas++;
						posicaoRegVendas = 0;
					}

					if (posicaoRegVendas == 16){
						System.out.println();
					}

					if (posicaoPagVendas >= Vendas.getPaginas().size()){
						break;
					}

					tv = (RegistroAuxiliar) Vendas.getPaginas().get(posicaoPagVendas).getRegistros()[posicaoRegVendas];

					if (ocupacaoRegistro ==  qtdRegistros ){
						Pagina pagina = new Pagina(registros);
						paginas.add(pagina);
						registros = new RegistroFinal[qtdRegistros];
						ocupacaoRegistro = 0;
					}

				}

				posicaoRegFuncionarios++;
				if (posicaoRegFuncionarios == Funcionarios.getPaginas().get(posicaoPagFuncionarios).tamanho){
					posicaoPagFuncionarios++;
					posicaoRegFuncionarios = 0;
				}

			}
			gv = tv;
		}

		if(ocupacaoRegistro != 0){
			Pagina pagina = new Pagina(registros);
			paginas.add(pagina);
		}

		return new Tabela(paginas.size(),paginas);
	}

	//Função para ordenar os registros que estao na mesma pagina da tabela
	// \parametro tabela = tabela com os registros a serem ordenados
	public static void OrdenarRegistros(Tabela tabela) {
		int i = 0, qtdPags = tabela.getQuantidadePaginas();
		while (qtdPags > 0) {
			tabela.getPaginas().get(i).ordenarRegistros();
			qtdPags--;
			i++;
		}

	}

	//Funcao para realizar a escrita dos registros de uma tabela num arquivo
	// \parametro TabelaFinal = tabela a ser gravada
	// \returna um arquivo
	public static void EscreverTabelaFinal(Tabela TabelaFinal) throws IOException {
		File fout = new File("src/SortMergeJoin.txt");
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw    = new BufferedWriter(new OutputStreamWriter(fos));

		for (int i = 0; i < TabelaFinal.getQuantidadePaginas(); i++) {
			Registro[] registrosAtuais = TabelaFinal.getPaginas().get(i).getRegistros();
			for (int j = 0; j < registrosAtuais.length && registrosAtuais[j]!=null; j++) {
				String str;
				Registro registroAtual = registrosAtuais[j];
				str = (registroAtual.getIdFuncionario()+ "," +
						registroAtual.getNomeFuncionario()+ "," +
						registroAtual.getSobrenome()+","+
						registroAtual.getIdadeFuncionario()+ "," +
						registroAtual.getIdVenda()+ "," +
						registroAtual.getNomeProduto()+ "," +
						registroAtual.getQuantidadeProduto());
				bw.write(str);
				bw.newLine();

			}
		}

		bw.close();
	}

	//Função para aplicar o algortimo sortMerge sobre duas tabelas (juncao sobre o atributo idFuncionario)
	// \parametro tabelaFuncionario = tabela com os dados dos funcionarios
	// \parametro tabelaVendas      = tabela com os dados das vendas
	// \retorna uma tabela com o resultado da junção
	public static Tabela SortMerge(Tabela tabelaFuncionario, Tabela tabelaVendas){

		Tabela tabelaFinal;

		Tabela tabVendas       = new Tabela(tabelaVendas.getQuantidadePaginas(), tabelaVendas.getPaginas());
		Tabela tabFuncionarios = new Tabela(tabelaFuncionario.getQuantidadePaginas(), tabelaFuncionario.getPaginas());

		OrdenarRegistros(tabVendas);
		OrdenarRegistros(tabFuncionarios);


		ArrayList<Pagina> paginasVendas = new ArrayList<Pagina>();

		for (int j = 0; j < tabVendas.getQuantidadePaginas(); j++) {
			paginasVendas.add(tabVendas.getPaginas().get(j));
		}

		ArrayList<Pagina> paginasFunc = new ArrayList<Pagina>();

		for (int j = 0; j < tabFuncionarios.getQuantidadePaginas(); j++) {
			paginasFunc.add(tabFuncionarios.getPaginas().get(j));
		}

		ArrayList<Pagina> paginasOrdenadasVendas = IntercalaVendas(paginasVendas);
		ArrayList<Pagina> paginasOrdenadasFunc   = IntercalaFuncionario(paginasFunc);


		Tabela tabelaVendasInter = new Tabela(paginasOrdenadasVendas.size(),paginasOrdenadasVendas);
		Tabela tabelaFuncInter   = new Tabela(paginasOrdenadasFunc.size(),paginasOrdenadasFunc);

		tabelaFinal = Juncao(tabelaFuncInter, tabelaVendasInter);

		return tabelaFinal;
	}

	public static void main(String[] args) throws IOException {

		Tabela tabelaFinal;
		Tabela tabelaFuncionario;
		Tabela tabelaVendas;

		tabelaFuncionario = LerArquivoFuncionario();
		tabelaVendas      = LerArquivoVendas();

		tabelaFinal       = SortMerge(tabelaFuncionario, tabelaVendas);

		EscreverTabelaFinal(tabelaFinal);

	}
}