package br.org.cesar.expPratica;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document")
public class DocumentController {
	
    @Autowired
    private TechnicalReportRepository repository;
    private String ticketIdRegex = "^([0-9]{17})\\z";


    @GetMapping("/{ticketId}")
    public ResponseEntity getDocument(@PathVariable (value = "ticketId") String id){
        if (!id.matches(ticketIdRegex)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Entrada invalida");
        }
        Long longId = Long.parseLong(id);
        Optional<TechnicalReport> technicalReport = repository.findById(longId);
    	if(technicalReport.isPresent()) {
    		return ResponseEntity.ok("Documento encontrado");
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sem documento");
    }

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
