package school.sptech.padroesprojeto.observer.solucao2.modelo.observer;

import school.sptech.padroesprojeto.observer.solucao2.modelo.Newsletter;
import school.sptech.padroesprojeto.observer.solucao2.service.EnviadorEmailService;

public interface Assinante {

    void receberNewsletter(EnviadorEmailService enviadorEmailService, Newsletter newsletter);
}
