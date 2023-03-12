package school.sptech.padroesprojeto.strategy.solucao;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.padroesprojeto.strategy.solucao.modelo.Pagamento;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @PostMapping("/valor")
    public String gerarPagamento(@RequestBody Pagamento pagamento) {
        return String.format("PAGAMENTO VIA: %s - Valor final: R$%s", pagamento.getTipo(), pagamento.calcular());
    }
}
