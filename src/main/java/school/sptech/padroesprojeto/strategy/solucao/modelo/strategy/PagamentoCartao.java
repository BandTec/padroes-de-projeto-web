package school.sptech.padroesprojeto.strategy.solucao.modelo.strategy;

public class PagamentoCartao implements PagamentoStrategy {

    @Override
    public double pagar(double valor) {
        return valor + (valor * 0.1);
    }
}
