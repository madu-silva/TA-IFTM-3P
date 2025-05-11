package br.edu.iftm.atividade03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTerceirizadoTest {

    private static final String NOME = "João";
    private static final int HORAS_TRABALHADAS = 40;
    private static final double VALOR_HORA = 20;
    private static final double DESPESAS_ADICIONAIS = 100;
    private static final double DESPESAS_ADICIONAIS_INVALIDO_SUPERIOR = 1001;
    private static final String MENSAGEM_ERRO_DESPESAS_ADICIONAIS_SUPERIOR = "Despesas adicionais inválidas, o valor deve ser no máximo R$1000,00.";

    /**
     * <p><b>Cenário:</b> Testa o construtor com um valor de despesas adicionais válida, no meio dos limites</p>
     * <p><b>Entrada:</b> despesasAdicionaisValida = 100 </p>
     * <p><b>Saída esperada:</b> 100 </p>
     */
    @Test
    public void testarConstrutorComDespesasAdicionaisValidoDentroDosLimites() {
        //assign
        double despesasAdicionaisValida = DESPESAS_ADICIONAIS;
        double saidaEsperada = DESPESAS_ADICIONAIS;

        //act
        FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado(NOME, HORAS_TRABALHADAS, VALOR_HORA, despesasAdicionaisValida);
        double saidaObtida = funcionarioTerceirizado.getDespesasAdicionais();

        //assert
        assertEquals(saidaEsperada, saidaObtida);
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com um valor de despesas adicionais inválidas, fora do limite superior</p>
     * <p><b>Entrada:</b> despesasAdicionaisInvalida = 1001 </p>
     * <p><b>Saída esperada:</b> "Despesas adicionais inválidas, o valor deve ser no máximo R$1000,00." </p>
     */
    @Test
    public void testarConstrutorComDespesasAdicionaisForaDoLimiteSuperior() {
        //assign
        double despesasAdicionaisInvalida = DESPESAS_ADICIONAIS_INVALIDO_SUPERIOR;

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioTerceirizado(NOME, HORAS_TRABALHADAS, VALOR_HORA, despesasAdicionaisInvalida)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_DESPESAS_ADICIONAIS_SUPERIOR,
                exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa o setter com um valor de despesas adicionais válida, no meio dos limites</p>
     * <p><b>Entrada:</b> despesasAdicionaisValida = 100 </p>
     * <p><b>Saída esperada:</b> 100 </p>
     */
    @Test
    public void testarSetterComDespesasAdicionaisValidoDentroDosLimites() {
        //assign
        double despesasAdicionaisValida = DESPESAS_ADICIONAIS;
        double saidaEsperada = DESPESAS_ADICIONAIS;

        //act
        FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado();
        funcionarioTerceirizado.setDespesasAdicionais(despesasAdicionaisValida);
        double saidaObtida = funcionarioTerceirizado.getDespesasAdicionais();

        //assert
        assertEquals(saidaEsperada, saidaObtida);
    }

    /**
     * <p><b>Cenário:</b> Testa o setter com um valor de despesas adicionais inválidas, fora do limite superior</p>
     * <p><b>Entrada:</b> despesasAdicionaisInvalida = 1001 </p>
     * <p><b>Saída esperada:</b> "Despesas adicionais inválidas, o valor deve ser no máximo R$1000,00." </p>
     */
    @Test
    public void testarSetterComDespesasAdicionaisForaDoLimiteSuperior() {
        //assign
        double despesasAdicionaisInvalida = DESPESAS_ADICIONAIS_INVALIDO_SUPERIOR;

        //act & assert
        FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                funcionarioTerceirizado.setDespesasAdicionais(despesasAdicionaisInvalida)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_DESPESAS_ADICIONAIS_SUPERIOR,
                exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa o cálculo do pagamento para um funcionário terceirizado com despesas adicionais válidas.</p>
     * <p><b>Entrada:</b> horasTrabalhadas = 40, valorHora = 20,0, despesasAdicionais = 100,0</p>
     * <p><b>Saída esperada:</b> 3310</p>
     */
    @Test
    public void testarCalculoPagamentoComDespesasAdicionaisValidas() {
        //assign
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado(NOME, HORAS_TRABALHADAS, VALOR_HORA, DESPESAS_ADICIONAIS);
        double pagamentoEsperado = 3310;

        //act
        double pagamentoObtido = funcionario.calcularPagamento();

        //assert
        assertEquals(pagamentoEsperado, pagamentoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa o cálculo do pagamento para um funcionário terceirizado quando o valor está abaixo do salário mínimo.</p>
     * <p><b>Entrada:</b> horasTrabalhadas = 5, valorHora = 20,0, despesasAdicionais = 100,0</p>
     * <p><b>Saída esperada:</b> Exceção com mensagem "O pagamento deve ser maior ou igual ao salário mínimo de R$1518,00."</p>
     */
    @Test
    public void testarCalculoPagamentoAbaixoDoSalarioMinimo() {
        //assign
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado(NOME, 5, 20.0, DESPESAS_ADICIONAIS);

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, funcionario::calcularPagamento);

        //assert
        assertEquals("O pagamento deve ser maior ou igual ao salário mínimo de R$1518,00.", exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa o cálculo do pagamento para um funcionário terceirizado quando o valor excede o teto permitido.</p>
     * <p><b>Entrada:</b> horasTrabalhadas = 40, valorHora = 100,00, despesasAdicionais = 1000,00</p>
     * <p><b>Saída esperada:</b> Exceção com mensagem "O pagamento não pode ultrapassar o teto de R$10000,00."</p>
     */
    @Test
    public void testarCalculoPagamentoAcimaDoTeto() {
        //assign
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado(NOME, 40, 100.0, 1000.0);

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, funcionario::calcularPagamento);

        //assert
        assertEquals("O pagamento não pode ultrapassar o teto de R$10000,00.", exception.getMessage());
    }


}