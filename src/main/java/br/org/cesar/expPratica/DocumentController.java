package br.org.cesar.expPratica;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {
	
    @Autowired
    private TechnicalReportRepository repository;

    @GetMapping("/{ticketId}")
    public String getDocument(@PathVariable (value = "ticketId") long id){
    	Optional<TechnicalReport> technicalReport = repository.findById(id);
    	if(technicalReport.isPresent()) {
    		return "Documento  encontrado";
    	}
        return "Sem documento";
    }
    
}