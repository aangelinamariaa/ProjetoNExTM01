package br.org.cesar.expPratica;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TechnicalReportController {
    private JSONConverter jsonConverter = new JSONConverter();

    @Autowired
    private TechnicalReportRepository repository;

    @PostMapping("/report")
    public String insertTechnicalReport (@Validated @RequestBody(required=true) TechnicalReport technicalReport)
            throws InvalidFormatException, IOException{
        XlsxConverter.generateXlsx(technicalReport);
        TechnicalReport result = repository.save(technicalReport);

        return "Cadastro realizado com sucesso! "+technicalReport;
    }

    @PostMapping("/txt")
    public String technicalReportTxt(@Validated @RequestBody(required=true)
                                         TechnicalReport technicalReport) throws IOException {

        TXTConverter.technicalReportToResource(technicalReport);

        return "ok - txt";
    }

   @PostMapping("json")
    public String technicalReportJson(@Validated @RequestBody(required=true)
                                          TechnicalReport technicalReport) throws IOException {

        JSONConverter.technicalReportToResource(technicalReport);

        return "ok - json";
    }


}
