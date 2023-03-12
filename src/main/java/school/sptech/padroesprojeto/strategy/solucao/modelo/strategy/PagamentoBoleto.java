package school.sptech.padroesprojeto.strategy.solucao.modelo.strategy;

import school.sptech.padroesprojeto.strategy.solucao.modelo.Pagamento;

public class PagamentoBoleto implements PagamentoStrategy {
    @Override
    public double pagar(Pagamento pagamento) {
        final double valor = pagamento.getValor();
        return valor - (valor * 0.1);
    }
}
