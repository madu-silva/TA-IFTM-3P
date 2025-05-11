package br.edu.iftm.atividade03;

public class FuncionarioTerceirizado extends Funcionario{

    private double despesasAdicionais;

    public FuncionarioTerceirizado(){
    }

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, double valorHora, double despesasAdicionais) {
        super(nome, horasTrabalhadas, valorHora);
        setDespesasAdicionais(despesasAdicionais);
    }

    public double getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(double despesasAdicionais) {
        this.despesasAdicionais = validaDespesasAdicionais(despesasAdicionais);
    }

    private double validaDespesasAdicionais(double despesasAdicionais) {
        if (despesasAdicionais > 1000) {
            throw new IllegalArgumentException(
                    "Despesas adicionais inválidas, o valor deve ser no máximo R$1000,00."
            );
        }
        return despesasAdicionais;
    }

    @Override
    public double calcularPagamento() {
        return super.calcularPagamento() + 1.1 * despesasAdicionais;
    }
}
