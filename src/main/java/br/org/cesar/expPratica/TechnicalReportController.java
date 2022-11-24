package br.org.cesar.expPratica;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnicalReportController {

    @PostMapping("/report")
    public String insertTechnicalReport (@RequestBody(required=false) TechnicalReport technicalReport){
        return "Cadastro realizado com sucesso!";
    }

}
