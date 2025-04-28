package br.edu.iftm.atividade02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    private Calculadora calculadora;

    /**
     * Testa o construtor sem parâmetro para garantir que a memória seja inicializada com 0.
     */
    @Test
    public void testConstrutorSemParametro_DeveInicializarMemoriaComZero() {
        //arrange
        calculadora = new Calculadora();
        int resultadoEsperado = 0;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa o construtor com parâmetro para garantir que a memória seja inicializada com o valor 3.
     */
    @Test
    public void testConstrutorComParametro_DeveInicializarMemoriaComTres() {
        //arrange
        int resultadoEsperado = 3;
        calculadora = new Calculadora(3);

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa o construtor com parâmetro para garantir que a memória seja inicializada com o valor -3.
     */
    @Test
    public void testConstrutorComParametro_DeveInicializarMemoriaComMenosTres() {
        //arrange
        int resultadoEsperado = -3;
        calculadora = new Calculadora(-3);

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa a soma de um número positivo à memória.
     */
    @Test
    public void testSomarNumeroPositivo() {
        //arrange
        calculadora = new Calculadora(3);
        calculadora.somar(1);
        int resultadoEsperado = 4;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa a soma de um número negativo à memória.
     */
    @Test
    public void testSomarNumeroNegativo() {
        //arrange
        calculadora = new Calculadora(3);
        calculadora.somar(-1);
        int resultadoEsperado = 2;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa a subtração de um número positivo da memória.
     */
    @Test
    public void testSubtrairNumeroPositivo() {
        //arrange
        calculadora = new Calculadora(3);
        calculadora.subtrair(1);
        int resultadoEsperado = 2;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa a subtração de um número negativo da memória.
     */
    @Test
    public void testSubtrairNumeroNegativo() {
        //arrange
        calculadora = new Calculadora(3);
        calculadora.subtrair(-1);
        int resultadoEsperado = 4;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa a multiplicação da memória por um número positivo.
     */
    @Test
    public void testMultiplicarPorNumeroPositivo() {
        //arrange
        calculadora = new Calculadora(3);
        calculadora.multiplicar(2);
        int resultadoEsperado = 6;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa a multiplicação da memória por um número negativo.
     */
    @Test
    public void testMultiplicarPorNumeroNegativo() {
        //arrange
        calculadora = new Calculadora(3);
        calculadora.multiplicar(-1);
        int resultadoEsperado = -6;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa a divisão da memória por um número positivo.
     */
    @Test
    public void testDividirPorNumeroPositivo() throws Exception {
        //arrange
        calculadora = new Calculadora(10);
        calculadora.dividir(2);
        int resultadoEsperado = 5;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa a divisão da memória por um número negativo.
     */
    @Test
    public void testDividirPorNumeroNegativo() throws Exception {
        //arrange
        calculadora = new Calculadora(10);
        calculadora.dividir(-2);
        int resultadoEsperado = -5;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa se a divisão da memória por zero lança uma exceção.
     */
    @Test
    public void testDividirPorZero_DeveLancarExcecao() throws Exception {
        //arrange
        calculadora = new Calculadora(3);

        //assign
        Assertions.assertThrows(Exception.class, () -> {
            calculadora.dividir(0);
        });
    }

    /**
     * Testa a exponenciação da memória por 1, garantindo que o valor permaneça inalterado.
     */
    @Test
    public void testExponenciarPorUm_DeveManterValor() throws Exception {
        //arrange
        calculadora = new Calculadora(3);
        calculadora.exponenciar(1);
        int resultadoEsperado = 3;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa a exponenciação da memória por 10, garantindo que o resultado seja calculado corretamente.
     */
    @Test
    public void testExponenciarPorDez_DeveCalcularCorretamente() throws Exception {
        //arrange
        calculadora = new Calculadora(3);
        calculadora.exponenciar(10);
        int resultadoEsperado = 59049;

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testa se a exponenciação da memória por 20 lança uma exceção.
     */
    @Test
    public void testExponenciarPorVinte_DeveLancarExcecao() {
        //arrange
        calculadora = new Calculadora(3);

        //act
        Assertions.assertThrows(Exception.class, () -> {
            calculadora.exponenciar(20);
        });
    }

    /**
     * Testa o método de zerar a memória para garantir que ela seja definida como 0.
     */
    @Test
    public void testZerarMemoria_DeveZerarMemoria() {
        //arrange
        calculadora = new Calculadora();
        int resultadoEsperado = 0;
        calculadora.zerarMemoria();

        //act
        int resultadoObtido = calculadora.getMemoria();

        //assign
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }
}
