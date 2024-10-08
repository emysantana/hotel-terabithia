fun main() {
    // onde vai ser o evento?
    println("quantidade de convidados")
    print("qual o número de convidados para o seu evento? ")
    val numeroConvidados = readLine()?.toIntOrNull() ?: -1 // se for inválido, coloca -1

    if (numeroConvidados > 350 || numeroConvidados < 0) {
        println("número de convidados inválido!")
    } else {
        if (numeroConvidados <= 150) {
            val cadeirasAdicionais = 0
            println("use o auditório Laranja (inclua mais $cadeirasAdicionais cadeiras)")
        } else if (numeroConvidados <= 220) {
            val cadeirasAdicionais = numeroConvidados - 150
            println("Use o auditório Laranja (inclua mais $cadeirasAdicionais cadeiras)")
        } else {
            println("use o auditório Colorado")
        }
        println("agora vamos ver a agenda do evento!")

        // quando será o evento?
        println("agenda")
        print("qual o dia do evento? ")
        val diaEvento = readLine() ?: ""

        print("qual é a hora do evento? ")
        val horaEvento = readLine()?.toIntOrNull() ?: -1

        if (isAuditórioDisponível(diaEvento, horaEvento)) {
            print("qual o nome da empresa? ")
            val nomeEmpresa = readLine() ?: ""
            println("auditório reservado para $nomeEmpresa. $diaEvento às ${horaEvento}hs.")

            // quantos trabalharão no evento?
            println("Parte 3: Garçons")
            print("qual a duração do evento em horas? ")
            val duracaoEvento = readLine()?.toIntOrNull() ?: 0

            val numGarcons = calcularGarcons(numeroConvidados, duracaoEvento)
            val custoGarcons = numGarcons * 10.50 * duracaoEvento // custo total com garçons
            println("são necessários $numGarcons garçons.")
            println("custo: R$ $custoGarcons")

            // buffet
            println("buffet")
            val (litrosCafe, litrosAgua, quantidadeSalgados) = calcularBuffet(numeroConvidados)
            println("o evento precisará de $litrosCafe litros de café, $litrosAgua litros de água, $quantidadeSalgados salgados.")

            // cálculo de custos do buffet
            val custoBuffet = calcularCustoBuffet(litrosCafe, litrosAgua, quantidadeSalgados)
            println("custo do buffet: R$ $custoBuffet")

            // relatório final
            println("conferência")
            println("evento no auditório ${if (numeroConvidados <= 220) "Laranja" else "Colorado"}.")
            println("nome da empresa: $nomeEmpresa.")
            println("data: $diaEvento, ${horaEvento}H às ${horaEvento + duracaoEvento}h.")
            println("duração do evento: $duracaoEvento H.")
            println("quantidade de garçons: $numGarcons.")
            println("quantidade de convidados: $numeroConvidados")
            println("custo do garçons: R$ $custoGarcons")
            println("custo do buffet: R$ $custoBuffet")
            val valorTotal = custoGarcons + custoBuffet
            println("valor total do evento: R$ $valorTotal")

            // pergunta para efetuar a reserva
            print("gostaria de efetuar a reserva? ")
            val efetuarReserva = readLine()
            if (efetuarReserva.equals("S", ignoreCase = true)) {
                println("$nomeEmpresa, reserva efetuada com sucesso.")
            } else {
                println("reserva não foi efetuada!")
            }
        } else {
            println("auditório indisponível.")
        }
    }
}

fun isAuditórioDisponível(dia: String, hora: Int): Boolean {
    return when (dia) {
        "segunda", "terca", "quarta", "quinta", "sexta" -> hora in 7..23
        "sabado", "domingo" -> hora in 7..15
        else -> false
    }
}

fun calcularGarcons(numeroConvidados: Int, duracaoEvento: Int): Int {
    val garconsPorConvidado = Math.ceil(numeroConvidados / 12.0).toInt()
    val garconsPorDuracao = Math.ceil(duracaoEvento / 2.0).toInt()
    return garconsPorConvidado + garconsPorDuracao
}

fun calcularBuffet(numeroConvidados: Int): Triple<Double, Double, Int> {
    val litrosCafe = numeroConvidados * 0.2
    val litrosAgua = numeroConvidados * 0.5
    val quantidadeSalgados = numeroConvidados * 7
    return Triple(litrosCafe, litrosAgua, quantidadeSalgados)
}

fun calcularCustoBuffet(litrosCafe: Double, litrosAgua: Double, quantidadeSalgados: Int): Double {
    val custoCafe = litrosCafe * 0.80
    val custoAgua = litrosAgua * 0.40
    val custoSalgados = (quantidadeSalgados / 100) * 34
    return custoCafe + custoAgua + custoSalgados
}
