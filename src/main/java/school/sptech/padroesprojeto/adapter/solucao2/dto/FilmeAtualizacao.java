package school.sptech.padroesprojeto.adapter.solucao2.dto;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class FilmeAtualizacao {

  private int quantidade;

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
}

@RestController
@RequestMapping("/filmes")
public FilmeController{

  @PatchMapping("{indice}/oscars")
  public Filme atualizaOscar(@RequestBody FilmeAtualizacao filmeAtualizacao){

    Filme filmeExistente = lista.get(indice);
    filmeExistente.setQtdOscar(filmeAtualizacao.getQuantidade())

  }
}
