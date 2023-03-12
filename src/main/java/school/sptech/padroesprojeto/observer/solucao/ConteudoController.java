package school.sptech.padroesprojeto.observer.solucao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.padroesprojeto.observer.solucao.modelo.Assinante;
import school.sptech.padroesprojeto.observer.solucao.modelo.Conteudo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/conteudos")
public class ConteudoController {

    @Autowired
    private JavaMailSender enviador;

    private List<Conteudo> conteudos = new ArrayList<>();

    @GetMapping
    public List<Conteudo> listar() {
        return conteudos;
    }

    @PostMapping
    public String criar(@RequestBody Conteudo conteudo1) {
        this.conteudos.add(conteudo1);
        return "Conteudo criado";
    }

    @PostMapping("/{idConteudo}/assinantes")
    public String assinar(
            @PathVariable UUID idConteudo,
            @RequestBody Assinante assinante
    ) {
        Conteudo conteudo = buscarConteudo(idConteudo);
        conteudo.inscrever(assinante);
        return "Conteudo criado";
    }

    @PostMapping("/{idConteudo}/publicacao")
    public String publicar(@PathVariable UUID idConteudo) {
        Conteudo conteudo = buscarConteudo(idConteudo);
        conteudo.notificarAssinantes(enviador);
        return String.format("Conteúdo %s publicado", idConteudo);
    }

    private Conteudo buscarConteudo(UUID id) {

        return conteudos.stream()
                .filter(conteudo -> conteudo.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Conteudo não encontrado")
                );
    }
}
