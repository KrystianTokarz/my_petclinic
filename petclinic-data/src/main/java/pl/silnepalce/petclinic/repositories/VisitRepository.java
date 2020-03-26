package pl.silnepalce.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.silnepalce.petclinic.model.Vet;
import pl.silnepalce.petclinic.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit,Long> {
}
