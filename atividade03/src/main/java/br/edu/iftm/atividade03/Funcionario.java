package br.edu.iftm.atividade03;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorHora;

    public Funcionario(){
    }

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
        this.valorHora = validaValorPorHora(valorHora);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = validaValorPorHora(valorHora);
    }

    private int validaHorasTrabalhadas(int horasTrabalhadas) {
        if (horasTrabalhadas < 5) {
            throw new IllegalArgumentException(
                    "Horas inválidas, as horas semanais trabalhadas não podem ser inferiores a 5 horas."
            );
        }
        if (horasTrabalhadas > 40) {
            throw new IllegalArgumentException(
                    "Horas inválidas, as horas semanais trabalhadas não podem ser superiores a 40 horas."
            );
        }
        return horasTrabalhadas;
    }

    private double validaValorPorHora(double valorHora) {
        if (valorHora < 15.18) {
            throw new IllegalArgumentException(
                    "Valor por hora inválida, o valor por hora deve ser no mínimo R$15,18."
            );
        }
        if (valorHora > 151.8) {
            throw new IllegalArgumentException(
                    "Valor por hora inválida, o valor por hora deve ser no máximo R$151,80."
            );
        }
        return valorHora;
    }

    public double calcularPagamento() {
        double salario = (this.horasTrabalhadas * this.valorHora) * 4;
        if (salario < 1518.00) {
            throw new IllegalArgumentException(
                    "O pagamento deve ser maior ou igual ao salário mínimo de R$1518,00."
            );
        } else if (salario > 10000) {
            throw new IllegalArgumentException(
                    "O pagamento não pode ultrapassar o teto de R$10000,00."
            );
        }

        return salario;
    }
}
