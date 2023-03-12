package school.sptech.padroesprojeto.observer.problema.modelo;

import java.util.UUID;

public class Assinante1 {

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
}
