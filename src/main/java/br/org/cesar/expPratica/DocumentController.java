package br.org.cesar.expPratica;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @GetMapping("/ticketId")
    public String getDocument(@PathVariable (value = "ticketId") long id){
        long ticketId;
        ticketId = id;
        
        for(int i = 0; i < TechnicalReport.length; i ++){
            if (ticketId == TechnicalReport.getId){
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
}