fun main() {
    // coletar os preços dos combustíveis
    print("qual o valor do álcool no posto Wayne Oil? ")
    val precoAlcoolWayne = readLine()?.toDoubleOrNull() ?: 0.0

    print("qual o valor da gasolina no posto Wayne Oil? ")
    val precoGasolinaWayne = readLine()?.toDoubleOrNull() ?: 0.0

    print("qual o valor do álcool no posto Stark Petrol? ")
    val precoAlcoolStark = readLine()?.toDoubleOrNull() ?: 0.0

    print("qual o valor da gasolina no posto Stark Petrol? ")
    val precoGasolinaStark = readLine()?.toDoubleOrNull() ?: 0.0

    // calcule o custo para abastecer o carro
    val tanqueLitros = 42.0 // O tanque do carro tem 42 litros

    // cálculo dos custos de abastecimento
    val custoAlcoolWayne = precoAlcoolWayne * tanqueLitros
    val custoGasolinaWayne = precoGasolinaWayne * tanqueLitros
    val custoAlcoolStark = precoAlcoolStark * tanqueLitros
    val custoGasolinaStark = precoGasolinaStark * tanqueLitros

    // verifica qual combustível é mais barato
    var melhorOpcao = ""

    // verifica se é mais barato abastecer com álcool no Wayne Oil
    if (precoAlcoolWayne <= precoGasolinaWayne * 0.7) {
        melhorOpcao = "álcool no posto Wayne Oil"
    }

    // verifica se é mais barato abastecer com álcool no Stark Petrol
    if (precoAlcoolStark <= precoGasolinaStark * 0.7) {
        melhorOpcao = "álcool no posto Stark Petrol"
    }

    // se nenhuma das opções anteriores for melhor, verifica qual posto é mais barato
    if (melhorOpcao.isEmpty()) {
        if (custoGasolinaWayne < custoGasolinaStark && custoGasolinaWayne < custoAlcoolWayne && custoGasolinaWayne < custoAlcoolStark) {
            melhorOpcao = "gasolina no posto Wayne Oil"
        } else if (custoGasolinaStark < custoGasolinaWayne && custoGasolinaStark < custoAlcoolWayne && custoGasolinaStark < custoAlcoolStark) {
            melhorOpcao = "gasolina no posto Stark Petrol"
        } else if (custoAlcoolWayne < custoAlcoolStark) {
            melhorOpcao = "álcool no posto Wayne Oil"
        } else {
            melhorOpcao = "álcool no posto Stark Petrol"
        }
    }

    // exibir o resultado
    println("é mais barato abastecer com $melhorOpcao.")
}
