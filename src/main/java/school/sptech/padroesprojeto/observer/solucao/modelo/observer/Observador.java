package school.sptech.padroesprojeto.observer.solucao.modelo.observer;

import org.springframework.mail.javamail.JavaMailSender;
import school.sptech.padroesprojeto.observer.solucao.modelo.Conteudo;

public interface Observador {
    void notificarConteudo(JavaMailSender enviador, Conteudo conteudo);
}
