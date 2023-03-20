package school.sptech.padroesprojeto.adapter.problema2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios1")
public class UsuarioController1 {

  private List<Usuario> usuarios = new ArrayList<>();

  @PostMapping
  public Usuario criar(@RequestBody Usuario novoUsuario) {
    usuarios.add(novoUsuario);
    return novoUsuario;
  }

  @GetMapping
  public List<Usuario> list(){
    return usuarios;
  }

}
