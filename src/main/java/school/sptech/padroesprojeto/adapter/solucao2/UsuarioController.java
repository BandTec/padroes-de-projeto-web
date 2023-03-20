package school.sptech.padroesprojeto.adapter.solucao2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.padroesprojeto.adapter.solucao2.dto.UsuarioMapper;
import school.sptech.padroesprojeto.adapter.solucao2.dto.UsuarioRespostaDto;
import school.sptech.padroesprojeto.adapter.solucao2.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  private List<Usuario> usuarios = new ArrayList<>();

  @PostMapping
  public UsuarioRespostaDto criar(@RequestBody Usuario novoUsuario) {
    usuarios.add(novoUsuario);
    return UsuarioMapper.converteDto(novoUsuario);
  }

  @GetMapping
  public List<UsuarioRespostaDto> list(){
    return usuarios
            .stream()
            .map(UsuarioMapper::converteDto)
            .collect(Collectors.toList());
  }

}
