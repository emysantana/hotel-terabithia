fun main() {
    val totalQuartos = 20
    val quartos = Array(totalQuartos) { true } // true representa "livre"

    while (true) {
        // entrada do valor da diária
        print("qual o valor padrão da diária?: ")
        val valorDiaria = readLine()?.toDoubleOrNull()
        if (valorDiaria == null || valorDiaria < 0.0) {
            println("valor inválido")
            continue
        }

        // entrada da quantidade de dias
        print("quantas diárias serão necessárias? ")
        val dias = readLine()?.toIntOrNull()
        if (dias == null || dias < 0 || dias > 30) {
            println("valor inválido")
            continue
        }

        val valorTotal = dias * valorDiaria
        println("o valor de $dias dias de hospedagem é de R$$valorTotal")

        // nome do hóspede
        print("qual o nome do hóspede? ")
        val nomeHospede = readLine()

        // escolha do quarto
        var quartoEscolhido: Int
        while (true) {
            print("qual o quarto para reserva? (1 - $totalQuartos)? ")
            quartoEscolhido = readLine()?.toIntOrNull() ?: 0

            if (quartoEscolhido !in 1..totalQuartos) {
                println("número de quarto inválido.")
                continue
            }
            if (!quartos[quartoEscolhido - 1]) {
                println("quarto já está ocupado, escolha outro!")
            } else {
                println("quarto livre!")
                break
            }
        }

        // confirmação da reserva
        print("$nomeHospede, você confirma a hospedagem por $dias dias para o quarto $quartoEscolhido por R$$valorTotal? ")
        val confirmacao = readLine()

        if (confirmacao?.equals("S", ignoreCase = true) == true) {
            quartos[quartoEscolhido - 1] = false // marca como ocupado
            println("$nomeHospede, reserva feita.")
        } else {
            println("reserva não foi confirmada.")
        }

        // uma lista de quartos
        println("a lista de quartos e suas ocupações:")
        for (i in 0 until totalQuartos) {
            println("${i + 1} - ${if (quartos[i]) "livre" else "ocupado"}")
        }

        println("\n--- fim da reserva ---\n")
    }
}