package br.org.cesar.expPratica;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
=======
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.springframework.http.*;
>>>>>>> 2ea18ac (gerar identificador + correcao arquivo pom)
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {
	
    @Autowired
    private TechnicalReportRepository repository;

<<<<<<< HEAD
    @GetMapping("/{ticketId}")
    public String getDocument(@PathVariable (value = "ticketId") long id){
    	Optional<TechnicalReport> technicalReport = repository.findById(id);
    	if(technicalReport.isPresent()) {
    		return "Documento  encontrado";
    	}
        return "Sem documento";
    }
    
}
=======
    @GetMapping("/get/{ticketId}")
    public String getDocById(@PathVariable (value = "ticketId") long id){
        return "Id localizado: " + id;
    }

    @GetMapping()
    public String getId(){
        String ticket = idGeneretor();
        return "Número Id gerado: " + ticket;
    }

    private String idGeneretor() {
        SimpleDateFormat dataTimeAtual = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        String numTicket = dataTimeAtual.format(date);
        return numTicket;
    }

}
>>>>>>> 2ea18ac (gerar identificador + correcao arquivo pom)
