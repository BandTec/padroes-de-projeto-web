package school.sptech.padroesprojeto.observer.problema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.padroesprojeto.observer.problema.modelo.Assinante1;
import school.sptech.padroesprojeto.observer.problema.modelo.Conteudo1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/conteudos1")
public class ConteudoController1 {

    @Autowired
    private JavaMailSender javaMailSender;

    private List<Conteudo1> conteudos = new ArrayList<>();
    private List<Assinante1> assinantes = new ArrayList<>();

    @GetMapping
    public List<Conteudo1> listarConteudos() {
        return this.conteudos;
    }

    @GetMapping("/assinantes")
    public List<Assinante1> listarAssinantes(){
        return this.assinantes;
    }

    @PostMapping
    public String criar(@RequestBody Conteudo1 conteudo1) {
        this.conteudos.add(conteudo1);
        return "Conteudo criado";
    }

    @PostMapping("/assinantes")
    public String assinar(@RequestBody Assinante1 assinante1) {
        this.assinantes.add(assinante1);
        return "Newsletter assinado";
    }

    @PostMapping("/{idAssinante}/{idConteudo}")
    public String notificar(@PathVariable UUID idAssinante, @PathVariable UUID idConteudo) {

        Conteudo1 conteudo1 = buscarConteudo(idConteudo);
        Assinante1 assinante1 = buscarAssinante(idAssinante);

        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom("java.masters@thunderstack.com");
        email.setTo(assinante1.getEmail());
        email.setSubject(conteudo1.getTitulo());
        email.setText(conteudo1.getConteudo());

        javaMailSender.send(email);

        return "Mensagem enviada!";
    }

    // Métodos auxiliares

    private Assinante1 buscarAssinante(UUID id) {

        return assinantes.stream().filter(assinante1 -> assinante1.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Assinante não encontrado")
                );
    }

    private Conteudo1 buscarConteudo(UUID id) {

        return conteudos.stream().filter(conteudo1 -> conteudo1.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Conteudo não encontrado")
                );
    }
}
