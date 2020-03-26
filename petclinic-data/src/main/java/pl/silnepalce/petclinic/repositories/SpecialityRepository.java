package pl.silnepalce.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.silnepalce.petclinic.model.Speciality;
import pl.silnepalce.petclinic.model.Vet;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
