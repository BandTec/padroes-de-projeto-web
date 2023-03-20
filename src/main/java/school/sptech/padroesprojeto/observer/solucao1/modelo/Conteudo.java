package school.sptech.padroesprojeto.observer.solucao1.modelo;

import org.springframework.mail.javamail.JavaMailSender;
import school.sptech.padroesprojeto.observer.solucao1.modelo.observer.Observado;
import school.sptech.padroesprojeto.observer.solucao1.modelo.observer.Observador;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conteudo implements Observado {

    private UUID id = UUID.randomUUID();
    private String titulo;
    private String conteudo;

    private List<Observador> assinantes = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void inscrever(Assinante assinante) {
        this.assinantes.add(assinante);
    }

    public List<Observador> getAssinantes() {
        return assinantes;
    }

    @Override
    public void notificarAssinantes(JavaMailSender enviador) {
        for (Observador assinante : assinantes) {
            assinante.notificarConteudo(enviador, this);
        }
    }
}
