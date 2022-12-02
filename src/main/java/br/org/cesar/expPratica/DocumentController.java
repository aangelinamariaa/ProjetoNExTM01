package br.org.cesar.expPratica;

import java.util.Optional;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {
	
    @Autowired
    private TechnicalReportRepository repository;

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
