package school.sptech.padroesprojeto.adapter.solucao1.modelo.adapter;

import org.apache.commons.lang3.SystemUtils;
import school.sptech.padroesprojeto.adapter.solucao1.modelo.SistemaOperacional;

public class SistemaOperacionalApacheImpl implements SistemaOperacionalMetricas {
    @Override
    public SistemaOperacional getSistemaOperacional() {

        SistemaOperacional sistemaOperacional = new SistemaOperacional();

        sistemaOperacional.setNome(SystemUtils.OS_NAME);
        sistemaOperacional.setBase(String.format("%s bits", SystemUtils.OS_ARCH));
        sistemaOperacional.setVersao(SystemUtils.OS_VERSION);

        return sistemaOperacional;
    }
}
