package school.sptech.padroesprojeto.observer.problema.modelo;

import java.util.UUID;

public class Conteudo1 {

    private UUID id = UUID.randomUUID();
    private String titulo;
    private String conteudo;

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
}
