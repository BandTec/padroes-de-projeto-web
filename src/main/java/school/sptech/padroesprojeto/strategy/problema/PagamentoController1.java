package school.sptech.padroesprojeto.strategy.problema;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos1")
public class PagamentoController1 {

    @PostMapping("/valor")
    public String gerarPagamento(@RequestBody Pagamento1 pagamento1) {

        final String tipoPagamento = pagamento1.getTipo();
        final double valor = pagamento1.getValor();
        final double valorFinal;

        if (tipoPagamento.equals("Boleto")) {
            valorFinal = valor - (valor * 0.1);
        } else if (tipoPagamento.equals("Cartao")) {
            valorFinal = valor + (valor * 0.1);
        } else {
            valorFinal = valor - (valor * 0.2);
        }

        return String.format("PAGAMENTO VIA: %s - Valor final: R$%s", pagamento1.getTipo(), valorFinal);
    }
}
