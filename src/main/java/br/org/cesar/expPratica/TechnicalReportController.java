package br.org.cesar.expPratica;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnicalReportController {

    @PostMapping("/report")
    public String insertTechnicalReport (
    		@RequestBody(required=true) TechnicalReport technicalReport) throws InvalidFormatException, IOException{
        XlsxConverter.generateXlsx(technicalReport);
        return "Cadastro realizado com sucesso! "+technicalReport;
    }

}
