import re
#Arina de Jesus Amador Montteiro Sanches - 392476
#Fernanda Bezerra Nascimento - 388834

#Funcao para pegar as opecaocoes de leitura e escrita dos dados
#param conjunto de todas as operacoes da historia
#return um dicionairo contendo as operacoes de leitura e escrita da historia
def CarregarDados(operacoes):
    conjunto_dados = {}
    for i in range(0, len(operacoes)):
        op = operacoes[i][0]
        if op == "r" or op == 'w':
            #posicao refente a letra identificadora do dado
            dado = re.findall('\((.*?)\)',operacoes[i])[0]
            #setar como 0 o TS-READ e o TS-Write
            conjunto_dados[dado] = [0, 0]
    return conjunto_dados

def fomatarDados(dados):
    conjunto_dados = "  "
    for i in dados:
        dado = "<" +str(i)+ "," + str(dados[i][0]) + "," + str(dados[i][1]) + ">" + " "
        conjunto_dados += dado
    return conjunto_dados


def ImprimirOperacoes(operacoes):
    saida = ""
    for i in operacoes:
        saida = saida + i + ": "
        for j in range(0, len(operacoes[i])):
            saida = saida + operacoes[i][j] + " "
        saida += "\n"
    print(saida)


#funcao que implementa a logica do algoritmo timestamp
#parametro: numero_transacao = timestamp da transacao que deseja realizar a operacao / operacao = operacao da historia que o programa
#           deseja realizar / historia = conjunto de todas as operacoes da historia / conjunto_dados = dicionario que contem
#           as operacoes de leitura e escrita da historia / id_dado = dado sobre qual a operacao vai ser realizada /
#           indice_dado = posicao do dado no conjunto das operacoes da historia
def TS_Basico(numero_transacao, operacao, historia, conjunto_operacoes, id_dado, indice_dado):

    if operacao == 'r':
        # Verificar se TS(Tx) < R-TS(dado).TS-Write
        if int(numero_transacao) < conjunto_operacoes[id_dado][1]:

            num_transacao_problema = conjunto_operacoes[id_dado][1]
            op = 'w' + str(num_transacao_problema) + str('(') + str(id_dado) + str(')')
            indice_dado_problema = historia.index(op)
            historia.insert(indice_dado_problema, historia[indice_dado])
            del historia[indice_dado + 1]

            print(str(historia[indice_dado_problema]) + '   Problema encontrado na operacao ' + str(historia[indice_dado_problema]) +
                  ', pois a transacao ' + str(num_transacao_problema) + ' já leu o dado ' + str(id_dado) + '.')
            return 0
        else:
            if(conjunto_operacoes[id_dado][0] < int(numero_transacao)):
                conjunto_operacoes[id_dado][0] = int(numero_transacao)
            return 1

    elif operacao == 'w':

        if int(numero_transacao) < conjunto_operacoes[id_dado][0]:

            num_transacao_problema = conjunto_operacoes[id_dado][0]
            op = 'r' + str(num_transacao_problema) + str('(') + str(id_dado) + str(')')
            indice_dado_problema = historia.index(op)
            historia.insert(indice_dado_problema, historia[indice_dado])
            del historia[indice_dado + 1]
            print(str(historia[indice_dado_problema]) + '   Problema encontrado na operacao ' + str(historia[indice_dado_problema]) +
                  ', pois a transacao ' + str(num_transacao_problema) + ' já leu o dado ' + str(id_dado) + '.')
            return 0

        elif int(numero_transacao) < conjunto_operacoes[id_dado][1]:

            num_transacao_problema = conjunto_operacoes[id_dado][1]
            op = 'w' + str(num_transacao_problema) + str('(') + str(id_dado) + str(')')
            indice_dado_problema = historia.index(op)
            historia.insert(indice_dado_problema, historia[indice_dado])
            del historia[indice_dado + 1]
            print(str(historia[indice_dado_problema]) + '   Problema encontrado na operacao ' + str(historia[indice_dado_problema]) +
                  ', pois a transacao ' + str(num_transacao_problema) + ' já escreveu o dado ' + str(id_dado) + '.')
            return 0
        else:
            conjunto_operacoes[id_dado][1] = int(numero_transacao)
            return 1

