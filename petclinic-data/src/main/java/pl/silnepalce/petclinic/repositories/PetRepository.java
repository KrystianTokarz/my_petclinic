package pl.silnepalce.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.silnepalce.petclinic.model.Owner;
import pl.silnepalce.petclinic.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet,Long> {
}
