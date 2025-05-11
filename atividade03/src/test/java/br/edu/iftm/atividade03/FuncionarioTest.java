package br.edu.iftm.atividade03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FuncionarioTest {

    private static final String NOME = "João";
    private static final int HORAS_TRABALHADAS = 40;
    private static final int HORAS_TRABALHADAS_INVALIDAS_INFERIOR = 4;
    private static final int HORAS_TRABALHADAS_INVALIDAS_SUPERIOR = 41;
    private static final double VALOR_HORA = 20;
    private static final double VALOR_HORA_INVALIDO_INFERIOR = 15.17;
    private static final double VALOR_HORA_INVALIDO_SUPERIOR = 151.81;
    private static final String MENSAGEM_ERRO_HORAS_INFERIOR = "Horas inválidas, as horas semanais trabalhadas não podem ser inferiores a 5 horas.";
    private static final String MENSAGEM_ERRO_HORAS_SUPERIOR = "Horas inválidas, as horas semanais trabalhadas não podem ser superiores a 40 horas.";
    private static final String MENSAGEM_ERRO_VALOR_HORA_INFERIOR = "Valor por hora inválida, o valor por hora deve ser no mínimo R$15,18.";
    private static final String MENSAGEM_ERRO_VALOR_HORA_SUPERIOR = "Valor por hora inválida, o valor por hora deve ser no máximo R$151,80.";

    /**
     * <p><b>Cenário:</b> Testa o construtor com um valor de horas trabalhadas válida, no meio dos limites</p>
     * <p><b>Entrada:</b> horasTrabalhadasValida = 40 </p>
     * <p><b>Saída esperada:</b> 40 </p>
     */
    @Test
    public void testarConstrutorComHorasTrabalhadasValidoDentroDosLimites(){
        //assign
        int horasTrabalhadasValida = HORAS_TRABALHADAS;
        int saidaEsperada = HORAS_TRABALHADAS;

        //act
        Funcionario funcionario = new Funcionario(NOME, horasTrabalhadasValida, VALOR_HORA);
        int saidaObtida = funcionario.getHorasTrabalhadas();

        //assert
        assertEquals(saidaEsperada, saidaObtida);
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com um valor de horas trabalhadas inválidas, fora do limite inferior</p>
     * <p><b>Entrada:</b> horasTrabalhadasInvalida = 4 </p>
     * <p><b>Saída esperada:</b> "Horas inválidas, as horas semanais trabalhadas não podem ser inferiores a 5 horas." </p>
     */
    @Test
    public void testarConstrutorComHorasTrabalhadasForaDoLimiteInferior() {
        //assign
        int horasTrabalhadasInvalida = HORAS_TRABALHADAS_INVALIDAS_INFERIOR;

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Funcionario(NOME, horasTrabalhadasInvalida, VALOR_HORA)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_HORAS_INFERIOR,
                exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com um valor de horas trabalhadas inválidas, fora do limite superior</p>
     * <p><b>Entrada:</b> horasTrabalhadasInvalida = 41 </p>
     * <p><b>Saída esperada:</b> "Horas inválidas, as horas semanais trabalhadas não podem ser superiores a 40 horas." </p>
     */
    @Test
    public void testarConstrutorComHorasTrabalhadasForaDoLimiteSuperior() {
        //assign
        int horasTrabalhadasInvalida = 41;

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Funcionario(NOME, horasTrabalhadasInvalida, VALOR_HORA)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_HORAS_SUPERIOR,
                exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com o valor por hora válida, no meio dos limites</p>
     * <p><b>Entrada:</b> valorHora = 20 </p>
     * <p><b>Saída esperada:</b> 20 </p>
     */
    @Test
    public void testarConstrutorComValorHoraValidoDentroDosLimites(){
        //assign
        double valorHoraValido = VALOR_HORA;
        double saidaEsperada = VALOR_HORA;

        //act
        Funcionario funcionario = new Funcionario(NOME, HORAS_TRABALHADAS, valorHoraValido);
        double saidaObtida = funcionario.getValorHora();

        //assert
        assertEquals(saidaEsperada, saidaObtida);
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com o valor por hora inválida, fora do limite inferior</p>
     * <p><b>Entrada:</b> valorHora = 15.17 </p>
     * <p><b>Saída esperada:</b> "Valor por hora inválida, o valor por hora deve ser no mínimo R$15,18." </p>
     */
    @Test
    public void testarConstrutorComValorHoraForaDoLimiteInferior() {
        //assign
        double valorHoraInvalido = VALOR_HORA_INVALIDO_INFERIOR;

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Funcionario(NOME, HORAS_TRABALHADAS, valorHoraInvalido)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_VALOR_HORA_INFERIOR,
                exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com o valor por hora inválida, fora do limite superior</p>
     * <p><b>Entrada:</b> valorHora = 151.81 </p>
     * <p><b>Saída esperada:</b> "Valor por hora inválida, o valor por hora deve ser no máximo R$151,80." </p>
     */
    @Test
    public void testarConstrutorComValorHoraForaDoLimiteSuperior() {
        //assign
        double valorHoraInvalido = VALOR_HORA_INVALIDO_SUPERIOR;

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Funcionario(NOME, HORAS_TRABALHADAS, valorHoraInvalido)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_VALOR_HORA_SUPERIOR, exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa modificar as horas trabalhadas com um valor válido, no meio dos limites</p>
     * <p><b>Entrada:</b> horasTrabalhadasValida = 40 </p>
     * <p><b>Saída esperada:</b> 40 </p>
     */
    @Test
    public void testarSetHorasTrabalhadasComValorValido() {
        //assign
        Funcionario funcionario = new Funcionario();
        int horasTrabalhadasValida = HORAS_TRABALHADAS;

        //act
        funcionario.setHorasTrabalhadas(horasTrabalhadasValida);

        //assert
        assertEquals(horasTrabalhadasValida, funcionario.getHorasTrabalhadas());
    }

    /**
     * <p><b>Cenário:</b> Testa modificar as horas trabalhadas com um valor inválido, fora do limite inferior</p>
     * <p><b>Entrada:</b> horasTrabalhadasInvalida = 4 </p>
     * <p><b>Saída esperada:</b> "Horas inválidas, as horas semanais trabalhadas não podem ser inferiores a 5 horas." </p>
     */
    @Test
    public void testarSetHorasTrabalhadasComValorInvalidoInferior() {
        //assign
        Funcionario funcionario = new Funcionario();
        int horasTrabalhadasInvalida = HORAS_TRABALHADAS_INVALIDAS_INFERIOR;

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                funcionario.setHorasTrabalhadas(horasTrabalhadasInvalida)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_HORAS_INFERIOR, exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa modificar as horas trabalhadas com um valor inválido, fora do limite superior</p>
     * <p><b>Entrada:</b> horasTrabalhadasInvalida = 41 </p>
     * <p><b>Saída esperada:</b> "Horas inválidas, as horas semanais trabalhadas não podem ser superiores a 40 horas." </p>
     */
    @Test
    public void testarSetHorasTrabalhadasComValorInvalidoSuperior() {
        //assign
        Funcionario funcionario = new Funcionario();
        int horasTrabalhadasInvalida = HORAS_TRABALHADAS_INVALIDAS_SUPERIOR;

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                funcionario.setHorasTrabalhadas(horasTrabalhadasInvalida)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_HORAS_SUPERIOR, exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa modificar o valor por hora com um valor válido, no meio dos limites</p>
     * <p><b>Entrada:</b> valorHora = 20 </p>
     * <p><b>Saída esperada:</b> 20 </p>
     */
    @Test
    public void testarSetValorHoraComValorValido() {
        //assign
        Funcionario funcionario = new Funcionario();
        double valorHoraValido = VALOR_HORA;

        //act
        funcionario.setValorHora(valorHoraValido);

        //assert
        assertEquals(valorHoraValido, funcionario.getValorHora());
    }

    /**
     * <p><b>Cenário:</b> Testa modificar o valor por hora com um valor inválido, fora do limite inferior</p>
     * <p><b>Entrada:</b> valorHora = 14 </p>
     * <p><b>Saída esperada:</b> "Valor por hora inválida, o valor por hora deve ser no mínimo R$15,18." </p>
     */
    @Test
    public void testarSetValorHoraComValorInvalidoInferior() {
        //assign
        Funcionario funcionario = new Funcionario();
        double valorHoraInvalido = 14;

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                funcionario.setValorHora(valorHoraInvalido)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_VALOR_HORA_INFERIOR, exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa modificar o valor por hora com um valor inválido, fora do limite superior</p>
     * <p><b>Entrada:</b> valorHora = 152 </p>
     * <p><b>Saída esperada:</b> "Valor por hora inválida, o valor por hora deve ser no máximo R$151,80." </p>
     */
    @Test
    public void testarSetValorHoraComValorInvalidoSuperior() {
        //assign
        Funcionario funcionario = new Funcionario();
        double valorHoraInvalido = 152;

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                funcionario.setValorHora(valorHoraInvalido)
        );

        //assert
        assertEquals(MENSAGEM_ERRO_VALOR_HORA_SUPERIOR, exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa o cálculo do pagamento com um valor de horas trabalhadas e valor por hora válidos, no meio dos limites</p>
     * <p><b>Entrada:</b> horasTrabalhadas = 40, valorHora = 20 </p>
     * <p><b>Saída esperada:</b> 3200 </p>
     */
    @Test
    public void testarCalculoPagamentoDentroDosLimites() {
        //assign
        Funcionario funcionario = new Funcionario(NOME, HORAS_TRABALHADAS, VALOR_HORA);
        double pagamentoEsperado = 3200;

        //act
        double pagamentoObtido = funcionario.calcularPagamento();

        //assert
        assertEquals(pagamentoEsperado, pagamentoObtido);
    }

    //javadoc desse metodo
    /**
     * <p><b>Cenário:</b> Testa o cálculo do pagamento invalido, fora do limite inferior</p>
     * <p><b>Entrada:</b> horasTrabalhadas = 5, valorHora = 20 </p>
     * <p><b>Saída esperada:</b> "O pagamento deve ser maior ou igual ao salário mínimo de R$1518,00." </p>
     */
    @Test
    public void testarCalculoPagamentoAbaixoDoSalarioMinimo() {
        //assign
        Funcionario funcionario = new Funcionario(NOME, 5, 20);

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, funcionario::calcularPagamento);

        //assert
        assertEquals("O pagamento deve ser maior ou igual ao salário mínimo de R$1518,00.", exception.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa o cálculo do pagamento invalido, fora do limite superior</p>
     * <p><b>Entrada:</b> horasTrabalhadas = 40, valorHora = 100 </p>
     * <p><b>Saída esperada:</b> "O pagamento não pode ultrapassar o teto de R$10000,00." </p>
     */
    @Test
    public void testarCalculoPagamentoAcimaDoTeto() {
        //assign
        Funcionario funcionario = new Funcionario(NOME, 40, 100.0);

        //act & assert
        Exception exception = assertThrows(IllegalArgumentException.class, funcionario::calcularPagamento);

        //assert
        assertEquals("O pagamento não pode ultrapassar o teto de R$10000,00.", exception.getMessage());
    }

}
