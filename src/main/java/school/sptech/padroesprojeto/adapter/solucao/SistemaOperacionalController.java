package school.sptech.padroesprojeto.adapter.solucao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.padroesprojeto.adapter.solucao.modelo.SistemaOperacional;
import school.sptech.padroesprojeto.adapter.solucao.modelo.adapter.SistemaOperacionalLoocaImpl;
import school.sptech.padroesprojeto.adapter.solucao.modelo.adapter.SistemaOperacionalMetricas;

@RestController
@RequestMapping("/sistemas-operacionais")
public class SistemaOperacionalController {

    private SistemaOperacionalMetricas sistemaMetricas;

    @GetMapping("/atual")
    public SistemaOperacional buscar() {
        sistemaMetricas = new SistemaOperacionalLoocaImpl();
        return sistemaMetricas.getSistemaOperacional();
    }
}
