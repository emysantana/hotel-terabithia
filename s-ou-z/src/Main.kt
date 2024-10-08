fun main() {
    val hospedes = mutableListOf<String>()

    while (true) {
        println("selecione uma opção: 1. cadastrar - 2. pesquisar - 3. listar - 4. sair")
        val opcao = readLine()?.toIntOrNull()

        when (opcao) {
            1 -> {
                if (hospedes.size < 15) {
                    print("qual o nome do hóspede? ")
                    val nome = readLine() ?: ""
                    hospedes.add(nome)
                    println("hóspede $nome foi cadastrado(a) com sucesso!")
                } else {
                    println("o máximo de cadastros atingido.")
                }
            }
            2 -> {
                print("qual o nome do hóspede? ")
                val nome = readLine() ?: ""
                if (hospedes.contains(nome)) {
                    println("hóspede $nome foi encontrado.")
                } else {
                    println("hóspede não encontrado.")
                }
            }
            3 -> {
                println("lista de hóspedes:")
                for (hospede in hospedes) {
                    println(hospede)
                }
            }
            4 -> break
            else -> println("opção inválida!")
        }
    }
}
