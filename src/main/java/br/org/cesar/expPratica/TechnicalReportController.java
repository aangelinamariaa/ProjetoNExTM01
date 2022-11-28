package br.org.cesar.expPratica;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnicalReportController {

    @Autowired
    private TechnicalReportRepository repository;

    @PostMapping("/report")
    public String insertTechnicalReport (@Validated @RequestBody(required=true) TechnicalReport technicalReport)
            throws InvalidFormatException, IOException{
        XlsxConverter.generateXlsx(technicalReport);
        TechnicalReport result = repository.save(technicalReport);
        return "Cadastro realizado com sucesso! "+technicalReport;
    }

}
