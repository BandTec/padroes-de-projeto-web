package school.sptech.padroesprojeto.observer.solucao1.modelo.observer;

import org.springframework.mail.javamail.JavaMailSender;
import school.sptech.padroesprojeto.observer.solucao1.modelo.Conteudo;

public interface Observador {
    void notificarConteudo(JavaMailSender enviador, Conteudo conteudo);
}
