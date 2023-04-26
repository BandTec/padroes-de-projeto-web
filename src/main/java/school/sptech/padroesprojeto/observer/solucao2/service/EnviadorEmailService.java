package school.sptech.padroesprojeto.observer.solucao2.service;

import org.apache.commons.io.IOUtils;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

@Service
public class EnviadorEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TaskExecutor taskExecutor;

    private static Log log = LogFactory.getLog(EnviadorEmailService.class);

    public void sendEmail(final String remetente, final String destinatario, final String titulo, final String conteudo) {
        taskExecutor.execute(() -> sendMailSimple(remetente, destinatario, titulo, conteudo));
    }

    public String readHtmlTemplate(String template) {
        try {
            return IOUtils.toString(this.getClass().getResourceAsStream(template));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMailSimple(
            final String remetente,
            final String destinatario,
            final String titulo,
            final String conteudo
    ) {

        MimeMessage message = mailSender.createMimeMessage();

        String teste = readHtmlTemplate("/templates/email.html");

        try {

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(remetente);
            helper.setTo(destinatario);
            helper.setSubject(titulo);
            helper.setText(teste, true);

        } catch (MessagingException e) {
            throw new MailParseException(e);
        }

        mailSender.send(message);

        if (log.isDebugEnabled()) {
            log.debug(String.format("Email enviado corretamente para: %s", destinatario));
        }
    }
}
