package school.sptech.padroesprojeto.observer.solucao.modelo.observer;

import org.springframework.mail.javamail.JavaMailSender;

public interface Observado {
    void notificarAssinantes(JavaMailSender enviador);
}
