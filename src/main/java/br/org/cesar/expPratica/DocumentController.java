package br.org.cesar.expPratica;

//import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @GetMapping("/{ticketId}")
    public String getDocument(@PathVariable (value = "ticketId") long id){
        return "API para geração automática de Parecer Técnico";
    }
}