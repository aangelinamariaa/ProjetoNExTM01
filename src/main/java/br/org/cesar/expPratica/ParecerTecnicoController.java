package br.org.cesar.expPratica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParecerTecnicoController {

    @Autowired
    ParecerTecnicoRepository parecerTecnicoRepository;

    @PostMapping
    public ParecerTecnico createParecerTecnico (@RequestBody ParecerTecnico parecerTecnico){
        parecerTecnicoRepository.save(parecerTecnico);
        return null;
    }


}
