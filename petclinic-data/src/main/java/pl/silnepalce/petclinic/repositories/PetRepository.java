package pl.silnepalce.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.silnepalce.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
