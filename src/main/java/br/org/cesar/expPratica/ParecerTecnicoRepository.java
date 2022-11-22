package br.org.cesar.expPratica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParecerTecnicoRepository extends JpaRepository<ParecerTecnico, Long> {
}
































//Exemplo gerson - nesse caso não preciso ter um controller
//@RepositoryRestResource(collectionResourceRel = "car", path = "car")
//public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
//
//}