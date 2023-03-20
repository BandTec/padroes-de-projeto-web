package school.sptech.padroesprojeto.adapter.problema1;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sistemas-operacionais1")
public class SistemaOperacionalController1 {

    @GetMapping("/atual1")
    public Sistema buscarLooca() {
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();
        return sistema;
    }


//    @GetMapping("/atual2")
    public Map<String, String> buscarApache() {
        Map<String, String> mapa = new HashMap<>();

        mapa.put("nome", SystemUtils.OS_NAME);
        mapa.put("base", SystemUtils.OS_ARCH);
        mapa.put("versao", SystemUtils.OS_VERSION);

        return mapa;
    }

}
