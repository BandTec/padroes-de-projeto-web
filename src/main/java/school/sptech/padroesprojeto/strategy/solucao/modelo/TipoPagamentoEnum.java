package school.sptech.padroesprojeto.strategy.solucao.modelo;

import school.sptech.padroesprojeto.strategy.solucao.modelo.strategy.PagamentoBoleto;
import school.sptech.padroesprojeto.strategy.solucao.modelo.strategy.PagamentoCartao;
import school.sptech.padroesprojeto.strategy.solucao.modelo.strategy.PagamentoPix;
import school.sptech.padroesprojeto.strategy.solucao.modelo.strategy.PagamentoStrategy;

public enum TipoPagamentoEnum {

    CARTAO(new PagamentoCartao()),
    BOLETO(new PagamentoBoleto()),
    PIX(new PagamentoPix());

    private PagamentoStrategy estrategia;

    TipoPagamentoEnum(PagamentoStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public PagamentoStrategy getEstrategia() {
        return estrategia;
    }
}
