package school.sptech.padroesprojeto.adapter.solucao1.modelo.adapter;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import school.sptech.padroesprojeto.adapter.solucao1.modelo.SistemaOperacional;

public class SistemaOperacionalLoocaImpl implements SistemaOperacionalMetricas {

    private Looca looca = new Looca();

    @Override
    public SistemaOperacional getSistemaOperacional() {

        SistemaOperacional sistemaOperacional = new SistemaOperacional();

        Sistema sistemaLooca = this.looca.getSistema();

        sistemaOperacional.setNome(sistemaLooca.getSistemaOperacional());
        sistemaOperacional.setBase(String.format("%s bits", sistemaLooca.getArquitetura()));
        sistemaOperacional.setVersao(sistemaLooca.getFabricante());

        return sistemaOperacional;
    }
}
