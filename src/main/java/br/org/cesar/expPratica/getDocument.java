package br.org.cesar.expPratica;

//import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiv1")
public class getDocument {

    @GetMapping("/quemSouEu")
    public String whoami() {
        return "API para geração automática de Parecer Técnico";
    }

//   @GetMapping("/document/{varId}")
//   public ResponseEntity<> getParTecById(@PathVariable(value = "varId") long id) {
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getId() == id) {
//                return new ResponseEntity<User>(users.get(i), HttpStatus.OK);// status 200
//            }
//        }
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);// status 404
//       return (HttpStatus.OK);// status 404
//    }
}
