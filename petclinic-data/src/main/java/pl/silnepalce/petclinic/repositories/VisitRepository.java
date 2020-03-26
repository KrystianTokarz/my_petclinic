package pl.silnepalce.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.silnepalce.petclinic.model.Owner;
import pl.silnepalce.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