def controleConcorrencia(operacoes):

    print("SAIDA:")
    dados = CarregarDados(operacoes)
    print("     ", fomatarDados(dados))
    for i in range(0, len(operacoes)):

        op = operacoes[i][0] #posicao da operacao a ser realizada

        if (op == "r" or op == 'w'):

            transacao = operacoes[i].split("(")[0][1:] #posicao do numero da transacao que faz a operacao sobre o dado

            id_dado = re.findall('\((.*?)\)',operacoes[i])[0] #posicao da letra que identifica o dado

            control = TS_Basico(transacao, op, operacoes, dados, id_dado, i)

            if control == 0: #caso em que ocorreu uma falha
                print("\n \nTENTATIVA:", operacoes, "\n")
                return controleConcorrencia(operacoes)
            print(operacoes[i], fomatarDados(dados)) #imprime a operacao que foi realizada e o estado dos dados

    print("\nRESULTADO:", operacoes, "\n") #imprime a historia final
    return dados


def recuperacaoFalhas(redo, undo, historia):

    transacoes = []
    for i in range(0, len(historia)):
        op = historia[i][0:2]
        if op == 'BT':
            transacoes.append(re.findall('\((.*?)\)', historia[i])[0])

    indice_CP = historia.index("CP()")
    indice_FL = historia.index("FL()")

    for i in range(0, len(transacoes)):
        commit = "CM(" + transacoes[i] + ")"

        if commit in historia:
            indice_commit = historia.index(commit)

            if (indice_commit < indice_FL and indice_commit > indice_CP):
                operacoes_redu = []
                for j in range(0, len(historia)):
                    w = 'w' + str(transacoes[i])
                    if w == historia[j].split("(")[0]:
                        operacoes_redu.append(historia[j])
                    if len(operacoes_redu) > 0:
                        redo["T" + transacoes[i]] = operacoes_redu

            elif (indice_commit > indice_FL):
                op_undo = []
                for j in range(0, len(historia)):
                    w = 'w' + str(transacoes[i])
                    if w == historia[j].split("(")[0]:
                        ind_w = historia.index(historia[j])
                        if (ind_w < indice_FL):
                            op_undo.append(historia[j])
                    if len(op_undo) > 0:
                        undo["T" + transacoes[i]] = op_undo

        else:
            op_undo = []
            for j in range(0, len(historia)):
                w = 'w' + str(transacoes[i])
                if w == historia[j].split("(")[0]:
                    ind_w = historia.index(historia[j])
                    if (ind_w < indice_FL):
                        op_undo.append(historia[j])
                if len(op_undo) > 0:
                    undo["T" + transacoes[i]] = op_undo

#Historias do arquivo texto

#historia = "BT(1),BT(2),r2(x),r1(y),w1(y),r2(y),CP(),w1(z),CM(1),w2(y),FL(),r2(z),w2(z),CM(2)"

#historia = "BT(1),BT(2),BT(3),r3(c),r2(c),r2(b),r1(a),r1(b),w1(c),w2(b),w3(e),CM(3),CP(),r2(d),FL(),CM(2),w1(a),CM(1)"

#historia = "BT(1),BT(2),r2(z),r2(y),w2(y),BT(3),r3(y),r3(z),CP(),r1(x),w1(x),w3(y),w3(z),CM(3),r2(x),r1(y),w1(y),CM(1),FL(),w2(x),CM(2)"

#historia = "BT(1),BT(2),BT(3),r3(y),r3(z),r1(x),w1(x),w3(y),w3(z),CM(3),r2(z),r1(y),w1(y),CM(1),r2(y),CP(),w2(y),r2(x),FL(),w2(x),CM(2)"

#historia = "BT(1),BT(2),r2(y),BT(3),BT(4),r4(x),r1(y),w3(y),w3(z),r4(z),r2(z),CM(2),r1(x),CP(),CM(1),w3(z),FL(),CM(3),w4(y),w4(z),CM(4)"

#historia = "BT(1),BT(2),r2(x),r1(y),w1(x),r2(y),CP(),w1(z),CM(1),w2(y),FL(),r2(z),w2(z),CM(2)"


operacoes = historia.split(",")
dados_iniciais = CarregarDados(operacoes)

print("ENTRADA: ", operacoes, "\n")


dados = controleConcorrencia(operacoes)

redo = {}
undo = {}

recuperacaoFalhas(redo, undo,operacoes)


print("UNDO")
ImprimirOperacoes(undo)
print("REDO")
ImprimirOperacoes(redo)


