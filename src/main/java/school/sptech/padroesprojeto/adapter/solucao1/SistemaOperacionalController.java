package school.sptech.padroesprojeto.adapter.solucao1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.padroesprojeto.adapter.solucao1.modelo.SistemaOperacional;
import school.sptech.padroesprojeto.adapter.solucao1.modelo.adapter.SistemaOperacionalApacheImpl;
import school.sptech.padroesprojeto.adapter.solucao1.modelo.adapter.SistemaOperacionalMetricas;

@RestController
@RequestMapping("/sistemas-operacionais")
public class SistemaOperacionalController {

    /*
        O Adapter é um padrão de projeto estrutural que permite objetos com
        interfaces incompatíveis colaborarem entre si.

        Referência:
        https://refactoring.guru/pt-br/design-patterns/adapter
     */

  @GetMapping("/atual")
  public SistemaOperacional buscar() {
    SistemaOperacionalMetricas sistemaMetricas = new SistemaOperacionalApacheImpl();
    return sistemaMetricas.getSistemaOperacional();
  }
}
