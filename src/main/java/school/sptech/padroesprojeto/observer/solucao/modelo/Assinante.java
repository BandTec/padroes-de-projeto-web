package school.sptech.padroesprojeto.observer.solucao.modelo;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import school.sptech.padroesprojeto.observer.solucao.modelo.observer.Observador;

import java.util.UUID;

public class Assinante implements Observador {

    private UUID id = UUID.randomUUID();
    private String nome;
    private String email;

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void notificarConteudo(JavaMailSender enviador, Conteudo conteudo) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom("java.masters@thunderstack.com");
        email.setTo(this.email);
        email.setSubject(conteudo.getTitulo());
        email.setText(conteudo.getConteudo());

        enviador.send(email);
    }
}
