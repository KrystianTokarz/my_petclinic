package pl.silnepalce.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.silnepalce.petclinic.model.Pet;
import pl.silnepalce.petclinic.model.PetType;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
