package school.sptech.padroesprojeto.strategy.solucao.modelo.strategy;

import school.sptech.padroesprojeto.strategy.solucao.modelo.Pagamento;

public interface PagamentoStrategy {
    double pagar(Pagamento pagamento);
}
