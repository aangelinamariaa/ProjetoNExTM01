package br.org.cesar.expPratica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManupulationController{

    @Autowired
    private TechnicalReportRepository repository;

    @DeleteMapping("/delete/{ticketId}")
    public String delDocById(@PathVariable (value = "ticketId") long id){
    	boolean technicalReport = repository.existsById(id);
    	if(technicalReport) {
            repository.deleteById(id);
    		return "Documento excluído do Banco de Dados";
    	}
        return "Documento não localizado";
    }
	
	List<TechnicalReport> technicalReport = new ArrayList<TechnicalReport>();
    @GetMapping("/listAll")
    public List<TechnicalReport> listDocAll(){
        return repository.findAll();
    }
    
}
