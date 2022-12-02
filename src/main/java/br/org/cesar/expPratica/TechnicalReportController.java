package br.org.cesar.expPratica;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
public class TechnicalReportController {

    private TXTConverter txtConverter = new TXTConverter();
    private JSONConverter jsonConverter = new JSONConverter();
    //private XlsxConverter xlsxConverter = new XlsxConverter();

    @Autowired
    private TechnicalReportRepository repository;

    @PostMapping("/report")
    public String insertTechnicalReport (@Validated @RequestBody(required=true) TechnicalReport technicalReport)
            throws InvalidFormatException, IOException {
        XlsxConverter.generateXlsx(technicalReport);

       // TechnicalReport result = repository.save(technicalReport);
        repository.save(technicalReport);
        return "Cadastro realizado com sucesso! "+technicalReport;
    }

    @GetMapping("{ticketId}/file/{format}")
    public ResponseEntity<?> generateTechnicalReport(@PathVariable(value = "ticketId") long id,
            @PathVariable(value = "format") String format) throws IOException {
    	Optional<TechnicalReport> technicalReport = repository.findById(id);
    	if(technicalReport.isPresent()){
    		switch (format){
    		case "txt":
    			return txtConverter.technicalReportToResource(technicalReport.get());
    		case "json":
    			return jsonConverter.technicalReportToResource(technicalReport.get());
    		//case "xlsx":
    			//return XlsxConverter.technicalReportToResource(technicalReport.get());
            }
        }
        return ResponseEntity.notFound().build();
    }
}
