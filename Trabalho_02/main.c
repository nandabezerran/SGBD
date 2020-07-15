//Alunas: Arina Sanches - 392476 e Fernanda Bezerra Nascimento - 388834
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define QuantidadeRegistros 16
#define TamanhoStringArquivo 50
#define QuantidadePaginasAuxiliar 2500
#define QuantidadePaginasPrincipal 625


//TODO ponteiro pra void, fazer casting pro que eu quero

typedef struct   Registro Registro;
typedef struct   Pagina   Pagina;
typedef struct   Tabela   Tabela;
typedef struct   TabelaPrincipal TabelaPrincipal;
typedef struct   TabelaAuxiliar TabelaAuxiliar;

struct TabelaPrincipal{
    int   IdFuncionario;
    char  *NomeFuncionario;
    char  *Sobrenome;
    int   IdadeFuncionario;
};

struct TabelaAuxiliar{
    int   IdFuncionario;
    int   IdVenda;
    int   QuantidadeProduto;
    char* NomeProduto[60];
};

struct Registro{
    TabelaPrincipal TabelaPrincipal;
    TabelaAuxiliar  TabelaAuxiliar;
    int             TipoDoRegistro;
};

struct Pagina{
    Registro Registro[QuantidadeRegistros];
};

struct Tabela{
    Pagina Pagina[625];
    int    QuantidadePaginas;
};

Tabela LRArquivoFuncionarios () {
    Tabela TabelaFuncionarios;
    TabelaFuncionarios.QuantidadePaginas = QuantidadePaginasPrincipal;
    //TODO alocar cada pagina
    char buff[TamanhoStringArquivo];
    char token[100];
    const char s[2] = ",";
    char *linha;
    int elementoConvertido;


    FILE *arq = fopen("C:\\Users\\fbeze\\Desktop\\Faculdade\\SGBD\\Trabalho_02\\data_Funcionario.txt", "rt");
    while (!feof(arq)){
        for (int k = 0; k < QuantidadePaginasPrincipal; ++k) {
            for (int i = 0; i < QuantidadeRegistros; ++i) {

                linha = fgets(buff, TamanhoStringArquivo, arq);

                strcpy(token, strtok(linha, s));
                elementoConvertido = atoi(token);
                TabelaFuncionarios.Pagina[k].Registro[i].TabelaPrincipal.IdFuncionario = elementoConvertido ;

                strcpy(token,strtok(NULL, s));
                TabelaFuncionarios.Pagina[k].Registro[i].TabelaPrincipal.NomeFuncionario = token;
                strcpy(token,strtok(NULL, s));
                TabelaFuncionarios.Pagina[k].Registro[i].TabelaPrincipal.Sobrenome = token;

                strcpy(token, strtok(NULL, s));
                elementoConvertido = atoi(token);
                TabelaFuncionarios.Pagina[k].Registro[i].TabelaPrincipal.IdadeFuncionario = elementoConvertido;
            }
        }
    }

    fclose(arq);

    return TabelaFuncionarios;
}

int main() {
    Tabela TabelaFuncionarios = LRArquivoFuncionarios();
    printf("Hello, World!\n");
    return 0;
}