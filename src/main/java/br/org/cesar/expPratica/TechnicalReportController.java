package br.org.cesar.expPratica;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TechnicalReportController {

    private TXTConverter txtConverter = new TXTConverter();
    private JSONConverter jsonConverter = new JSONConverter();

    @Autowired
    private TechnicalReportRepository repository;

    @PostMapping("/report")
    public String insertTechnicalReport (@Validated @RequestBody(required=true) TechnicalReport technicalReport)
            throws InvalidFormatException, IOException {
        XlsxConverter.generateXlsx(technicalReport);

        TechnicalReport result = repository.save(technicalReport);

        return "Cadastro realizado com sucesso! "+technicalReport;
    }

    @GetMapping("{ticketId}/txt")
    public ResponseEntity<InputStreamResource> technicalReportTxt(@PathVariable(value = "ticketId") long id){

        TechnicalReport technicalReport = new TechnicalReport();
        technicalReport.setId(id);
        technicalReport.setName("Aguida");
        technicalReport.setEquipment("TV");
        technicalReport.setDefect("Tela Trincada");
        technicalReport.setDescription("Caiu");

       return txtConverter.technicalReportToResource(technicalReport);
    }

    @GetMapping("{ticketId}/json")
    public ResponseEntity<byte[]> technicalReportJson(@PathVariable(value = "ticketId") long id) throws IOException {

        TechnicalReport technicalReport = new TechnicalReport();
        technicalReport.setId(id);
        technicalReport.setName("Aguida");
        technicalReport.setEquipment("TV");
        technicalReport.setDefect("Tela Trincada");
        technicalReport.setDescription("Caiu");

        return jsonConverter.technicalReportToResource(technicalReport);
    }
}
