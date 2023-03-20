package school.sptech.padroesprojeto.adapter.solucao2.dto;


import school.sptech.padroesprojeto.adapter.solucao2.modelo.Usuario;

public class UsuarioMapper {

  public static UsuarioRespostaDto converteDto(Usuario usuario) {

    UsuarioRespostaDto usuarioRespostaDto = new UsuarioRespostaDto();

    usuarioRespostaDto.setNome(usuario.getNome());
    usuarioRespostaDto.setEmail(usuario.getEmail());

    return usuarioRespostaDto;
  }
}
