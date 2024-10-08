fun main() {
    // criando uma lista para armazenar os orçamentos
    val orcamentos = mutableListOf<Pair<String, Double>>()

    // variável para controlar o loop
    var continuar = "S"

    // loop para coletar dados de várias empresas
    while (continuar.uppercase() == "S") {
        // perguntas para o usuário
        print("qual o nome da empresa? ")
        val nomeEmpresa = readLine() ?: ""  // se não tiver nada, coloca uma string vazia

        print("qual o valor por aparelho? ")
        val valorPorAparelho = readLine()?.toDoubleOrNull() ?: 0.0  // converte para double ou 0.0 se der erro

        print("qual a quantidade de aparelhos? ")
        val quantidadeAparelhos = readLine()?.toIntOrNull() ?: 0  // converte para Int ou 0 se der erro

        print("qual a porcentagem de desconto? ")
        val percentualDesconto = readLine()?.toDoubleOrNull() ?: 0.0  // converte para Double ou 0.0 se der erro

        print("qual o número mínimo de aparelhos para conseguir o desconto? ")
        val minimoAparelhosParaDesconto = readLine()?.toIntOrNull() ?: 0  // converte para Int ou 0 se der erro

        // calculando o valor total
        var valorTotal = valorPorAparelho * quantidadeAparelhos

        // verifica se dá pra aplicar desconto
        if (quantidadeAparelhos >= minimoAparelhosParaDesconto) {
            val desconto = valorTotal * (percentualDesconto / 100)  // calculando o desconto
            valorTotal -= desconto  // subtraindo o desconto do valor total
        }

        // resultado
        println("o serviço de $nomeEmpresa custará R$ %.2f".format(valorTotal))

        // adicionando o orçamento à lista
        orcamentos.add(Pair(nomeEmpresa, valorTotal))

        // perguntando se o usuário quer continuar
        print("deseja informar novos dados? ")
        continuar = readLine() ?: "N"  // Se não tiver nada, coloca 'N'
    }

    // verifica qual orçamento é o menor
    val menorOrcamento = orcamentos.minByOrNull { it.second }
    if (menorOrcamento != null) {
        println("o orçamento de menor valor é o de ${menorOrcamento.first} por R$ %.2f".format(menorOrcamento.second))
    }
}
