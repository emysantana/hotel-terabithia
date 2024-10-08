fun main() {
    print("qual o valor padrão da diária? ")
    val valorDiaria = readLine()?.toDoubleOrNull() ?: return println("valor inválido!")

    val gratuidade = mutableListOf<String>()
    val meia = mutableListOf<String>()
    var total = 0.0
    var numGratuidade = 0
    var numMeia = 0

    while (true) {
        print("qual o nome do hóspede? (ou digite PARE para finalizar) ")
        val nome = readLine()
        if (nome.equals("PARE", ignoreCase = true)) {
            break
        }

        print("qual a idade do hóspede? ")
        val idade = readLine()?.toIntOrNull()

        if (idade == null || idade < 0) {
            println("idade inválida!")
            continue
        }

        println("$nome cadastrado(a) com sucesso.")

        when {
            idade < 6 -> {
                println("$nome possui gratuidade.")
                numGratuidade++
            }
            idade > 60 -> {
                println("$nome paga meia.")
                numMeia++
                total += valorDiaria / 2
            }
            else -> total += valorDiaria
        }
    }

    println("o valor total das hospedagens é: R$$total; $numGratuidade gratuidade(s); $numMeia meia(s).")
}
